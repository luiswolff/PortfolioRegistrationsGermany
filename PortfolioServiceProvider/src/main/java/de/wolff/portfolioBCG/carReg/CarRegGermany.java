package de.wolff.portfolioBCG.carReg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.wolff.portfolioBCG.MarketData;
import de.wolff.portfolioBCG.Portfolio;
import de.wolff.portfolioBCG.modells.Manufacture;
import de.wolff.portfolioBCG.modells.Period;
import de.wolff.portfolioBCG.modells.PeriodBrand;
import de.wolff.portfolioBCG.modells.PeriodSBU;

public class CarRegGermany implements MarketData {

	private static String files = "data/registration";

	private static String[] periods = {"2011", "2012", "2013" };

	private BrandMapper bm = new BrandMapper();

	private ArrayList<Period> pal = new ArrayList<>();

	private Manufacture we = new Manufacture("Daimler AG");
	
	private GrowthCalculator gc = new GrowthCalculator();

	public CarRegGermany() {

		for (String period : periods) {
			Period p = readPeriod(period);
			pal.add(p);
		}

	}

	@Override
	public List<Period> getPeriods() {
		return pal;
	}

	@Override
	public int getPeriodsCount() {
		return pal.size();
	}

	@Override
	public Manufacture getCompany() {
		return we;
	}

	@Override
	public float getTargetGrowth() {
		float growth = gc.avg();
		return (growth > 0) ? (int) growth : 0;
	}

	public static void main(String[] args) {
		Portfolio.analyseData(CarRegGermany.class.getName(), args);
	}

	private Period readPeriod(String period) {
		Period p = new Period(period);
		FileReader fr;
		try {
			fr = new FileReader(files + period + ".csv");
		} catch (FileNotFoundException fnfe) {
			throw new RuntimeException(fnfe);
		}
		BufferedReader br = new BufferedReader(fr);

		try {
			String line;
			PeriodSBU sbu = null;
			while ((line = br.readLine()) != null) {
				String[] e = line.split(";");
				if (e[0].trim().equalsIgnoreCase("marke") || e[0].trim().equalsIgnoreCase("sonstige")){
					continue;
				} else if (isSegmentLine(e)) {
					sbu = getEntry(p.getSBUs(), new PeriodSBU(e[0].trim(), we));
				} else {
					if (e[0].trim().equalsIgnoreCase("zusammen")) {
						sbu.setMarketGrowth(Float.parseFloat(e[8].trim()
								+ e[9].trim().replace(",",".")));
						gc.addNum(sbu.getMarketGrowth());
					} else {
						String name = e[0].trim();
						float regs = Float.parseFloat(e[6].replace(" ", ""));
						Manufacture m = bm.getMakerOF(name);
						sbu.addBrand(new PeriodBrand(name, m, regs));
						p.setCompanyTurnover(p.getCompanyTurnover() + regs);
					}
				}
			}
			br.close();
		} catch (IOException ie) {
			throw new RuntimeException(ie);
		}

		return p;
	}

	private boolean isSegmentLine(String[] e) {
		if (e[0].trim().isEmpty()) {
			return false;
		}
		for (int i = 1; i < e.length; i++) {
			if (!e[i].trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	private <T extends Object> T getEntry(List<T> list, T obj) {
		int index = list.indexOf(obj);
		if (index != -1) {
			return list.get(index);
		} else {
			list.add(obj);
			return obj;
		}
	}
	
	public static class GrowthCalculator{
		
		private float numerator = 0;
		
		private int denominator = 0;
		
		public void addNum(float num){
			numerator += num;
			denominator++;
		}
		
		public float avg(){
			return numerator / denominator;
		}
		
	}

}

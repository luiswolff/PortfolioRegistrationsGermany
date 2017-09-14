package de.wolff.portfolioBCG.carReg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.wolff.portfolioBCG.modells.Manufacture;

public class BrandMapper{
	
	private static String file = "data/manufactureBrands.csv";
	
	private HashMap<Manufacture, List<String>> brandMap = new HashMap<>();
	
	public BrandMapper(){
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while ((line = br.readLine()) != null){
				String[] e = line.split(";");
				Manufacture m = new Manufacture(e[0]);
				LinkedList<String> ll = new LinkedList<>();
				for (int i = 1; i < e.length; i++){
					if (!e[i].isEmpty()){
						ll.add(e[i]);
					}
				}
				brandMap.put(m, ll);
			}
			br.close();
		} catch (IOException ie) {
			throw new RuntimeException(ie);
		}
	}
	
	public Manufacture getMakerOF(String brand){
		for (Manufacture m : brandMap.keySet()){
			for(String umbrella : brandMap.get(m)){
				if (brand.toLowerCase().contains(umbrella.toLowerCase())){
					return m;
				}
			}
		}
		throw new RuntimeException("Unmapped Brand: " + brand);
	}
	
}

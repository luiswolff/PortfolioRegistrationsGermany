#Portfolio f&uuml;r Autoneuzulassungen in Deutschland

Diese Anwendung zeigt ein Portfolio nach der Boston Consulting Group, f&uuml;r die PKW-Neuzulassungen in Deutschland. Es baut auf den Tool [PorfolioBCG] (https://github.com/luiswolff/PortfolioBCG "Portfolio nach der Boston Consulting Group") auf und kann auch nur mit diesem zusammen gestartet werden. Die Daten basieren auf den Statistiken des Kraftfahrt-Bundesamts f&uuml;r die Jahre 2011 bis 2013. Sie teilen die Fahrzeuge in Unterschiedliche Fahrzeugkategorien ein und geben an, wie viele Fahrzeuge von einem Typ in einer Periode zugelassen wurden. F&uuml;r diese Analyse wird nur die Periode von Januar bis Dezember in den Jahren 2011, 2012 und 2013 betrachtet. Die Daten befinden sich im Ordner `data/` und sind von Dateityp `*.csv`. 

Die Daten werden von dem Objekt `CarRegGermany` ausgelesen, was auch gleichzeitig die Hauptklasse ist. F&uuml;r das Zielwachstum wird das durchschnittliche Wachstum aller Fahrzeugsegmente ermittelt. Allerdings muss es mindestens 0 sein.

Die Anwendung ist entstanden in Zuge einer Semesterarbeit f&uuml;r das Fach Informationsvisualisierung des Studiengangs Wirtschaftsinformatik an der Fachhochschule Stralsund. Aufgabe war es Daten mit Hilfe der Programmiersprache Processing oder dessen Java Framework zu visualisieren und die wesentlichen Informationen sichtbar zu machen. Ich habe mich f&uuml;r die Portfolio-Analyse entschieden, weil mit diesem Verfahren die Zukunftsf&auml;higkeit von Unternehmen dargestellt werden kann. 

Nat&uuml;rlich muss die Frage gestellt werden, ob es sinnvoll ist, auf die Zukunftsf&auml;higkeit von Autoherstellen &uuml;ber deren Anzahl von neu zugelassenen Wagen zu schlie&szlig;en. Sinnvoller w&auml;hre es wohl Umsatzdaten zu analysieren. Allerdings ist es sehr schwierig als Student an entsprechend aufbereitete Daten zu gelangen. Hier hat sich der Datensatz des Kraftfahrt-Bundesamts angeboten, welches die Fahrzeuge schon in Segmenten unterteilt, die als strategische Gesch&auml;ftseinheiten interpretiert werden k&ouml;nnten.

Es f&auml;llt allerdings auf, dass bei den Daten keine Hersteller zu den Marken hinterlegt sind. Diese sind aber wichtig, da eine Portfolio-Analyse nur aus Sicht von strategisch zusammenh&auml;ngenden Unternehmen Sinn macht. Zu diesem Zweck wurde die Datei `data/manufactureBrands.csv` erstellt, welche f&uuml;r alle relevanten Hersteller zeigt, welche Dachmarken zu ihm geh&ouml;ren. Die Datei wurde auf Grundlage folgender Wikipedia-Eintr&auml;ge erstellt:

* http://de.wikipedia.org/wiki/Renault-Nissan

* http://de.wikipedia.org/wiki/AwtoWAS

* http://de.wikipedia.org/wiki/Volkswagen_AG

* http://de.wikipedia.org/wiki/Daimler_AG

* http://de.wikipedia.org/wiki/Fiat_Chrysler_Automobiles

* http://de.wikipedia.org/wiki/General_Motors

* http://de.wikipedia.org/wiki/Toyota

* http://de.wikipedia.org/wiki/Tata_Motors

* http://de.wikipedia.org/wiki/PSA_Peugeot_Citro%C3%ABn

* http://de.wikipedia.org/wiki/Ford

* http://de.wikipedia.org/wiki/Geely

* http://de.wikipedia.org/wiki/Mazda

* http://de.wikipedia.org/wiki/Hyundai_Kia_Automotive_Group

* http://de.wikipedia.org/wiki/Mitsubishi_Motors

* http://de.wikipedia.org/wiki/BMW_Group

* http://de.wikipedia.org/wiki/Alpina_Burkard_Bovensiepen

* http://de.wikipedia.org/wiki/Ssangyong

* http://de.wikipedia.org/wiki/Aston_Martin

* http://de.wikipedia.org/wiki/Proton_(Automobilhersteller)

* http://de.wikipedia.org/wiki/Morgan_Motor

* http://de.wikipedia.org/wiki/Saab_Automobile

Das Auslesen &uuml;bernimmt das Objekt `BrandMapper` aus dem Paket `de.wolff.portfolioBCG.carReg`.

Abschlie&szlig;end soll noch gesagt werden, dass der erzeugte Quellcode f&uuml;r dieses Projekt noch nicht ausgereift ist. Aus Zeitmangel wurde hier mehr drauf geachtet, dass die Daten korrekt eingelesen werden. Der Quellcode f&uuml;r das Verwendete Tool [PorfolioBCG] (https://github.com/luiswolff/PortfolioBCG "Portfolio nach der Boston Consulting Group") wurde mit deutlich mehr Sorgfalt erstellt.

package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class File {
	
	public static Program pr = null;

	public File(Program pr) // her class'ın main içinde oluşturulan dispatchlist'e erişimini sağlamak için
	{
		File.pr = pr;
	}

	public void reader() throws IOException {

		List<String> allLines = Files.readAllLines(Paths.get("./giris.txt"));// dosyadaki satirlari listede
																						// tutacak
		int idCounter = 0; // itemlere id atamak için tutulan sayaç

		for (int i = 0; i < allLines.size(); i++) { // tüm satırları gezmemizi sağlıyor

			String line = allLines.get(i);// ilk satir alindi

			Process process = new Process(null); // her satır için bir item

			int counter = -1;// satirdaki verileri varis, oncelik ve burst time'a gore ayiriyor.

			String data = "";// satirdaki verileri almaya yariyor

			for (int j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);// satiri tek tek gezmeyi sagliyor

				if (ch == ' ')
					continue;

				else if (j == line.length() - 1) {// son satirdaki veriyi de almayi sagliyor ve ilgili Item degerine
													// atamayi sagliyor
					data += ch;
					process.overTime = Integer.parseInt(data);

				} else if (ch != ',') {// verileri veri nesnesine atamayi sagliyor ve verileri ayirmayi sagliyor
					data += ch;

				} else {// alinan verileri ilgili Item degerlerine atiyor

					counter++;
					switch (counter) {
					case 0:
						process.arrivingTime = Integer.parseInt(data);
						break;
					case 1:
						process.priority = Integer.parseInt(data);
						break;
					}

					data = ""; //veri stringini sıfırlıyor
				}
			}// bir satirdaki verileri ayırdık ve Item classına atadık
			
			process.ID = idCounter; //id ataması
			
			idCounter++;
			
			process.delay = process.arrivingTime; //itemlere default askıya alınma zamanı atıyor (varış zamanı)
			
			
			pr.AddtoList(process);
		}//tüm atama işlemleri bitti. dispatchList dolu
		pr.DpProgram();
	}
}

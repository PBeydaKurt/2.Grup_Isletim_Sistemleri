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
		int idSayac = 0; // itemlere id atamak için tutulan sayaç

		for (int i = 0; i < allLines.size(); i++) { // tüm satırları gezmemizi sağlıyor

			String satir = allLines.get(i);// ilk satir alindi

			Process process = new Process(null); // her satır için bir item

			int sayac = -1;// satirdaki verileri varis, oncelik ve burst time'a gore ayiriyor.

			String veri = "";// satirdaki verileri almaya yariyor

			for (int j = 0; j < satir.length(); j++) {
				char ch = satir.charAt(j);// satiri tek tek gezmeyi sagliyor

				if (ch == ' ')
					continue;

				else if (j == satir.length() - 1) {// son satirdaki veriyi de almayi sagliyor ve ilgili Item degerine
													// atamayi sagliyor
					veri += ch;
					process.overTime = Integer.parseInt(veri);

				} else if (ch != ',') {// verileri veri nesnesine atamayi sagliyor ve verileri ayirmayi sagliyor
					veri += ch;

				} else {// alinan verileri ilgili Item degerlerine atiyor

					sayac++;
					switch (sayac) {
					case 0:
						process.arrivingTime = Integer.parseInt(veri);
						break;
					case 1:
						process.priority = Integer.parseInt(veri);
						break;
					}

					veri = ""; //veri stringini sıfırlıyor
				}
			}// bir satirdaki verileri ayırdık ve Item classına atadık
			
			process.ID = idSayac; //id ataması
			
			idSayac++;
			
			process.delay = process.arrivingTime; //itemlere default askıya alınma zamanı atıyor (varış zamanı)
			
			
			pr.AddtoList(process);
		}//tüm atama işlemleri bitti. dispatchList dolu
		pr.DpProgram();
	}
}

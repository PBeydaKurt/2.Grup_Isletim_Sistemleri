package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcessBuilder {

    private static UserQueue<PriorityList> userQueueProcess;//işlem listesi
    private static int time = 0;//süre
    private static int id = 0;//id
    public static Program pr = null;
    private static Color color;//renk sınıfı

    public ProcessBuilder(File file) {
        userQueueProcess = new UserQueue<>(50);//50 elemanlı liste oluşturuldu
        readFile(file);//dosya okundu
        color = new Color();
    }

    public static void start() {

        while (!userQueueProcess.isEmpty()) {
            execute(userQueueProcess.dequeue(), color.getColor());  //işlemler sırasına göre prosesleri işlenmek üzere işleme girer.
            color.getColor();
            id++;
            if (time > 20) {//20 saniye limiti
                break;
            }
        }

    }

    private static void execute(PriorityList priorityListprocess, String colors) {
        //işlemlerin gerçekleştiği metot

        int len = priorityListprocess.getProcessTime();

        for (int i = len; i>= 0;i--) {
            if (i == len) {
                System.out.println(colors +time + "sn proses başladı. (id: 000"+ id+ " öncelik: "+priorityListprocess.getPriority()+" kalan süre:"+ priorityListprocess.getProcessTime());
            } else if (i == 0) {
                System.out.println(colors +time + "sn proses sonlandı. (id: 000"+ id+ " öncelik: "+priorityListprocess.getPriority()+" kalan süre:"+ priorityListprocess.getProcessTime());
            } else {
                System.out.println(colors +time + "sn proses yürütülüyor. (id: 000"+ id+ " öncelik: "+priorityListprocess.getPriority()+" kalan süre:"+ priorityListprocess.getProcessTime()+")");
            }
            time++;
            if (time > 20) {// 20 saniye limiti
                System.out.println("SÜRE DOLDU");
                break;
            }
            process.setProcessTime(priorityListprocess.getProcessTime() - 1);//her saniye geçtikten sonra işlenen süre işlem süresinden düşürülüyor
        }


    }

    public static void printList() {//test emek için oluşturulmuş ekleme metodu
        for (int i = 0; i < userQueueProcess.getCurrentSize(); i++) {
            PriorityList item = userQueueProcess.dequeue();
            System.out.println("Arrival Time: " +item.getArrivalTime() +" Priority: "+item.getPriority() + " Process Time: " +item.getProcessTime());
        }
    }

    public void readFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./giris.txt"));
		int counterID = 0; // id atanıyor
		for (int i = 0; i < lines.size(); i++) { 
 		// satırların hepsine bakılıyor

			String line = lines.get(i);
		// 1.satır get metoduyla alınıyor

			Process pr = new Process(null); 
		// tüm satırlar için atama yapılıyor

			int counter = -1;

			String data = "";
		// veriler geliyor

			for (int a = 0; a < line.length(); a++) {
				char b = line.charAt(a);

				if (b == ' ')
					continue;

				 else if (b != ',') {
		// veriler atanıyor
					data += b;

				} 
		else if (a == line.length() - 1) 
		{
		// en son satırın verisi alınıyor ataması yapılıyor
													
			
					data += b;
					pr.overTime = Integer.parseInt(data);

				}else 
			{
		// alinan verilere değer atanıyor
					counter++;
					if(counter==0)
		{
						pr.arrivingTime = Integer.parseInt(data);
						}
					else if(counter==1){
						pr.priority = Integer.parseInt(data);
						}	
					}

					data = ""; data boş hale getiriliyor
				}
			}
			
			pr.ID = counterID; 
		//id atanıyor
			
			counterID++;
			
			pr.delay = pr.arrivingTime; 
		//varış zamanı atanıyor
			
			
			prog.AddtoList(pr);
		}//atama sonlandı
		prog.DpProgram();
    }
}

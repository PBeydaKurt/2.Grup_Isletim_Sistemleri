package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.nio.file.Paths;

public class ProcessBuilder {

    private static userQueue<PriorityList> userQueueProcess;//işlem listesi
    private static int time = 0;//süre
    private static int id = 0;//id
    public static Program pr = null;
    private static Color color;//renk sınıfı

    public ProcessBuilder(File file) {
        userQueueProcess = new userQueue<>(50);//50 elemanlı liste oluşturuldu
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

package project;
import java.util.Random;
public class PriorityList {

    Algorithm rr = new Algorithm();
    Queue queue1 = new Queue();
    Queue queue2 = new Queue();

    int FirstPriList(int time) {// maine gidecek olan timer(ekleme islemi olacak)

        Random rng = new Random();

        // Rastgele RGB renkleri oluşturma
        int r = rng.nextInt(256);
        int g = rng.nextInt(256);
        int b = rng.nextInt(256);

        // Rastgele renkleri kullanarak yazıyı biçimlendirme

        Program dl;

//		System.out.println();
//		String text = String.format("\033[38;2;%d;%d;%dmFirst Priority\033[0m", r, g, b);
        // System.out.println(text);
        String text = "";
        int timer = 0;

        Process process = queue1.PopQueue();

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn proses basladi         (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m", r,
                g, b, (time + timer), process.ID, process.priority, process.overTime);

        System.out.println(text);

        timer++;
        process.overTime--;

        process.delay = time + timer;

        if (process.overTime > 0) {
            // System.out.print("spl gonderildi => ");
            process.priority++;

            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn proses askida          (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                    r, g, b, (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);
             queue2.PushQueue(process);

        } else {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn proses sonlandi        (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                    r, g, b, (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);
        }

        //dl.TimeOut_Scanner(time + timer);
        // System.out.println("--------------"+kuyruk.kuyrukSize()+"-----------");
        return timer;
    }

    int SecondPriList(int time) {// maine gidecek olan timer(ekleme islemi olacak)

        Random rng = new Random();

        // Rastgele RGB renkleri oluşturma
        int r = rng.nextInt(256);
        int g = rng.nextInt(256);
        int b = rng.nextInt(256);

        // Rastgele renkleri kullanarak yazıyı biçimlendirme

        Program dl;

//		System.out.println();
//		String text = String.format("\033[38;2;%d;%d;%dmSecond Priority\033[0m", r, g, b);
//		System.out.println(text);
        String text = "";
        int timer = 0;

        Process process = queue2.PopQueue();

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn proses basladi         (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m", r,
                g, b, (time + timer), process.ID, process.priority, process.overTime);

        System.out.println(text);

        timer++;
        process.overTime--;

        process.delay = time + timer;

        if (process.overTime > 0) {

            process.priority++;

            rr.queue.PushQueue(process);

            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn proses askida          (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                    r, g, b, (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);

        } else {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn proses sonlandi        (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                    r, g, b, (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);
        }

        //dl.TimeOut_Scanner((time + timer));

        return timer;
    }
}

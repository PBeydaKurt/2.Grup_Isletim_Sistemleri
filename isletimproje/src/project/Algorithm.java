package project;
import java.util.Random;
public class Algorithm {
    Queue queue = new Queue();
    int counter = 0;

    Process item = null;

    int RoundRobin(int time) {// maine gidecek olan timer(ekleme islemi olacak)

        Random rng = new Random();

        // Rastgele RGB renkleri oluşturma
        int r = rng.nextInt(256);
        int g = rng.nextInt(256);
        int b = rng.nextInt(256);

        // Rastgele renkleri kullanarak yazıyı biçimlendirme

        Program dl;

//		System.out.println();
//		String text = String.format("\033[38;2;%d;%d;%dmRound Robin\033[0m", r, g, b);
//		System.out.println(text);
        String text = "";
        int timer = 0;

        Process process = queue.Pull(counter);

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn proses basladi         (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m", r,
                g, b, (time + timer), process.ID, process.priority, process.overTime);

        System.out.println(text);

        timer++;
        process.overTime--;

        process.delay = time + timer;

        if (process.overTime == 0) {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn proses sonlandi        (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                    r, g, b, (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);

            queue.PopQueue(counter);

            if (counter == queue.QueueSize())
                counter = 0;
        } else {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn proses askida          (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                    r, g, b, (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);

            //dl.TimeOut_Scanner(time + timer);

            counter = (counter + 1) % queue.QueueSize();

        }
        return timer;
    }

    int FCFS(int time) {// maine gidecek olan timer(ekleme islemi olacak)

        Random rng = new Random();

        // Rastgele RGB renkleri oluşturma
        int r = rng.nextInt(256);
        int g = rng.nextInt(256);
        int b = rng.nextInt(256);

        // Rastgele renkleri kullanarak yazıyı biçimlendirme

        Program dl;

        // System.out.println();
        // String text = String.format("\033[38;2;%d;%d;%dmFCFS\033[0m", r, g, b);
        // System.out.println(text);
        int timer = 0;
        String text = "";
        Process process = queue.Pull(counter);

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn proses basladi         (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m", r,
                g, b, (time + timer), process.ID, process.priority, process.overTime);

        System.out.println(text);

        while (process.overTime != 0) {
            process.overTime--;
            timer++;

            process.delay = time + timer;

            if (process.overTime > 0) {
                text = String.format(
                        "\033[38;2;%d;%d;%dm%2d sn proses yurutuluyor     (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                        r, g, b, (time + timer), process.ID, process.priority, process.overTime);

                System.out.println(text);
            } else
                text = String.format(
                        "\033[38;2;%d;%d;%dm%2d sn proses sonlandi        (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
                        r, g, b, (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);

            //dl.TimeOut_Scanner(time + timer);
        }

        return timer;
    }
}

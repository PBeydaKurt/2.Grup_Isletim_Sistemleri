package project;
import java.util.Random;
public class Algorithm {
    Queue queue = new Queue();
    int counter = 0;

    Process item = null;

    int RoundRobin(int time) {

        Program dl;
        String text = "";
        int timer = 0;

        Process process = queue.Pull(counter);

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn process started       (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
               (time + timer), process.ID, process.priority, process.overTime);

        System.out.println(text);

        timer++;
        process.overTime--;

        process.delay = time + timer;

        if (process.overTime == 0) {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn process ended       (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                    (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);

            queue.PopQueue(counter);

            if (counter == queue.QueueSize())
                counter = 0;
        } else {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn process is waiting        (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                    (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);

            counter = (counter + 1) % queue.QueueSize();

        }
        return timer;
    }

    int FCFS(int time) {

        Program dl;

        int timer = 0;
        String text = "";
        Process process = queue.Pull(counter);

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn process started       (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                (time + timer), process.ID, process.priority, process.overTime);

        System.out.println(text);

        while (process.overTime != 0) {
            process.overTime--;
            timer++;

            process.delay = time + timer;

            if (process.overTime > 0) {
                text = String.format(
                        "\033[38;2;%d;%d;%dm%2d sn process is running     (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                        (time + timer), process.ID, process.priority, process.overTime);

                System.out.println(text);
            } else
                text = String.format(
                        "\033[38;2;%d;%d;%dm%2d sn process ended        (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                        (time + timer), process.ID, process.priority, process.overTime);

            System.out.println(text);

            //dl.TimeOut_Scanner(time + timer);
        }

        return timer;
    }
}

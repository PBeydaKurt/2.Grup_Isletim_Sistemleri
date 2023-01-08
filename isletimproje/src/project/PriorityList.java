package project;
import java.util.Random;
public class PriorityList {

    Algorithm rr = new Algorithm();
    Queue queue1 = new Queue();
    Queue queue2 = new Queue();

    int FirstPriList(int time) {
        //timer that will go to main (will be adding)

        Program dl;

        String text = "";
        int timer = 0;

        Process process = queue1.PopQueue();

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn process started         (id: %2d   priority:%2d  overtime:%2d sn)\033[0m",
                (time + timer), process.ID, process.priority, process.overTime);
        //print text in color
        System.out.println(text);

        timer++;
        process.overTime--;

        process.delay = time + timer;

        if (process.overTime > 0) {
           
            process.priority++;

            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn process is waiting          (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                    (time + timer), process.ID, process.priority, process.overTime);
            //print text in color
            System.out.println(text);
             queue2.PushQueue(process);

        } else {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn process ended        (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                    (time + timer), process.ID, process.priority, process.overTime);
            //print text in color
            System.out.println(text);
        }

        return timer;
    }

    int SecondPriList(int time) {


        Program dl;


        String text = "";
        int timer = 0;

        Process process = queue2.PopQueue();

        text = String.format(
                "\033[38;2;%d;%d;%dm%2d sn process started         (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                (time + timer), process.ID, process.priority, process.overTime);
        //print text in color
        System.out.println(text);

        timer++;
        process.overTime--;

        process.delay = time + timer;

        if (process.overTime > 0) {

            process.priority++;

            rr.queue.PushQueue(process);

            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn process is waiting          (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                    (time + timer), process.ID, process.priority, process.overTime);
            //print text in color
            System.out.println(text);

        } else {
            text = String.format(
                    "\033[38;2;%d;%d;%dm%2d sn process ended        (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                    (time + timer), process.ID, process.priority, process.overTime);
            //print text in color
            System.out.println(text);
        }

        //dl.TimeOut_Scanner((time + timer));

        return timer;
    }
}
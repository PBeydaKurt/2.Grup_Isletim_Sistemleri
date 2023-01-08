package project;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Program {
    Queue queue = new Queue();
    Algorithm rr = new Algorithm();
    Algorithm fcfs = new Algorithm();
    PriorityList fpl = new PriorityList();
    PriorityList spl = new PriorityList();
    int timer = 0;

    public void AddtoList(Process process) {
        queue.PushQueue(process);
    }

    public void Print() {
        for (int i = 0; i < queue.QueueSize(); i++) {
            System.out.println(queue.Pull(i).toString());
        }
    }

    public void DpProgram() {
        // dispatchList is full.
        int size = queue.QueueSize();
        // System.out.println(size);
        int processCount = 0;
        while (processCount != size || !fpl.queue1.isQueueEmpty() || !spl.queue2.isQueueEmpty() || !rr.queue.isQueueEmpty()) {
            for (int i = 0; i < size; i++) {
                if (queue.QueueSize() == 0)
                    break;
                if (queue.Pull(0).arrivingTime > timer) {
                    // System.out.println("varis: "+dispatchList.get(0).varis+" timer:
                    // "+damn_timer);
                    break;
                } else if (queue.Pull(0).priority == 0) {// <=!!!
                    // System.out.println("varis: "+dispatchList.get(0).varis);
                    fcfs.queue.PushQueue(queue.PopQueue());
                    processCount++;
                    // System.out.println(damn_timer);
                } else {
                    if (queue.Pull(0).priority != 0) {
                        if (queue.Pull(0).priority == 1) {
                            processCount++;
                            fpl.queue1.PushQueue(queue.PopQueue());
                        } else if (queue.Pull(0).priority == 2) {
                            processCount++;
                            spl.queue2.PushQueue(queue.PopQueue());
                        } else {
                            processCount++;
                            rr.queue.PushQueue(queue.PopQueue());
                        }
                    }

                }

            } // for bitis //time'a gore degerler ataniyor.

            if (!(fcfs.queue.isQueueEmpty())) {
                int fcfs_ExecTime = fcfs.FCFS(timer);
                timer += fcfs_ExecTime;
            } else if (!(fpl.queue1.isQueueEmpty())) {
                int fpl_ExecTime = fpl.FirstPriList(timer);
                timer += fpl_ExecTime;
            } else if (!(spl.queue2.isQueueEmpty())) {
                int spl_ExecTime = spl.SecondPriList(timer);
                timer += spl_ExecTime;
            } else if (!(rr.queue.isQueueEmpty())) {
                int rr_ExecTime = rr.RoundRobin(timer);
                timer += rr_ExecTime;
            } else
                timer++;
        }
    }

    public void TimeOut(int time) {
        String text = "";
        for (int i = 0; i < fcfs.queue.QueueSize(); i++) {// fcfs checking
            Process process = fcfs.queue.Pull(i);
            if (time - process.delay >= 20)// zaman asimi oldu
            {
                text = String.format(
                        "\033[38;2;%d;%d;%dm%d sn process over time      (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                        process.delay, process.ID, process.priority, process.overTime);

                System.out.println(text);

                fcfs.queue.PopQueue(i);
                i--;
            }
        }
        for (int i = 0; i < fpl.queue1.QueueSize(); i++) {// firstPriorityList checking
            Process process = fpl.queue1.Pull(i);
            if (time - process.delay >= 20)// zaman asimi oldu
            {
                text = String.format(
                        "\033[38;2;%d;%d;%dm%d sn proses zamanasimi      (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                        process.delay, process.ID, process.priority, process.overTime);

                System.out.println(text);

                fpl.queue1.PopQueue(i);
                i--;
            }
        }
        for (int i = 0; i < spl.queue2.QueueSize(); i++) {// secondPriorityList checking
            Process process = spl.queue2.Pull(i);
            if (time - process.delay >= 20)// zaman asimi oldu
            {
                text = String.format(
                        "\033[38;2;%d;%d;%dm%d sn process over time      (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                        process.delay, process.ID, process.priority, process.overTime);

                System.out.println(text);

                spl.queue2.PopQueue(i);
                i--;
            }
        }
        for (int i = 0; i < rr.queue.QueueSize(); i++) {// Round-Robin checking
            Process process = rr.queue.Pull(i);
            if (time - process.delay >= 20)// zaman asimi oldu
            {

                text = String.format(
                        "\033[38;2;%d;%d;%dm%d sn process over time      (id: %2d   priority:%2d  over time:%2d sn)\033[0m",
                       process.delay, process.ID, process.priority, process.overTime);

                System.out.println(text);

                rr.queue.PopQueue(i);
                i--;
            }
        }

    }


}

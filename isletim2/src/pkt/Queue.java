package pkt;
import java.util.LinkedList;
import java.util.Random;

public class Queue {
        private LinkedList<Process> queue = new LinkedList<Process>();

    public void PushQueue(Process process) {
        queue.addLast(process);

    }

    public Process PopQueue() {
        return queue.remove();
    }

    public Process PopQueue(int id) {
        return queue.remove(id);
    }

    public Process Pull(int index)
    {
        return queue.get(index);
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public int QueueSize()
    {
        return queue.size();
    }

}


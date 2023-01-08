package project;

public class UserQueue {
	Queue queue = new Queue();

	void UserAdd(Process process) {
		queue.PushQueue(process);
	}
	
	void UserProgram() //dispatchList'ten gelen prosesleri önceliklerine göre ilgili kuyruklara gönderiyor
	{
		Program pr = ProcessBuilder.pr;
		
		while(!queue.isQueueEmpty())
		{
			if (queue.Pull(0).priority == 1) {
				pr.fpl.queue1.PushQueue(queue.PopQueue());
			} else if (queue.Pull(0).priority == 2) {
				pr.spl.queue2.PushQueue(queue.PopQueue());
			} else {
				pr.rr.queue.PushQueue(queue.PopQueue());
			}
		}
		
	}
}

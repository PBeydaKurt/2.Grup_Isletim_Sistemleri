package project;

public class UserQueue {
	Queue qu = new Queue();

	void UserAdd(Process process) {
		qu.PushQueue(process);
	}
	
	void UserProgram()
	{
		Program prog = File.prog;
		
		while(!qu.isQueueEmpty())
		{
			if (qu.Pull(0).priority == 2) 
			{
				prog.spl.queue2.PushQueue(qu.PopQueue());
			} else if (qu.Pull(0).priority == 1) 
			{
				prog.fpl.queue1.PushQueue(qu.PopQueue());
			} else 
			{
				prog.rr.qu.PushQueue(qu.PopQueue());
			}
		}
		
	}
} 

package it.nlmk.progetto01;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

	  private BlockingQueue taskQueue = null;
	  private ArrayList<ThreadPingIcon> threads = new ArrayList<ThreadPingIcon>();
	  private boolean isStopped = false;

	  public ThreadPool(ThreadPingIcon thread){
//	    taskQueue = new BlockingQueue(maxNoOfTasks);

	    for(int i=0; i<threads.size(); i++){
	      threads.add(thread);
	    }
	
	  }

//	  public void synchronized execute(Runnable task){
//	    if(this.isStopped) throw
//	      new IllegalStateException("ThreadPool is stopped");
//
//	    this.taskQueue.enqueue(task);
//	  }

	  public synchronized void stop(){
	    this.isStopped = true;
	    for(ThreadPingIcon thread : threads){
	      thread.stop();
	    }
	  }

	}
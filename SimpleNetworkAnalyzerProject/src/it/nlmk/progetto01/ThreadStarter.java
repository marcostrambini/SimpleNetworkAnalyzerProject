package it.nlmk.progetto01;





public class ThreadStarter extends Thread {
	ThreadPingIcon tpi;
    
	public ThreadStarter(ThreadPingIcon tpi) {
		this.tpi = tpi;
	}

	
	public synchronized void run() {
		tpi.start();
	}
	

}




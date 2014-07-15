package it.nlmk.progetto01;





public class ThreadStopper extends Thread {
	ThreadPingIcon tpi;
    
	public ThreadStopper(ThreadPingIcon tpi) {
		this.tpi = tpi;
	}

	
	public synchronized void run() {
		boolean ok = false;
		while(!ok){
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Thread: "+ tpi.getName() + " - ID: " + tpi.getId()+ " Stato prima del tentativo di stoppara: "+ tpi.getState());

		System.out.println("provo a mettere in wait la Thread: "+ tpi.getName() + " - ID: " + tpi.getId());
		
		try {
			tpi.sleep(500);
			tpi.interrupt();
			tpi.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ok = true;
		}
		System.out.println("Thread: "+ tpi.getName() + " - ID: " + tpi.getId()+ " Stato dopo il tentativo di stoppara: "+ tpi.getState());
	}
	

}




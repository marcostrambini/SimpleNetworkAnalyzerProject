package it.nlmk.progetto01;

import java.io.IOException;

public class ThreadPing extends Thread {

	Tools tools = new Tools();
	public ThreadPing(String str) {
		super(str);
	}

	public void run() {
		
		try {
			System.out.println(getName() + " : " + tools.ping(getName()));
			sleep(3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i + " " +
//					getName());
//			try {
//				sleep((int)(Math.random()*1000));
//			} catch (InterruptedException e){}
//		}
//		System.out.println("DONE! " + getName());
 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//		 public class TwoThreadsTest {
	public static void main (String[] args) {
//		new ThreadPing("Jamaica").start();
//		new ThreadPing("Fiji").start();
		String ipAddress = "";
		while(true){
		for(int i =1; i<100; i++){
			ipAddress = "10.0.113."+i;
			new ThreadPing(ipAddress).start();
		}
		}
//		new ThreadPing("10.0.119.1").start();
//		new ThreadPing("10.0.119.254").start();
	}
}




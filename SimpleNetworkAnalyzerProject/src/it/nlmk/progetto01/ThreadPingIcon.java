package it.nlmk.progetto01;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;

import Grafiche.FrameLog;
import Test.ExitFrameTest;

public class ThreadPingIcon extends Thread {

	Tools tools = new Tools();
	JButton button;
    JLabel label;
   
    ImageIcon icon1;
    ImageIcon icon2;
    
	boolean giaScrittoON = false;
	boolean giaScrittoOFF = false;
	boolean ping = false;
	String messaggio ="";
    
	public ThreadPingIcon(String str) {
		super(str);
	}
	
	public ThreadPingIcon(String str, JButton b){
		super(str);
		this.button = b;
	}
	
	public ThreadPingIcon(String str, JButton b, JLabel label,  ImageIcon icon1, ImageIcon icon2){
		super(str);
		this.button = b;
		this.label = label;
		
		this.icon1 = icon1;
		this.icon2 = icon2;
	}
	
	public ThreadPingIcon(String str, JLabel l){
		super(str);
		this.label = l;
	}
	
	
	public  synchronized void stopMe() {
		while(this.isAlive()){
		try {
			Thread.sleep(500);
			this.interrupt();
			this.join();
			System.out.println("sono passato dalla variazione di sleep");
			
		} catch (InterruptedException e) {
		System.out.println("non riesco ad addormentare la thread : "+this.getName() + " - ID: "+this.getId());
		}
		

		System.out.println("Stato della thread: "+ this.getName()+ " = "+this.getState());
		}
	}


	public synchronized void run() {
		
		while(!Thread.currentThread().isInterrupted() ){
			try {
				if(tools.ping(getName())){
					sleep(3000);
					ping = true;
					messaggio = tools.getStatusCode(1, getName());
					
					if(!giaScrittoON){
						
						System.out.println(messaggio);
						tools.scriviLogStatus(messaggio);
						FrameLog.setTextArea(messaggio);
						giaScrittoON = true;
						giaScrittoOFF = false;
						
					} 
					
					button.setForeground(Color.GREEN);
					label.setIcon(icon1);
					
					button.repaint();
					
					System.out.println(getName() + " : " + tools.ping(getName())+" --> verde");
					
				}else{
					
					ping = false;
					messaggio = tools.getStatusCode(2, getName());
					if(!giaScrittoOFF){
						System.out.println(messaggio);
						tools.scriviLogStatus(messaggio);
						FrameLog.setTextArea(messaggio);
						giaScrittoOFF = true;
						giaScrittoON = false;
					} 	
					
					
					button.setForeground(Color.RED);
					label.setIcon(icon2);
					
					button.repaint();
					System.out.println(getName() + " : " + tools.ping(getName())+" --> rosso");
//				sleep(3000);
				}
			} catch (InterruptedException | IOException e) {
				if(ThreadRepository.flagGoInterrupt)
				throw new RuntimeException("Thread interrupted..."+e);  
			}
			

	}

	}
	
	
	

}




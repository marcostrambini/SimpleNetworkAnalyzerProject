package it.nlmk.progetto01;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;

import Test.ExitFrameTest;

public class CopyOfThreadPingIcon extends Thread {

	Tools tools = new Tools();
	JButton button;
    JLabel label;
   
    ImageIcon icon1;
    ImageIcon icon2;
    
	boolean giaScrittoON = false;
	boolean giaScrittoOFF = false;
	boolean ping = false;
	String messaggio ="";
    
	public CopyOfThreadPingIcon(String str) {
		super(str);
	}
	
	public CopyOfThreadPingIcon(String str, JButton b){
		super(str);
		this.button = b;
	}
	
	public CopyOfThreadPingIcon(String str, JButton b, JLabel label,  ImageIcon icon1, ImageIcon icon2){
		super(str);
		this.button = b;
		this.label = label;
		
		this.icon1 = icon1;
		this.icon2 = icon2;
	}
	
	public CopyOfThreadPingIcon(String str, JLabel l){
		super(str);
		this.label = l;
	}

	public void run() {
		
		while(true){
			try {
				if(tools.ping(getName())){
					
					ping = true;
					messaggio = tools.getStatusCode(1, getName());
					
					if(!giaScrittoON){
						
						System.out.println(messaggio);
						tools.scriviLogStatus(messaggio);
						giaScrittoON = true;
						giaScrittoOFF = false;
						
					} 
					
					button.setForeground(Color.GREEN);
					label.setIcon(icon1);
					
					button.repaint();
					
					System.out.println(getName() + " : " + tools.ping(getName())+" --> verde");
					sleep(3000);
				}else{
					
					ping = false;
					messaggio = tools.getStatusCode(2, getName());
					if(!giaScrittoOFF){
						System.out.println(messaggio);
						tools.scriviLogStatus(messaggio);
						giaScrittoOFF = true;
						giaScrittoON = false;
					} 	
					
					
					button.setForeground(Color.RED);
					label.setIcon(icon2);
					
					button.repaint();
					System.out.println(getName() + " : " + tools.ping(getName())+" --> rosso");
				sleep(3000);
				}
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			

	}

	}

}




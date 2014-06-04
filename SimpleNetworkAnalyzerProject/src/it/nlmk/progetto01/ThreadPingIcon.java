package it.nlmk.progetto01;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;

import Test.ExitFrameTest;

public class ThreadPingIcon extends Thread {

	Tools tools = new Tools();
	JButton button;
    JLabel label;
    ImageIcon icon1;
    ImageIcon icon2;
    
	public ThreadPingIcon(String str) {
		super(str);
	}
	
	public ThreadPingIcon(String str, JButton b){
		super(str);
		this.button = b;
	}
	
	public ThreadPingIcon(String str, JButton b, JLabel label, ImageIcon icon1, ImageIcon icon2){
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

	public void run() {
		
		while(true){
		
			try {
				if(tools.ping(getName())){
					button.setForeground(Color.GREEN);
					label.setIcon(icon1);
					button.repaint();
					
					System.out.println(getName() + " : " + tools.ping(getName())+" --> verde");
					sleep(3000);
				}else{
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


	public static void main (String[] args) {

		String ipAddress = "";
		
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		 JButton button = new JButton("192.168.0.11");
		 JLabel label = new JLabel("192.168.0.11");
		

		JButton[] arrayButton = new JButton[2];
		arrayButton[0] = button;

		
		button.setBackground(Color.red);
		frame.add(button);

	}
}




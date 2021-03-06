package it.nlmk.progetto01;

import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;

import Test.ExitFrameTest;

public class ThreadPing extends Thread {

	Tools tools = new Tools();
	JButton button;
    JLabel label;
    ImageIcon icon;
	
	public ThreadPing(String str) {
		super(str);
	}
	
	public ThreadPing(String str, JButton b){
		super(str);
		this.button = b;
	}
	
	public ThreadPing(String str, JButton b, ImageIcon icon){
		super(str);
		this.button = b;
		this.icon = icon;
	}
	
	public ThreadPing(String str, JLabel l){
		super(str);
		this.label = l;
	}

	public void run() {
		
		while(true){
		
			try {
				if(tools.ping(getName())){
					button.setForeground(Color.GREEN);
					button.repaint();
					
					System.out.println(getName() + " : " + tools.ping(getName())+" --> verde");
					sleep(3000);
				}else{
					button.setForeground(Color.RED);
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




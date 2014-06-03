package it.nlmk.progetto01;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;

import Test.ExitFrameTest;

public class ThreadPing extends Thread {

	Tools tools = new Tools();
	JButton button;
    JLabel label;
	
	public ThreadPing(String str) {
		super(str);
	}
	
	public ThreadPing(String str, JButton b){
		super(str);
		this.button = b;
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
		} catch (IOException e) {

			System.out.println("host "+getName()+" non raggiungibile");
		}

 catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		}
	}

//		 public class TwoThreadsTest {
	public static void main (String[] args) {
//		new ThreadPing("Jamaica").start();
//		new ThreadPing("Fiji").start();
		String ipAddress = "";
		
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		 JButton button = new JButton("192.168.0.11");
		 JLabel label = new JLabel("192.168.0.11");
		
//		frame.add(label);
		JButton[] arrayButton = new JButton[2];
		arrayButton[0] = button;
//		new ThreadPing(button.getText(), button).start();
		
		button.setBackground(Color.red);
		frame.add(button);
//		for(int i =1; i<=3; i++){
//			ipAddress = "192.168.0."+i;
//			new ThreadPing(ipAddress).start();
//		
//		}
//		new ThreadPing("10.0.119.1").start();
//		new ThreadPing("10.0.119.254").start();
	}
}




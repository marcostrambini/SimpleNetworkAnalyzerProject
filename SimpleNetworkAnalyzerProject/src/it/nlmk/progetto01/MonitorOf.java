package it.nlmk.progetto01;

import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;

public class MonitorOf extends JButton {
	String ipAddress = "";
	public MonitorOf(String ipAddress) throws IOException{
		this.ipAddress = ipAddress;
		setText(ipAddress);
		setSize(80, 10);
		
		
		
//		while(true){
//		if(isPingable(ipAddress))
//			setBackground(Color.GREEN);
//		else
//			setBackground(Color.RED);
//	}
		
//		while(true){
//		if(isPingable2(ipAddress))
//			setBackground(Color.GREEN);
//		else
//			setBackground(Color.RED);
//	}
//		InetAddress inet = InetAddress.getByName(ipAddress);
//		if (inet.isReachable(1000))
//			setBackground(Color.GREEN);
//		
		
	}
	
	public boolean isPingable2(String ip) throws UnknownHostException{
		InetAddress inet = InetAddress.getByName(ip);
		try {
			return (inet.isReachable(1000));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isPingable(String ip) {
		try{
			String cmd = "";
			if(System.getProperty("os.name").startsWith("Windows")) {   
				// For Windows
				cmd = "ping -n 1 " + ip;
			} else {
				// For Linux and OSX
				cmd = "ping -c 1 " + ip;
			}

			Process myProcess = Runtime.getRuntime().exec(cmd);
			myProcess.waitFor();

			if(myProcess.exitValue() == 0) {

				return true;
			} else {

				return false;
			}

		} catch( Exception e ) {

			e.printStackTrace();
			return false;
		}
	}

}

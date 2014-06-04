package Grafiche;

import it.nlmk.progetto01.ThreadPingIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.Current;

public class NetStatusDevice extends JPanel{
	
	final ImageIcon iconRowRed = new ImageIcon("icons/freccia_rossa_down20.png");
	final ImageIcon iconRowGreen = new ImageIcon("icons/freccia_verde_up20.png");
	JButton button = new JButton();
	
	public NetStatusDevice(final String ipAddress){
		
	setLayout(new FlowLayout());
	
//	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
	button.setText(ipAddress);
	button.setSize(120, 20);


	final JLabel label = new JLabel();
	label.setIcon(iconRowRed);
	label.setSize(20, 20);
		
	new ThreadPingIcon(ipAddress, button, label, iconRowGreen, iconRowRed).start(); 
    
	add(button);
	add(label);
	setSize(180, 50);
		
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Test");
		frame.setSize(180, 300);
		frame.setLayout(new GridLayout());
		NetStatusDevice nsd = new NetStatusDevice("192.168.0.1");
//		NetStatusDevice nsd2 = new NetStatusDevice("192.168.0.7");
		frame.add(nsd);
		frame.setVisible(true);
	
	}

}

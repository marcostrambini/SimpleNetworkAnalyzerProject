package it.nlmk.progetto01;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameControls extends JFrame {
	
	public FrameControls(){
		setSize(200, 250);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		
		final TextField ipStart1 = new TextField(3);
		final TextField ipStart2 = new TextField(3);
		final TextField ipStart3 = new TextField(3);
		final TextField ipStart4 = new TextField(3);
		
		TextField ipEnd1 = new TextField(3);
		TextField ipEnd2 = new TextField(3);
		TextField ipEnd3 = new TextField(3);
		final TextField ipEnd4 = new TextField(3);
		
		JLabel labelStart = new JLabel("Inserisci Ip iniziale:");
		JLabel labelEnd = new JLabel("Inserisci Ip finale:");
		JLabel labelDot = new JLabel(".");
		
		JButton button = new JButton("Conferma");
		
		int h = 80;
		int l = 5;
		labelStart.setBounds(10, 0, 300, 30);
		ipStart1.setBounds(0+l, 40 , 40, 20);
		ipStart2.setBounds(45+l, 40 , 40, 20);
		ipStart3.setBounds(90+l, 40 , 40, 20);
		ipStart4.setBounds(135+l, 40 , 40, 20);
		
		labelEnd.setBounds(10, 0+h, 300, 30);
		ipEnd1.setBounds(0+l, 40+h , 40, 20);
		ipEnd2.setBounds(45+l, 40+h , 40, 20);
		ipEnd3.setBounds(90+l, 40+h , 40, 20);
		ipEnd4.setBounds(135+l, 40+h , 40, 20);
		
	
		
		button.setBounds(10, 80+h, 100, 20);
		button.addActionListener(new ActionListener() {
			FrameFields fields;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
			int numeroIp = (Integer.parseInt(ipEnd4.getText()) - Integer.parseInt(ipStart4.getText()));
			int ipIniziale = Integer.parseInt(ipStart4.getText());
			String base = generaBase(ipStart1.getText(), ipStart2.getText(), ipStart3.getText());
			
		//testo se converte correttamente da String a int
			System.out.println(base);
			System.out.println(numeroIp);
			System.out.println(ipIniziale);
			
			try {
				fields = new FrameFields(base, ipIniziale, numeroIp);
				fields.setVisible(true);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
			}
		});
		
		
		add(labelStart);
		add(ipStart1);
		add(ipStart2);
		add(ipStart3);
		add(ipStart4);
		add(labelEnd);
		add(ipEnd1);
		add(ipEnd2);
		add(ipEnd3);
		add(ipEnd4);
		add(button);
		
		
		
	}

	private String generaBase(String a, String b, String c){
		return a+"."+b+"."+c+".";
	}

	
}

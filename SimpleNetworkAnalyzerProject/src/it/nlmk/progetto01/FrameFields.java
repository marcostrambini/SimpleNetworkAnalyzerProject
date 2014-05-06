package it.nlmk.progetto01;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameFields extends JFrame{
	String base = "";
	int ipIniziale = 0;
	int numeroIp = 0;
	
	public FrameFields(String base, int ipIniziale, int numeroIp) throws IOException{
		this.base = base;
		this.ipIniziale = ipIniziale;
		this.numeroIp = numeroIp;
		
		setSize(1000, 600);
		setLayout(new GridLayout(25, 25));
		setBackground(Color.white);
		
		aggiungiFields(base, ipIniziale, numeroIp);
		
		

	}
	
	private void aggiungiFields(String base, int ipIniziale, int numeroIp) throws IOException{
		for (int i= ipIniziale; i<=(ipIniziale+numeroIp); i++){
			final String ip = base+i;
//			add(new JButton());
			final MonitorOf monitor = new MonitorOf(ip);
			monitor.addActionListener(new ActionListener() {
			    InetAddress inet;

			    //aggiungo il listener che esegue il ping
			    //in caso positivo colora di verde il button e ritorna l'HostName
			    
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					try {
						if (InetAddress.getByName(ip).isReachable(2000)){
							monitor.setText("ok" + InetAddress.getByName(ip).getHostName());
							monitor.setBackground(Color.GREEN);
						} else {
							monitor.setText("NO");
							monitor.setBackground(Color.RED);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
					    e.printStackTrace();
					}
				}
				
				
			
			});
			
			add(monitor);
		}
		}
}

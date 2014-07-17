package Grafiche;

import it.nlmk.progetto01.ThreadPingIcon;
import it.nlmk.progetto01.ThreadRepository;

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

/**
 * classe che costruisce l'oggetto composto da JButton che rappresenta l'ip + JLabel per la descrizione + JLabel con icona
 * all'oggetto viene associata un Thread che esegue il ping e modifica colore e Icon in base all'esito
 * @author marcostrambini
 *
 */
public class NetStatusDevice extends JPanel{
	
	final ImageIcon iconRowRed = new ImageIcon("icons/freccia_rossa_down20.png");
	final ImageIcon iconRowGreen = new ImageIcon("icons/freccia_verde_up20.png");
	final JLabel descrizione = new JLabel();
	JButton button = new JButton();
	
	public NetStatusDevice(final String ipAddress, String desc){
		
	setLayout(new FlowLayout());
	

	setVisible(true);
	
	button.setText(ipAddress);
	button.setSize(120, 20);


	final JLabel label = new JLabel();
	label.setIcon(iconRowRed);
	label.setSize(20, 20);
	descrizione.setText(desc);
	
	final ThreadPingIcon tpi = 	new ThreadPingIcon(ipAddress, button, label, iconRowGreen, iconRowRed); 
	tpi.setName(ipAddress);
	ThreadRepository.Pool(tpi);
//	ThreadRepository.startAllThread();
	tpi.start();
//	tpi.interrupt();
	
//	System.out.println("**** "+ tpi.getState());
//	tpi.interrupt();
//	System.out.println("**** "+ tpi.getState());
//	tpi.start();
//	System.out.println("**** "+ tpi.getState());

	
	add(button);
	add(descrizione);
	add(label);
	setSize(200, 50);
		
	System.out.println("numero thread: "+ ThreadRepository.Count() + "nome thread: "+tpi.getName());
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Test");
		frame.setSize(180, 300);
		frame.setLayout(new GridLayout());
		NetStatusDevice nsd = new NetStatusDevice("192.168.0.11", "iPad");
//		NetStatusDevice nsd2 = new NetStatusDevice("192.168.0.7");
		frame.add(nsd);
		frame.setVisible(true);
	
	}
	
}

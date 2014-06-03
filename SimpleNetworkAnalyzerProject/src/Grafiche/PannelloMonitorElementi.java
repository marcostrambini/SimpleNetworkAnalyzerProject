package Grafiche;

import it.nlmk.progetto01.ThreadPing;
import it.nlmk.progetto01.Tools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * classe che prende in input la lista degli indirizzi ip passati
 * ogni ip viene gestito dai un JLabel o JButton
 * ad ogni ip associo un ThreadPing che in base all'esito colora il JLabel (o JButton)
 * @author marcostrambini
 *
 */
public class PannelloMonitorElementi extends JFrame {

	
	public PannelloMonitorElementi(){
		
	}
	
    public PannelloMonitorElementi(String[][] listaIp){
	
    	
    setSize(400, 600);
	setLayout(new BorderLayout());
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	
	
	
	JPanel panelButton =  new JPanel();
	panelButton.setSize(400, 600);
	panelButton.setLayout(new GridLayout(listaIp.length, 1));
	panelButton.setVisible(true);
	
	for(int i =0; i<listaIp.length; i++){
		JButton button = new JButton(listaIp[i][0]);
		panelButton.add(button);
		ThreadPing tp = new ThreadPing(listaIp[i][0], button);
		tp.start();
	}
    
	JScrollPane jsp = new JScrollPane(panelButton);
	jsp.setSize(400, 600);
//	jsp.add(panelButton);
	this.add(jsp, BorderLayout.CENTER);
    	
	}
	
    public static void main(String[] args) throws IOException{
    	Tools tools = new Tools();
    	ArrayList<String> listaGruppi = tools.leggiFileRitorna("groups.ini");
    	
//    	String[][] tabFiltrata1 = tools.getTabellaFiltrata(listaGruppi.get(1), tools.getTabellaClassificazione());
    	
    	String[][] tabFiltrata1 = new String[11][3];
    	String ip="";
    	for(int i =0; i<11; i++){
    		ip="192.168.0."+(i+1);
    	
    	tabFiltrata1[i][0] = ip;
    	}
    	
    	for(int i=0; i<tabFiltrata1.length; i++)
    		System.out.println(tabFiltrata1[i][0]);
    	
    	
//    	String[][] tabFiltrata2 = tools.getTabellaFiltrata(listaGruppi.get(2), tools.getTabellaClassificazione());
    	PannelloMonitorElementi pme = new PannelloMonitorElementi(tabFiltrata1);
//    	PannelloMonitorElementi pme2 = new PannelloMonitorElementi(tabFiltrata2);
    }
	
}

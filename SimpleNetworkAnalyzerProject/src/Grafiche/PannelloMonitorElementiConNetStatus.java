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
public class PannelloMonitorElementiConNetStatus extends JFrame {

	
	public PannelloMonitorElementiConNetStatus(){
		
	}
	
    public PannelloMonitorElementiConNetStatus(String[][] listaIp, String nomePannello){
	
    	
    int altezza =0;
    
    if (listaIp.length<20)
    	altezza = listaIp.length * 50;
    else
    	altezza = 1000;
	
	
	setTitle("Gruppo: "+nomePannello);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
	
	
	
	JPanel panelButton =  new JPanel();
	
	panelButton.setLayout(new GridLayout(listaIp.length, 1));
	
	
	for(int i =0; i<listaIp.length; i++){
		NetStatusDevice nsd = new NetStatusDevice(listaIp[i][0]);
		panelButton.add(nsd);
//		ThreadPing tp = new ThreadPing(listaIp[i][0], button);
//		tp.start();
	}
    
	JScrollPane jsp = new JScrollPane(panelButton);
	jsp.setSize(200, altezza);
//	jsp.add(panelButton);
	
	this.setLayout(new BorderLayout());
	this.add(jsp, BorderLayout.CENTER);
	this.setSize(200, altezza);
	
	
//	panelButton.setVisible(true);
	panelButton.setSize(200, altezza);
	
	this.setVisible(true);	
	}
	
    public static void main(String[] args) throws IOException{
    	Tools tools = new Tools();
    	ArrayList<String> listaGruppi = tools.leggiFileRitorna("groups.ini");
    	
    	String[][] tabFiltrata1 = tools.getTabellaFiltrata(listaGruppi.get(1), tools.getTabellaClassificazione());
    	
//    	String[][] tabFiltrata1 = new String[11][3];
    	String ip="";
    	
//    	for(int i =0; i<11; i++){
//    		ip="192.168.0."+(i+1);
//    	
//    	tabFiltrata1[i][0] = ip;
//    	}
    	
    	for(int i=0; i<tabFiltrata1.length; i++)
    		System.out.println(tabFiltrata1[i][0]);
    	
    	
    	String[][] tabFiltrata2 = tools.getTabellaFiltrata(tools.getGruppoAllaPosizione(0), tools.getTabellaClassificazione());
    	PannelloMonitorElementiConNetStatus pme = new PannelloMonitorElementiConNetStatus(tabFiltrata1, tools.getGruppoAllaPosizione(1) );
    	PannelloMonitorElementiConNetStatus pme2 = new PannelloMonitorElementiConNetStatus(tabFiltrata2, tools.getGruppoAllaPosizione(0));
    }
	
}
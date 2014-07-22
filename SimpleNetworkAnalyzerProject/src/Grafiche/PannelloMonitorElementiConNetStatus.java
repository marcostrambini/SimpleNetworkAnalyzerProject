package Grafiche;

import it.nlmk.progetto01.ThreadPing;
import it.nlmk.progetto01.ThreadRepository;
import it.nlmk.progetto01.Tools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	
    public PannelloMonitorElementiConNetStatus(String[][] listaIp, String nomePannello, PannelloAvvioGruppi pag, final JButton button, int id){
	
    	Point point = pag.getLocation();
	setLocation(point.x+pag.getSize().width+ (id*50), point.y+(id*50));
    	
    	
    	button.setEnabled(false);
    int altezza =0;
    
    if (listaIp.length<20)
    	altezza = listaIp.length * 55;
    else
    	altezza = 1100;
	
	
	setTitle("Gruppo: "+nomePannello);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
	
	
	
	JPanel panelButton =  new JPanel();
	
	panelButton.setLayout(new GridLayout(listaIp.length, 1));
	
	
	for(int i =0; i<listaIp.length; i++){
		NetStatusDevice nsd = new NetStatusDevice(listaIp[i][0], listaIp[i][2]);
		panelButton.add(nsd);

	}
	
	

	
	
	
	//
    
	JScrollPane jsp = new JScrollPane(panelButton);
	jsp.setSize(500, altezza);

	
	this.setLayout(new BorderLayout());
	this.add(jsp, BorderLayout.CENTER);
	this.setSize(500, altezza);
	
	

	panelButton.setSize(500, altezza);
	
	this.addWindowListener(new WindowAdapter() 
	{
		public void windowClosing(WindowEvent e){
			button.setEnabled(true);

		}
		
	});
	
	this.setVisible(true);	
	}
	
    
    
    
    
    
    
//    public static void main(String[] args) throws IOException{
//    	Tools tools = new Tools();
//    	ArrayList<String> listaGruppi = tools.leggiFileRitorna("groups.ini");
//    	
//    	String[][] tabFiltrata1 = tools.getTabellaFiltrata(listaGruppi.get(1), tools.getTabellaClassificazione());
//    	
//
//    	String ip="";
//    	
//
//    	
//    	for(int i=0; i<tabFiltrata1.length; i++)
//    		System.out.println(tabFiltrata1[i][0]);
//    	
//    	
//    	String[][] tabFiltrata2 = tools.getTabellaFiltrata(tools.getGruppoAllaPosizione(0), tools.getTabellaClassificazione());
//    	PannelloMonitorElementiConNetStatus pme = new PannelloMonitorElementiConNetStatus(tabFiltrata1, tools.getGruppoAllaPosizione(1) );
//    	PannelloMonitorElementiConNetStatus pme2 = new PannelloMonitorElementiConNetStatus(tabFiltrata2, tools.getGruppoAllaPosizione(0));
//    }
	
}

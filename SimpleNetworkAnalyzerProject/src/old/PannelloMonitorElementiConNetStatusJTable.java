package old;

import it.nlmk.progetto01.ThreadPing;
import it.nlmk.progetto01.ThreadRepository;
import it.nlmk.progetto01.Tools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

import Grafiche.PannelloAvvioGruppi;

/**
 * classe che prende in input la lista degli indirizzi ip passati
 * ogni ip viene gestito dai un JLabel o JButton
 * ad ogni ip associo un ThreadPing che in base all'esito colora il JLabel (o JButton)
 * @author marcostrambini
 *
 */
public class PannelloMonitorElementiConNetStatusJTable extends JFrame {

	PannelloAvvioGruppi pag;
	public PannelloMonitorElementiConNetStatusJTable(){
		
	}
	
    public PannelloMonitorElementiConNetStatusJTable(String[][] listaIp, String nomePannello,PannelloAvvioGruppi pag, final JButton button){
	this.pag = pag;
	button.setEnabled(false);
    	
    int altezza =0;
    
    if (listaIp.length<20)
    	altezza = listaIp.length * 50;
    else
    	altezza = 1000;
	
	
	setTitle("Gruppo: "+nomePannello);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
	
	
	
	JPanel panelButton =  new JPanel();
	
	panelButton.setLayout(new GridLayout(listaIp.length, 1));
	Tools tools = new Tools();
	
	
	
	

	
	
	
	//


	
	this.setLayout(new BorderLayout());
	this.add(tools.getJTableOfGroups(listaIp));
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
	
    
    
    
    
    


	
}

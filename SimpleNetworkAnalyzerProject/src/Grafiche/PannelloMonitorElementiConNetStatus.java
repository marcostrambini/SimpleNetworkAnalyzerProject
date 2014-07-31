package Grafiche;

import it.nlmk.progetto01.ThreadPing;
import it.nlmk.progetto01.ThreadRepository;
import it.nlmk.progetto01.Tools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
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
//	setUndecorated(true);

    	button.setEnabled(false);
    	
    	int altezza =0;
    
    
    	JPanel panelButton =  new JPanel();
    
    if (listaIp.length<20){
    	if(listaIp.length<1){
    		altezza = 70;
    		panelButton.add(new JLabel("Nessun elemento"));
    		setUndecorated(false);
    		
    	}
    	else   		
    		altezza = listaIp.length * 55;
    }
    else
    	altezza = 1100;
	
	
	setTitle("Gruppo: "+nomePannello);
	
	
	if(listaIp.length>0)
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	else
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	panelButton.setLayout(new GridLayout(listaIp.length, 1));
	
	
	for(int i =0; i<listaIp.length; i++){
		NetStatusDevice nsd = new NetStatusDevice(listaIp[i][0], listaIp[i][2]);
		panelButton.add(nsd, BorderLayout.WEST);

	}

    
	JScrollPane jsp = new JScrollPane(panelButton);
	jsp.setSize(500, altezza);

	
	this.setLayout(new BorderLayout());
	this.add(jsp, BorderLayout.CENTER);
	this.setSize(500, altezza);
	
	

	panelButton.setSize(500, altezza);


	
//	this.addWindowListener(new WindowAdapter() 
//	{
//		public void windowClosing(WindowEvent e){
//			button.setEnabled(true);
//
//		}
//		
//	});
	
	this.setVisible(true);	
	}

	
}

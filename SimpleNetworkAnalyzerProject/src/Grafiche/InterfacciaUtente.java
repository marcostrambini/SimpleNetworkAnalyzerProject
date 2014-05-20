package Grafiche;

import it.nlmk.progetto01.Configurazione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

import Listener.ListenerTest;





/**
 * classe che genera l'interfaccia grafica a disposizione dell'utilizzatore
 * @author m.strambini
 *
 */
public class InterfacciaUtente extends JFrame {

	
	
	
private int larghezza;
private int altezza;

/**
 * costruttore a cui viene passato la misura della finestra come parametri	
 * @param larghezza
 * @param altezza
 */
public InterfacciaUtente (){
	this.larghezza = larghezza;
	this.altezza = altezza;
	
	Toolkit mioToolkit = Toolkit.getDefaultToolkit();
	Dimension dimensioniSchermo = mioToolkit.getScreenSize();
	
	int larghezzaFrame, altezzaFrame;
	larghezzaFrame = (int) (dimensioniSchermo.getWidth()*0.75);
	altezzaFrame = (int) (dimensioniSchermo.getHeight()*0.75);

	
//	JPanel pannelloUtente = new JPanel();
//	JMenu menu = new JMenu();
	setTitle("Simply Network Analyzer Project");
//	setSize(larghezza, altezza);
	setSize(larghezzaFrame, altezzaFrame);
	
	setResizable(false);
	
//	setLayout(new BorderLayout());
	setLayout(null);
//	add(BorderLayout.WEST , creaPannelloComandi());
//	add(BorderLayout.CENTER , creaPannelloUtente());
	
	add(creaPannelloComandi(larghezzaFrame, altezzaFrame ));
	add(creaPannelloUtente(larghezzaFrame, altezzaFrame));
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
	
}


//private void test(){
//  Configurazione conf = new Configurazione();
//  conf.verificoParametriIp();
//  String[] lista = conf.getListaIp();
//}


/**
 * metodo che ritorna il pannello comandi
 * @return
 */
private JPanel creaPannelloComandi(int larghezzaFrame, int altezzaFrame){
	int larghezzaPannelloComandi = ((larghezzaFrame / 10) * 2);
	final JPanel pannelloComandi = new JPanel();
	JButton buttonConfig = new JButton("Configurazione");
	JButton buttonGestGroups = new JButton("Gestione Gruppi");
	final JButton button01 = new JButton();
	final JButton button02 = new JButton();
	
	pannelloComandi.setLayout(new GridLayout(20,1));
//	pannelloComandi.setSize(600, altezza);
	pannelloComandi.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
	pannelloComandi.setBounds(0, 0, larghezzaPannelloComandi , altezzaFrame);
	pannelloComandi.setBackground(Color.WHITE);
	
	//test aggiunta bottoni*******************
//	for (int i=0; i<5; i++)
//		pannelloComandi.add(creaBottoneMenu("pippo"+i));
	//****************************************
	pannelloComandi.add(buttonConfig);
	pannelloComandi.add(buttonGestGroups);
	pannelloComandi.add(button01);
	pannelloComandi.add(button02);
	
	button01.setVisible(false);
	button02.setVisible(false);
	
	ActionListener listenerGestGroupst = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			button02.setText("click sul 2");
			button02.setVisible(true);
			button01.setVisible(false);
			PannelloGestioneGruppi pgc = new PannelloGestioneGruppi();
		}
	};
	
	ActionListener listenerConfig = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			button01.setText("click sul primo");
			button01.setVisible(true);
			button02.setVisible(false);
			PannelloInserimentoConfig pic = new PannelloInserimentoConfig();
	
		}
	};
	
	
	ActionListener listenerGenerico = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			JButton source = (JButton)ev.getSource();
			if(source == button02){
				Classificatore combo = new Classificatore("pippo");
				combo.setVisible(true);
			}
		}
	};
	
	
	
	buttonConfig.addActionListener(listenerConfig);
	buttonGestGroups.addActionListener(listenerGestGroupst);
	button02.addActionListener(listenerGenerico);
	
	
	
	return pannelloComandi;
}
	

/**
 * metodo che ritorna il pannello utente dove vengono visualizzati i dettagli
 * @return
 */
private JPanel creaPannelloUtente(int larghezzaFrame, int altezzaFrame){
	int larghezzaPannelloUtente = ((larghezzaFrame / 10) * 8);
	final JPanel pannelloUtente = new JPanel();
	pannelloUtente.setLayout(new GridLayout(20,15));
//	pannelloUtente.setSize(600, 700);
	pannelloUtente.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
	pannelloUtente.setBounds(((larghezzaFrame / 10) * 2)-1,0 , larghezzaPannelloUtente, altezzaFrame);
	pannelloUtente.setBackground(Color.WHITE);
	
//    Configurazione conf = new Configurazione();
//   
//    
//    conf.verificoParametriIp();
//    String[] lista = conf.getListaIp();
//    
   
	//test aggiunta bottoni*******************
//	for (int i=0; i<lista.length; i++)
//		pannelloUtente.add(creaBottoneMenu(lista[i]));
//	//****************************************
	
	
	return pannelloUtente;
}

/**
 * metodo che ritorna un bottone a cui associare una funzione
 * @return
 */
private JButton creaBottoneMenu(){
	
	JButton bottoneMenu = new JButton();
	bottoneMenu.setSize(100, 30);
	bottoneMenu.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
	bottoneMenu.setBackground(Color.WHITE);
	return bottoneMenu;
}


/**
 * metodo che ritorna un bottone a cui associare una funzione con passaggio del nome etichetta come parametro
 * @param label
 * @return
 */
private JButton creaBottoneMenu(String label){
	JButton bottoneMenu = new JButton();
	bottoneMenu.setSize(100, 30);
	bottoneMenu.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
	bottoneMenu.setBackground(Color.WHITE);
	bottoneMenu.setLabel(label);

	
	return bottoneMenu;
}

	
	
}

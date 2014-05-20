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
import java.io.IOException;

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

	setTitle("Simply Network Analyzer Project");
//	setSize(larghezzaFrame, altezzaFrame);
	this.setSize(301, 330);
	setResizable(true);
	setLayout(null);

	
//	add(creaPannelloComandi(larghezzaFrame, altezzaFrame ));
	add(creaPannelloComandi(300, 300));
	
//	add(creaPannelloUtente(larghezzaFrame, altezzaFrame));
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
	
}



/**
 * metodo che ritorna il pannello comandi
 * @return
 */
private JPanel creaPannelloComandi(int larghezzaFrame, int altezzaFrame){
	int larghezzaPannelloComandi = ((larghezzaFrame / 10) * 2);
	final JPanel pannelloComandi = new JPanel();
	final JButton buttonConfig = new JButton("Configurazione");
	final JButton buttonAvvio = new JButton("Avvio APP");
//	final JButton button01 = new JButton();
//	final JButton button02 = new JButton();
	
	pannelloComandi.setLayout(new GridLayout(2,1));
	pannelloComandi.setSize(300, 300);
//	pannelloComandi.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
//	pannelloComandi.setBounds(0, 0, larghezzaPannelloComandi , altezzaFrame);
//	pannelloComandi.setBackground(Color.WHITE);
	
	pannelloComandi.add(buttonAvvio);
	pannelloComandi.add(buttonConfig);
//	pannelloComandi.add(button01);
//	pannelloComandi.add(button02);
	
//	button01.setVisible(false);
//	button02.setVisible(false);
	
//	ActionListener listenerGestGroupst = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			button02.setText("click sul 2");
//			button02.setVisible(true);
//			button01.setVisible(false);
//			try {
//				PannelloGestioneGruppi pgc = new PannelloGestioneGruppi();
//			} catch (IOException e1) {
//				System.out.println("problemi con la creazione del PannelloGestioneGruppi");
//			}
//		}
//	};
//	
//	ActionListener listenerConfig = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			button01.setText("click sul primo");
//			button01.setVisible(true);
//			button02.setVisible(false);
//			PannelloInserimentoConfig pic = new PannelloInserimentoConfig();
//	
//		}
//	};
	
	
	ActionListener listenerGenerico = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent ev) {
			JButton source = (JButton)ev.getSource();
			if(source == buttonAvvio){
				if (source.getText() == "Avvio APP")
					buttonAvvio.setText("Stop APP");
				else
					buttonAvvio.setText("Avvio APP");
			}
			
			if(source == buttonConfig){
				try {
					Configurazione config = new Configurazione();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			
		}
	};
	
	
	
    buttonAvvio.addActionListener(listenerGenerico);
	
	
	
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
	pannelloUtente.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
	pannelloUtente.setBounds(((larghezzaFrame / 10) * 2)-1,0 , larghezzaPannelloUtente, altezzaFrame);
	pannelloUtente.setBackground(Color.WHITE);
	
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

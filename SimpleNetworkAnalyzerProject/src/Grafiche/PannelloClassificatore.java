package Grafiche;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.nlmk.progetto01.Configurazione;
import it.nlmk.progetto01.Tools;


/**
 * classe che crea un JFrame per la classificazione degli indirizzi ip tramite oggetti Classificatore
 * @author marcostrambini
 *
 */
public class PannelloClassificatore extends JFrame{

	
	public PannelloClassificatore() throws IOException{
		Configurazione configurazione = new Configurazione();
		int totIp = configurazione.getNumeroDiIpRange();
		String[] listaIp = configurazione.getListaIp();
		final JLabel labelInfo = new JLabel();
		JButton buttonConferma = new JButton("Conferma");
				
		this.setTitle("Classificatore");
		
		int colonne = 0;
		int righe = 0;
		int labelAggiunti = 0;
		
		if (totIp < 25){
			righe = totIp;
			colonne = 1;
		}	
		else{
			righe = 25;
			colonne = ((totIp / 25)+1);
			
		}		
		System.out.println("righe: "+righe);
		System.out.println("colonne: "+colonne);
		
		JPanel panelTesti = new JPanel();
		JPanel panelCentro = new JPanel();
		JPanel panelBottoni = new JPanel();
		
		
//		this.setLayout(new GridLayout((righe+3),colonne));
		
		panelTesti.add(labelInfo);
		panelTesti.setSize((400*colonne), 50);
		panelBottoni.add(buttonConferma);
		panelBottoni.setSize((400*colonne), 50);
		
		
		this.setLayout(new BorderLayout());
		this.setSize((400*colonne), panelTesti.getHeight()+panelBottoni.getHeight()+(righe*25));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		final Classificatore[] listaClassificatori = new Classificatore[totIp];
		
		for (int i=0; i < totIp; i++){
			Classificatore classificatore = new Classificatore(listaIp[i]);
			panelCentro.add(classificatore);
			listaClassificatori[i] = classificatore;
		}
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			String[] listaCsv = new String[listaClassificatori.length];
			String[] listaTxt = new String[listaClassificatori.length];
			Tools tools = new Tools();
			for(int i=0; i<listaClassificatori.length;i++){
			listaCsv[i] = (listaClassificatori[i].getLabel() + ","+ listaClassificatori[i].getValComboBox() + "," + listaClassificatori[i].getTextField() );
			listaTxt[i] = (listaClassificatori[i].getLabel() + " - "+ listaClassificatori[i].getValComboBox() + " - " + listaClassificatori[i].getTextField() );
			
			}
			try {
				tools.creaFile("classificazione.csv");
				tools.creaFile("classificazione.txt");
				tools.clearFile("classificazione.csv");
				tools.clearFile("classificazione.txt");
				tools.scriviFile("classificazione.csv", listaCsv);
				tools.scriviFile("classificazione.txt", listaTxt);
				
				labelInfo.setText("File .csv e .txt creati!");
				
				tools.leggiFile("classificazione.txt");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				labelInfo.setText("Problemi di lettura del file .txt");
			}
			}
		};
		
		buttonConferma.addActionListener(listener);
		
		this.add(panelTesti,BorderLayout.NORTH);
		this.add(panelCentro, BorderLayout.CENTER);
		this.add(panelBottoni, BorderLayout.PAGE_END);
		this.setVisible(true);
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PannelloClassificatore pc = new PannelloClassificatore();
	}
}

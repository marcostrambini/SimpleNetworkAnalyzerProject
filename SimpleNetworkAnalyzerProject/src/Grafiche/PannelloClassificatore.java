package Grafiche;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import it.nlmk.progetto01.Configurazione;
import it.nlmk.progetto01.Tools;

public class PannelloClassificatore {

	
	public PannelloClassificatore() throws IOException{
		Configurazione configurazione = new Configurazione();
		int totIp = configurazione.getNumeroDiIpRange();
		String[] listaIp = configurazione.getListaIp();
		final JLabel labelInfo = new JLabel();
		JButton buttonConferma = new JButton("Conferma");
		
		
		JFrame pC = new JFrame();
		pC.setTitle("Classificatore");
		pC.setLayout(new GridLayout((totIp+3),1));
		pC.setSize(400, (25*totIp));
		
		pC.add(labelInfo);
		
		final Classificatore[] listaClassificatori = new Classificatore[totIp];
		
		for (int i=0; i < totIp; i++){
			Classificatore classificatore = new Classificatore(listaIp[i]);
			pC.add(classificatore);
			listaClassificatori[i] = classificatore;
		}
		
		
		
		
		pC.setVisible(true);
		
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			String[] lista = new String[listaClassificatori.length];
			Tools tools = new Tools();
			for(int i=0; i<listaClassificatori.length;i++)
			lista[i] = (listaClassificatori[i].getLabel() + ","+ listaClassificatori[i].getValComboBox() + "," + listaClassificatori[i].getTextField() );
			
			try {
				tools.creaFile("classificazione.csv");
				tools.clearFile("classificazione.csv");
				tools.scriviFile("classificazione.csv", lista);
				labelInfo.setText("File .csv creato!");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
		
		buttonConferma.addActionListener(listener);
		
		pC.add(new JLabel());
		pC.add(buttonConferma);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PannelloClassificatore pc = new PannelloClassificatore();
	}
}

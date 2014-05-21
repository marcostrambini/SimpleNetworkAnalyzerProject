package Grafiche;

import it.nlmk.progetto01.Coloratore;
import it.nlmk.progetto01.Configurazione;
import it.nlmk.progetto01.Tools;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * classe che genera un JFrame per la gestione di 5 gruppi per la classificazione degli indirizzi ip
 * @author marcostrambini
 *
 */
public class PannelloGestioneGruppi extends JFrame{


	JLabel labelGp01 = new JLabel("Gruppo 01:");
	JLabel labelGp02 = new JLabel("Gruppo 02:");
	JLabel labelGp03 = new JLabel("Gruppo 03:");
	JLabel labelGp04 = new JLabel("Gruppo 04:");
	JLabel labelGp05 = new JLabel("Gruppo 05:");
		
	JTextField textGp01 = new JTextField("");
	JTextField textGp02 = new JTextField("");
	JTextField textGp03 = new JTextField("");
	JTextField textGp04 = new JTextField("");
	JTextField textGp05 = new JTextField("");
		
	JButton button = new JButton("registra");
	JLabel labelInfo = new JLabel();
//    JButton buttonRefresh = new JButton("refresh");
	
    Tools tools = new Tools();
	
	public PannelloGestioneGruppi() throws IOException{
		setTitle("Gestione Gruppi");
		setSize(300, 300);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new GridLayout(6,2));
		add(labelGp01);
		add(textGp01);
		add(labelGp02);
		add(textGp02);
		add(labelGp03);
		add(textGp03);
		add(labelGp04);
		add(textGp04);
		add(labelGp05);
		add(textGp05);

		
//		add(buttonRefresh);
		add(labelInfo);
		add(button);
		
		refreshEsistente();
		
		
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Tools tools = new Tools();
				
				ArrayList<String> listaArray = new ArrayList<String>();
				listaArray.add("escludi");
				if (!textGp01.getText().isEmpty())
					listaArray.add(textGp01.getText());
				if (!textGp02.getText().isEmpty())
					listaArray.add(textGp02.getText());
				if (!textGp03.getText().isEmpty())
					listaArray.add(textGp03.getText());
				if (!textGp04.getText().isEmpty())
					listaArray.add(textGp04.getText());
				if (!textGp05.getText().isEmpty())
					listaArray.add(textGp05.getText());
				
				String[] listaParametri = new String[listaArray.size()];
				
				for(int i=0;i<listaArray.size();i++)	
					listaParametri[i] = listaArray.get(i);
				

				try {
					tools.creaFile("groups.ini");
					tools.clearFile("groups.ini");
					tools.scriviFile("groups.ini", listaParametri);
					labelInfo.setText("file aggiornato");
					
				} catch (IOException e) {

				}

				try {
					tools.leggiFile("groups.ini");
				} catch (IOException e1) {
			
					e1.printStackTrace();
				}
				
				try {
					refreshEsistente();
				} catch (IOException e) {
				System.out.println("problemi con il refresh");
				}
			
			}
			
		};
		
//		ActionListener listenerRefresh = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					refreshEsistente();
//				} catch (IOException e1) {
//				System.out.println("problemi con la lettura del file");
//				}
//				
//			}
//		};
		
		button.addActionListener(listener);
//		buttonRefresh.addActionListener(listenerRefresh);
		
		setLocation(500, 200);
		setVisible(true);
		
	}
	
	/**
	 * metodo che legge il file che contiene la lista dei gruppi e ne ripropone i valori
	 * @throws IOException
	 */
	private void refreshEsistente() throws IOException{
		String nomeFile = "groups.ini";
		
		String[] arrayRigheFile;
		
		if (tools.esisteFile(nomeFile)){
		     textGp05.setText("");
		     textGp04.setText("");
		     textGp03.setText("");
		     textGp02.setText("");
		     textGp01.setText("");
			
			
			ArrayList<String> listRigheFile = tools.leggiFileRitorna(nomeFile);
			arrayRigheFile = tools.listToArray(listRigheFile);
			
			switch(arrayRigheFile.length){
			case 5: textGp05.setText(arrayRigheFile[4]);
			case 4:	textGp04.setText(arrayRigheFile[3]);
			case 3: textGp03.setText(arrayRigheFile[2]);
			case 2: textGp02.setText(arrayRigheFile[1]);
			case 1: textGp01.setText(arrayRigheFile[0]);
			}
				
				
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PannelloGestioneGruppi pic =  new PannelloGestioneGruppi();
		
		
	}

}

package Grafiche;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.nlmk.progetto01.Configurazione;
import it.nlmk.progetto01.Init;
import it.nlmk.progetto01.Tools;


/**
 * classe che crea un JFrame per la classificazione degli indirizzi ip tramite oggetti Classificatore
 * @author marcostrambini
 *
 */
public class PannelloClassificatore extends JFrame{

	
	PannelloConfigurazione pc;
	public JLabel labelInfo = new JLabel();
	public JButton buttonConferma = new JButton("Conferma");
	public JButton buttonRecupera = new JButton("recupera esistente");
	
	public JPanel panelTesti = new JPanel();
	public JPanel panelCentro = new JPanel();
	public JPanel panelBottoni = new JPanel();
	
	public PannelloClassificatore(final PannelloConfigurazione pc) throws IOException{
		this.pc = pc;
		
		
		Configurazione configurazione = new Configurazione();
		int totIp = configurazione.getNumeroDiIpRange();
		String[] listaIp = configurazione.getListaIp();
		
		
		
		this.setTitle("Classificatore");
		
		int colonne = 0;
		int righe = 0;
		int labelAggiunti = 0;
		
		if (totIp < 20){
			righe = totIp;
			colonne = 1;
		}	
		else{
			righe = 20;
			colonne = ((totIp / 25)+1);
			
		}		
		
		System.out.println("righe: "+righe);
		System.out.println("colonne: "+colonne);
		
		FrameLog.setTextArea("righe: "+righe);
		FrameLog.setTextArea("colonne: "+colonne);
		

		
		
//		this.setLayout(new GridLayout((righe+3),colonne));
		
		panelTesti.add(labelInfo);
		panelTesti.setSize((400*colonne), 50);
		panelBottoni.setSize((400*colonne), 50);
		panelBottoni.setLayout(new GridLayout(1,3));
		panelBottoni.add(buttonRecupera);

		panelBottoni.add(buttonConferma);
		
		panelCentro.setLayout(new GridLayout(totIp,1));
		
		this.setLayout(new BorderLayout());

		this.setSize(700, panelTesti.getHeight()+panelBottoni.getHeight()+(righe*30));
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		Point point = new Point(pc.getPositionX()+pc.getSize().width, pc.getPositionY());
		Point point = pc.getLocation();
		
		setLocation(point.x+pc.getSize().width, point.y);
		
		
		
		final Classificatore[] listaClassificatori = new Classificatore[totIp];
		
		
		//aggiungio i classificatori al panelCentro
		for (int i=0; i < totIp; i++){
			Classificatore classificatore = new Classificatore(listaIp[i]);
			panelCentro.add(classificatore);
			listaClassificatori[i] = classificatore;
		}
		final JScrollPane jsp = new JScrollPane(panelCentro);
		jsp.setSize(400, totIp*25);
		
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
			JButton source = (JButton)ev.getSource();
			if(source == buttonConferma){
			
				// TODO Auto-generated method stub
			String[] listaCsv = new String[listaClassificatori.length];
			String[] listaTxt = new String[listaClassificatori.length];
			Tools tools = new Tools();
			ArrayList<String> arrayListTemp = new ArrayList<String>();
			for(int i=0; i<listaClassificatori.length;i++){
			String textFieldVal = listaClassificatori[i].getTextField();
			if (!listaClassificatori[i].getTextField().isEmpty())
				textFieldVal = listaClassificatori[i].getTextField();
			else
				textFieldVal = "non_identificato";
			
				
			listaCsv[i] = (listaClassificatori[i].getLabel() + ","+ listaClassificatori[i].getValComboBox() + "," + textFieldVal);
			listaTxt[i] = (listaClassificatori[i].getLabel() + " - "+ listaClassificatori[i].getValComboBox() + " - " + textFieldVal);
			arrayListTemp.add(listaTxt[i]);
			}
			
			try {
				
				Init.resetListaClassificazione();
				Init.listaClassificazione = arrayListTemp;
				tools.creaFile("classificazione.csv");
				tools.creaFile("classificazione.txt");
				tools.clearFile("classificazione.csv");
				tools.clearFile("classificazione.txt");
				tools.scriviFile("classificazione.csv", listaCsv);
				tools.scriviFile("classificazione.txt", listaTxt);
				labelInfo.setText("File .csv e .txt creati!");
				tools.leggiFile("classificazione.txt");
//				tools.clearFile("groups.ini");
				tools.scriviFileGruppi(tools.getTabellaClassificazione());
				FrameLog.setTextArea("classificato");
				FrameLog.setTextArea(tools.leggiFileRitorna("classificazione.txt"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				labelInfo.setText("Problemi di lettura del file .txt");
			}
			}
			
			
			if(source == buttonRecupera){
				
				panelCentro.removeAll();
				
				
				Tools tool = new Tools();
				String[][] listaClassificata = tool.getTabellaClassificazioneDaArrayList();
				panelCentro.setLayout(new GridLayout(Init.listaClassificazione.size(),1));
				panelCentro.setSize(400, Init.listaClassificazione.size()*25);
				for (int i=0; i < Init.listaClassificazione.size(); i++){
					
					Classificatore classificatore = new Classificatore(listaClassificata[i][0], tool.getPosizioneDelGruppo(listaClassificata[i][1]), listaClassificata[i][2]);
					panelCentro.add(classificatore);
//					listaClassificatori[i] = classificatore;
				}
//				JScrollPane jsp = new JScrollPane(panelCentro);
				jsp.setSize(400, Init.listaClassificazione.size()*25);
				
				
				
				panelCentro.invalidate();
				panelCentro.validate();
				panelCentro.repaint();
				invalidate();
				validate();
				repaint();
				
			}
			}
		};
		
		buttonConferma.addActionListener(listener);
		buttonRecupera.addActionListener(listener);
		
		this.add(panelTesti,BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(panelBottoni, BorderLayout.PAGE_END);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e){
				pc.setEnableButtonGestGruppi();
				pc.setEnableButtonFileConfig();
				System.out.println("chiuso");
				FrameLog.setTextArea("chiusa finestra Classificazione");
			}
			
		});
		
		
	
	}
	

}

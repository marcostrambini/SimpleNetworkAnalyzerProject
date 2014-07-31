package Grafiche;

import it.nlmk.progetto01.Coloratore;
import it.nlmk.progetto01.Configurazione;
import it.nlmk.progetto01.Init;
import it.nlmk.progetto01.Tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.colorchooser.ColorSelectionModel;

/**
 * classe che genera un JFrame per la gestione di 5 gruppi per la classificazione degli indirizzi ip
 * @author marcostrambini
 *
 */
public class PannelloGestioneGruppi extends JFrame{

	
	public int numeroGruppiEsistenti = Init.listaGruppi.size() - 1;
	public JLabel labelHead = new JLabel();
	public JLabel labelInfo = new JLabel();
	
	JPanel panelHead = new JPanel();
	public JPanel panelBody = new JPanel();
	JPanel panelControls = new JPanel();
	
	public ArrayList<JTextField> listaTempObject = new ArrayList<JTextField>();

		
	JButton buttonRegistra = new JButton("registra");
	JButton buttonAggiungi = new JButton("aggiungi");

	
    Tools tools = new Tools();
	PannelloConfigurazione pc;
	
	public PannelloGestioneGruppi(final PannelloConfigurazione pc) throws IOException{
		this.pc = pc;
       
		//dispongo il frame
		Point point = pc.getLocation();
		setLocation(point.x+pc.getSize().width, point.y);
		
		setTitle("Gestione Gruppi");
		setSize(300, 50 + (50*numeroGruppiEsistenti));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelHead.setLayout(new GridLayout(1, 2));
		panelHead.add(labelHead);
		panelHead.add(labelInfo);
		
		
		//aggiungo elementi al body
		refreshBody();
		
		panelControls.setLayout(new GridLayout(1, 2));
		panelControls.add(buttonAggiungi);
		panelControls.add(buttonRegistra);
		
		
		add(panelHead, BorderLayout.NORTH);
		add(panelBody, BorderLayout.CENTER);
		add(panelControls, BorderLayout.SOUTH);
			
		
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ev) {
				JButton source = (JButton)ev.getSource();

				if (source == buttonRegistra){
					Tools tools = new Tools();
					Init.resetListaGruppi();
					System.out.println("la listagruppi contiene: "+Init.listaGruppi.size());

					ArrayList<String> listaArray = new ArrayList<String>();
					listaArray.add("escludi");

					for(int i=0; i < listaTempObject.size();i++){
						if(!listaTempObject.get(i).getText().isEmpty())
							listaArray.add(listaTempObject.get(i).getText());
					}

					listaTempObject.removeAll(listaTempObject);


				
				String[] listaParametri = new String[listaArray.size()];
				
				for(int i=0;i<listaArray.size();i++)	
					listaParametri[i] = listaArray.get(i);
				

				try {
					tools.creaFile("groups.ini");
					Tools.clearFile("groups.ini");
					tools.scriviFile("groups.ini", listaParametri);
					
					
					Init.listaGruppi = listaArray;
					numeroGruppiEsistenti = (listaArray.size() - 1);
					labelInfo.setText("file aggiornato");
					
					refreshBody();
					
				} catch (IOException e) {

				}

				try {
					tools.leggiFile("groups.ini");
				} catch (IOException e1) {
			
					e1.printStackTrace();
				}

			
			}
			
			
			if (source == buttonAggiungi){

				numeroGruppiEsistenti++;
				Init.listaGruppi.add("");
				refreshBody();
				labelInfo.setText("");
			}
		}
		};

		
		buttonRegistra.addActionListener(listener);
		buttonAggiungi.addActionListener(listener);
	
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e){
				pc.setEnableButtonClassicazione();
				pc.setEnableButtonFileConfig();
				System.out.println("chiuso");
				FrameLog.setTextArea("chiusa finestra Gestione Gruppi");

			}
			
		});
	}
	
	
	public void refreshBody(){
//		aggiungo elementi al body
	
		int gruppiRicalcolati = 0;
		if(numeroGruppiEsistenti<0)
			gruppiRicalcolati =0;
		else
			gruppiRicalcolati = numeroGruppiEsistenti;
			
		
		labelHead.setText("Gruppi esistenti: "+ gruppiRicalcolati);
		
		panelBody.removeAll();
		listaTempObject.removeAll(listaTempObject);
		
		if (numeroGruppiEsistenti == 0){
			panelBody.setLayout(new GridLayout(1,2));
			setSize(300, 50 + (55*1));
			buttonRegistra.setEnabled(false);
		}
		else{
			panelBody.setLayout(new GridLayout(numeroGruppiEsistenti,2));
			setSize(300, 50 + (55*numeroGruppiEsistenti));
			buttonRegistra.setEnabled(true);
		}
		
		
		
		for(int i =0; i<gruppiRicalcolati;i++){
			panelBody.add(new JLabel("Gruppo "+ (i+1) + " : "));
			JTextField jtf = new JTextField(Init.listaGruppi.get(i+1));
			panelBody.add(jtf);
			listaTempObject.add(jtf);
		}
		
		invalidate();
		validate();
		repaint();
	}
	

}

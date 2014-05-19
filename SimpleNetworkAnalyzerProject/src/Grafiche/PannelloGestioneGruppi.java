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
    JButton buttonRecupera = new JButton("recupera esistente");
	
	
	public PannelloGestioneGruppi(){
		setTitle("Gestione Gruppi");
		setSize(300, 300);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new GridLayout(9,2));
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

		
		add(buttonRecupera);
		add(button);
		
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Tools tools = new Tools();
//				Configurazione conf = new Configurazione();
//				Coloratore coloratore = new Coloratore();
				
				ArrayList<String> listaArray = new ArrayList<String>();
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
				
				
//				if(tools.checkIp(textIpStart.getText())){
//					listaParametri[0] = textIpStart.getText();
//					coloratore.coloraSfondoTextBianco(textIpStart);
//				}else
//					coloratore.coloraSfondoTextRosso(textIpStart);
//
//				if(tools.checkIp(textIpEnd.getText()))
//					listaParametri[1] = textIpEnd.getText();
//				else
//					textIpEnd.setBackground(Color.red);
//
//				if(tools.checkIp(textMask.getText()))
//					listaParametri[2] = textMask.getText();
//				else
//					textMask.setBackground(Color.red);
//
//				if(tools.checkIp(textGateway.getText()))
//					listaParametri[3] = textGateway.getText();
//				else
//					textGateway.setBackground(Color.red);
//
//				if(tools.checkIp(textIpDb.getText()))
//					listaParametri[4] = textIpDb.getText();
//				else
//					textIpDb.setBackground(Color.red);
//				
//				listaParametri[5] = textNomeDb.getText();
//				listaParametri[6] = textUserDb.getText();
//				listaParametri[7] = textPwdDb.getText();




				try {
					tools.creaFile("groups.ini");
					tools.clearFile("groups.ini");
					tools.scriviFile("groups.ini", listaParametri);
//					tools.generaConfigIni(listaParametri);
				} catch (IOException e) {
//					 TODO Auto-generated catch block
//					e.printStackTrace();
				}

				try {
					tools.leggiFile("groups.ini");
				} catch (IOException e1) {
			
					e1.printStackTrace();
				}
			
			}
			
		};
		
		ActionListener listenerRecupera = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				try {
					Tools tools = new Tools();
					tools.leggiFile("groups.ini");
			

					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("qualche problema col file!!");
//					e1.printStackTrace();
				}
				
			
				
				
			}
		};
		
		button.addActionListener(listener);
		buttonRecupera.addActionListener(listenerRecupera);
		
		setLocation(500, 200);
		setVisible(true);
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PannelloGestioneGruppi pic =  new PannelloGestioneGruppi();
		
		
	}

}

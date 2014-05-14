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

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PannelloInserimentoConfig extends JFrame{


	JLabel labelIpStart = new JLabel("Ip Iniziale:");
	JLabel labelIpEnd = new JLabel("Ip Finale:");
	JLabel labelMask = new JLabel("Mask:");
	JLabel labelGateway = new JLabel("Gateway:");
	JLabel labelIpDb = new JLabel("Ip Database:");
	JLabel labelNomeDb = new JLabel("Nome Database:");
	JLabel labelUserDb = new JLabel("User Database:");
	JLabel labelPortaDb = new JLabel("Password Database:");
	
	JTextField textIpStart = new JTextField();
	JTextField textIpEnd = new JTextField();
	JTextField textMask = new JTextField();
	JTextField textGateway = new JTextField();
	JTextField textIpDb = new JTextField();
	JTextField textNomeDb = new JTextField("no_name");
	JTextField textUserDb = new JTextField("no_name");
	JTextField textPwdDb = new JTextField("no_name");
	
	JCheckBox cb = new JCheckBox();

	
	
	
	JButton button = new JButton("registra");
    JButton buttonRecupera = new JButton("recupera esistente");
	
	
	
//	JPanel panel = new JPanel();
	
	public PannelloInserimentoConfig(){
		setTitle("Settaggio config.ini");
		setSize(300, 300);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new GridLayout(9,2));
		add(labelIpStart);
		add(textIpStart);
		add(labelIpEnd);
		add(textIpEnd);
		add(labelMask);
		add(textMask);
		add(labelGateway);
		add(textGateway);
		add(labelIpDb);
		add(textIpDb);
		add(labelNomeDb);
		add(textNomeDb);
		add(labelUserDb);
		add(textUserDb);
		add(labelPortaDb);
		add(textPwdDb);
		
		add(buttonRecupera);
		add(button);
		
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Tools tools = new Tools();
//				Configurazione conf = new Configurazione();
				Coloratore coloratore = new Coloratore();
				String[] listaParametri = new String[8];
				
				if(tools.checkIp(textIpStart.getText())){
					listaParametri[0] = textIpStart.getText();
					coloratore.coloraSfondoTextBianco(textIpStart);
				}else
					coloratore.coloraSfondoTextRosso(textIpStart);

				if(tools.checkIp(textIpEnd.getText()))
					listaParametri[1] = textIpEnd.getText();
				else
					textIpEnd.setBackground(Color.red);

				if(tools.checkIp(textMask.getText()))
					listaParametri[2] = textMask.getText();
				else
					textMask.setBackground(Color.red);

				if(tools.checkIp(textGateway.getText()))
					listaParametri[3] = textGateway.getText();
				else
					textGateway.setBackground(Color.red);

				if(tools.checkIp(textIpDb.getText()))
					listaParametri[4] = textIpDb.getText();
				else
					textIpDb.setBackground(Color.red);
				
				listaParametri[5] = textNomeDb.getText();
				listaParametri[6] = textUserDb.getText();
				listaParametri[7] = textPwdDb.getText();




				try {

					tools.generaConfigIni(listaParametri);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					tools.leggiFile("config.ini");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
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
					tools.leggiFile("config.ini");
					Configurazione conf = new Configurazione();
					
					textIpStart.setText(conf.getIpStart());
					textIpEnd.setText(conf.getIpEnd());
					textMask.setText(conf.getMask());
					textGateway.setText(conf.getGateway());
					textIpDb.setText(conf.getIpDb());
					textNomeDb.setText(conf.getNomeDb());
					textUserDb.setText(conf.getUserDb());
					textPwdDb.setText(conf.getPwdDb());
//					repaint();
					
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
		PannelloInserimentoConfig pic =  new PannelloInserimentoConfig();
		
		
	}

}

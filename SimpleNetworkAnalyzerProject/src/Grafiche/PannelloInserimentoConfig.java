package Grafiche;

import it.nlmk.progetto01.Tools;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
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
	JTextField textNomeDb = new JTextField();
	JTextField textUserDb = new JTextField();
	JTextField textPortaDb = new JTextField();

	
	
	
	JButton button = new JButton("registra");

	
	
	
	JPanel panel = new JPanel();
	
	public PannelloInserimentoConfig(){
	
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		add(textPortaDb);
		
		
		
		add(new JLabel());
		add(button);
		
		ActionListener listener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Tools tools = new Tools();
				String[] listaParametri = new String[8];
				listaParametri[0] = textIpStart.getText();
				listaParametri[1] = textIpEnd.getText();
				listaParametri[2] = textMask.getText();
				listaParametri[3] = textGateway.getText();
				listaParametri[4] = textIpDb.getText();
				listaParametri[5] = textNomeDb.getText();
				listaParametri[6] = textUserDb.getText();
				listaParametri[7] = textPortaDb.getText();
				
				
				
			
					try {
						
						tools.generaConfigIni(listaParametri);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
			
		};
		
		button.addActionListener(listener);
		
		
		setLocation(500, 200);
		setVisible(true);
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PannelloInserimentoConfig pic =  new PannelloInserimentoConfig();
		
	}

}

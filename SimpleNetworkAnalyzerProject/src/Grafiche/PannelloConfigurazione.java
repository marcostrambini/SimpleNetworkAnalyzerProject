package Grafiche;

import it.nlmk.progetto01.Flags;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PannelloConfigurazione extends JFrame {

	InterfacciaUtente iu;
	private int posX, posY;
	private JButton buttonFileConfig = new JButton("Configurazione Network");
	private JButton buttonGestGruppi = new JButton("Gestione Gruppi");
	private JButton buttonClassicazione = new JButton("Classificazione");
	
	public void setEnableButtonFileConfig(){
		this.buttonFileConfig.setEnabled(true);
	}
	
	public void setEnableButtonGestGruppi(){
		this.buttonGestGruppi.setEnabled(true);
	}
	
	public void setEnableButtonClassicazione(){
		this.buttonClassicazione.setEnabled(true);
	}
	
	public void setDisableButtonFileConfig(){
		this.buttonFileConfig.setEnabled(false);
	}
	
	public void setDisableButtonGestGruppi(){
		this.buttonGestGruppi.setEnabled(false);
	}
	
	public void setDisableButtonClassicazione(){
		this.buttonClassicazione.setEnabled(false);
	}
	
	public int getPositionX(){
		return posX;
	}
	
	public int getPositionY(){
		
		return posY;
	}
	
	
	public  PannelloConfigurazione(final InterfacciaUtente iu) {
		this.iu = iu;
		this.setTitle("Configurazioni");
		this.setSize(300, 200);
		this.setLayout(new GridLayout(3, 1));
		
		Point point = iu.getLocation();
		
		this.setLocation(point.x+iu.getSize().width, point.y);
//		this.setLocation(iu.getPositionX() + iu.getSize().width , (int) iu.getPositionY());
		posX = iu.getPositionX()+iu.getSize().width;
		posY = iu.getPositionY();
		
		System.out.println("posizione X iniziale pannello configurazione = "+posX);
		System.out.println("posizione Y iniziale pannello configurazione = "+posY);
		
//		final JButton buttonFileConfig = new JButton("Configurazione Network");
//		final JButton buttonGestGruppi = new JButton("Gestione Gruppi");
//		final JButton buttonClassicazione = new JButton("Classificazione");

		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				JButton source = (JButton)ev.getSource();
				if(source == buttonFileConfig){
					if(buttonFileConfig.isEnabled() && !buttonClassicazione.isEnabled()){
						System.out.println("Pannello File Config gia' aperto");
					}else{
						PannelloInserimentoConfig pic = new PannelloInserimentoConfig(PannelloConfigurazione.this);
						setDisableButtonClassicazione();
						setDisableButtonGestGruppi();
					}
					
				}
				if(source == buttonGestGruppi){
					try {
						if(buttonGestGruppi.isEnabled() && !buttonFileConfig.isEnabled()){
							System.out.println("pannello gestione gruppi gia' aperto");
						}else{
							
							PannelloGestioneGruppi pgg = new PannelloGestioneGruppi(PannelloConfigurazione.this);
							setDisableButtonFileConfig();
							setDisableButtonClassicazione();
						}
					} catch (IOException e) {
						System.out.println("problemi con il pannello di gestione gruppi");
					}
				}
				if(source == buttonClassicazione){
					try {
						if(buttonClassicazione.isEnabled() && !buttonFileConfig.isEnabled()){
							System.out.println("pannello classificazione gia' aperto");
						}else{
							
							PannelloClassificatore pcl = new PannelloClassificatore(PannelloConfigurazione.this);
							setDisableButtonFileConfig();
							setDisableButtonGestGruppi();
						}
					} catch (IOException e) {
						System.out.println("problemi con il pannello classificatore");
					}
				}
			}
		};
		
		buttonFileConfig.addActionListener(listener);
		buttonGestGruppi.addActionListener(listener);
		buttonClassicazione.addActionListener(listener);
		
		
		this.add(buttonFileConfig);
		this.add(buttonGestGruppi);
		this.add(buttonClassicazione);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e){
				iu.setEnableButtonAvvio();
				System.out.println("chiuso");

			}
			
		});
		
		
		
		
		
		
		
		
		this.setVisible(true);
	}


}

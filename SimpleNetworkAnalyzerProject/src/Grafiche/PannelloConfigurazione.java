package Grafiche;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PannelloConfigurazione extends JFrame {

	public  PannelloConfigurazione() {
		this.setTitle("Configurazioni");
		this.setSize(300, 200);
		this.setLayout(new GridLayout(3, 1));

		final JButton buttonFileConfig = new JButton("Configurazione Network");
		final JButton buttonGestGruppi = new JButton("Gestione Gruppi");
		final JButton buttonClassicazione = new JButton("Classificazione");

		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				JButton source = (JButton)ev.getSource();
				if(source == buttonFileConfig){
					PannelloInserimentoConfig pic = new PannelloInserimentoConfig();
				}
				if(source == buttonGestGruppi){
					try {
						PannelloGestioneGruppi pgg = new PannelloGestioneGruppi();
					} catch (IOException e) {
						System.out.println("problemi con il pannello di gestione gruppi");
					}
				}
				if(source == buttonClassicazione){
					try {
						PannelloClassificatore pcl = new PannelloClassificatore();
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

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		PannelloConfigurazione pconf = new PannelloConfigurazione();
	}

}

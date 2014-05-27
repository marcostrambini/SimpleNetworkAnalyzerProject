package Grafiche;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PannelloComandi {

	
	/**
	 * metodo che ritorna il pannello comandi
	 * @return
	 */
	private JPanel creaPannelloComandi(int larghezzaFrame, int altezzaFrame){
		int larghezzaPannelloComandi = ((larghezzaFrame / 10) * 2);
		JPanel pannelloComandi = new JPanel();
		JButton buttonConfig = new JButton("Configurazione");
		
		pannelloComandi.setLayout(new GridLayout(20,1));
//		pannelloComandi.setSize(600, altezza);
		pannelloComandi.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
		pannelloComandi.setBounds(0, 0, larghezzaPannelloComandi , altezzaFrame);
		pannelloComandi.setBackground(Color.WHITE);
		
		//test aggiunta bottoni*******************
//		for (int i=0; i<5; i++)
//			pannelloComandi.add(creaBottoneMenu("pippo"+i));
		//****************************************
		pannelloComandi.add(buttonConfig);
		ActionListener listenerConfig = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PannelloInserimentoConfig pannelloInserimento = new PannelloInserimentoConfig(null);
				
				
			}
		};
		
		buttonConfig.addActionListener(listenerConfig);
		
		
		
		
		
		return pannelloComandi;
	}
	
	
	
	
}

package Grafiche;

import it.nlmk.progetto01.FrameRepository;
import it.nlmk.progetto01.Init;
import it.nlmk.progetto01.ThreadRepository;
import it.nlmk.progetto01.Tools;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * classe che costruisce il pannello con tanti JButton quanti sono i gruppi 
 * cliccando sui JButton viene aperta una finestra con la lista degli ip contenuti e viene eseguito il controllo di risposta al ping
 * @author marcostrambini
 *
 */
public class PannelloAvvioGruppi extends JFrame {

	InterfacciaUtente iu;
//	private JButton buttonAvviaTutti = new JButton("Avvia Tutti");
	
	public PannelloAvvioGruppi(final InterfacciaUtente iu) throws IOException{
		ThreadRepository.flagGoInterrupt = false;
		this.iu = iu;
		final Tools tools = new Tools();
		String nomeFile = "groups.ini";
		
		Point point = iu.getLocation();
		setLocation(point.x+iu.getSize().width, point.y);
		setTitle("Avvia Gruppi");
		
		
	
		
		
		
		setVisible(true);
		
		
		ArrayList<String> listaGruppi = tools.leggiFileRitorna(nomeFile);
	
//	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		setLayout(new GridLayout(listaGruppi.size() , 1));
		
		setSize(300, ((listaGruppi.size())*50));
		System.out.println("size: "+listaGruppi.size());
		
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				JButton source = (JButton)ev.getSource();
//				if (source != buttonAvviaTutti){
				try {
					int id = tools.getPosizioneDelGruppo(source.getText());
					
					String[][] tabFiltrata = tools.getTabellaFiltrata(tools.getGruppoAllaPosizione(tools.getPosizioneDelGruppo(source.getText())), tools.getTabellaClassificazione());
					FrameRepository.add(new PannelloMonitorElementiConNetStatus(tabFiltrata, source.getText(),PannelloAvvioGruppi.this, source, id));
//					FrameRepository.add(new PannelloMonitorElementiConNetStatusJTable(tabFiltrata, source.getText(), PannelloAvvioGruppi.this, source));
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			
//				}

			}
		};
		
		
		
		
		for(int i = 1; i<listaGruppi.size();i++){
		JButton button = new JButton(listaGruppi.get(i));
		
		System.out.println("numero gruppi nell'array statico: " +Init.listaGruppi.size());
		
		button.addActionListener(listener);
//		buttonAvviaTutti.addActionListener(listener);
		
		add(button);
		}
	
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e){
				iu.setEnableButtonConfig();
				iu.setLabelButtonAvvio("Avvio APP");
				System.out.println("chiuso");
				
				System.out.println("Numero di Thread nell'array: "+ThreadRepository.Count());
				ThreadRepository.flagGoInterrupt = true;
				ThreadRepository.stopAllThread();

			}
			
		});
		
		
		
	}
	
	
	


}

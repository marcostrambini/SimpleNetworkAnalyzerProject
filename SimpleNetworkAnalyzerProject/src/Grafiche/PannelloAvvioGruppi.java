package Grafiche;

import it.nlmk.progetto01.Tools;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PannelloAvvioGruppi extends JFrame {

	InterfacciaUtente iu;
	
	public PannelloAvvioGruppi(final InterfacciaUtente iu) throws IOException{
//	public PannelloAvvioGruppi() throws IOException{	
		this.iu = iu;
		Tools tools = new Tools();
		String nomeFile = "groups.ini";
		
		Point point = iu.getLocation();
		setLocation(point.x+iu.getSize().width, point.y);
		setTitle("Avvia Gruppi");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
		ArrayList<String> listaGruppi = tools.leggiFileRitorna(nomeFile);
		setLayout(new GridLayout((listaGruppi.size()-1) , 1));
		
		setSize(300, (listaGruppi.size()-1)*50);
		System.out.println("size: "+listaGruppi.size());
		
		for(int i = 1; i<listaGruppi.size();i++)
			add(new JButton(listaGruppi.get(i)));
		
		
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e){
				iu.setEnableButtonConfig();
				iu.setLabelButtonAvvio("Avvio APP");
				System.out.println("chiuso");

			}
			
		});
		
		
		
	}
	
	
	


}

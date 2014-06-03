package Grafiche;

import it.nlmk.progetto01.Tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PannelloRiepilogoGruppi extends JFrame {

	
	
	public PannelloRiepilogoGruppi() throws IOException{
		
		Tools tools = new Tools();
		
		Classificatore classificatore = new Classificatore();
		setSize(600, 600);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel upPanel = new JPanel();
		
		
		upPanel.setLayout(new GridLayout(1,2));
		upPanel.setSize(500, 400);
		JButton buttonConferma = new JButton("conferma");
		JComboBox comboGruppi = classificatore.getComboGruppi(classificatore.getListaParametri());
		
		upPanel.add(comboGruppi);
		upPanel.add(buttonConferma);
		
		upPanel.setVisible(true);
		
		add(upPanel, BorderLayout.NORTH);
		
		String[] columnNames = {"Indirizzo Ip", "Gruppo", "Descrizione"};
		
		String[][] tabella = tools.getTabellaClassificazione();
		String[][] tabellaFiltrata = getTabellaFiltrata((String) comboGruppi.getItemAt(2), tabella);
		
		
		
		JTable table = new JTable(tabellaFiltrata, columnNames);
		System.out.println(table.getRowCount());
		table.setPreferredScrollableViewportSize(new Dimension(500, 150));
		table.setFillsViewportHeight(true);
		

		JScrollPane sp = new JScrollPane(table);
		add(sp, BorderLayout.CENTER);
		
	}
	
	
	
	private String[][] getTabellaFiltrata(String filtro, String[][] tabella){
		Tools tools = new Tools();
		String[][] tabellaFiltrata = new String[tabella.length][3];
		
		int pos =0;
		
		for(int i =0; i<tabella.length; i++){
//			int pos = 0;
			if (tabella[i][1].equals(filtro)){
				tabellaFiltrata[pos][0] = tabella[i][0];
				System.out.print(tabellaFiltrata[pos][0]+" ");
				tabellaFiltrata[pos][1] = tabella[i][1];
				System.out.print(tabellaFiltrata[pos][1]+" ");
				tabellaFiltrata[pos][2] = tabella[i][2];
				System.out.println(tabellaFiltrata[pos][2]);
			
				pos++;
		}
			
		}
		System.out.println("righe: "+pos);
		return tabellaFiltrata;
				
	}
	
	
	
	
	
	
	public static void main(String[] args) throws IOException{
		PannelloRiepilogoGruppi prg = new PannelloRiepilogoGruppi();
		
	}
	
	
}

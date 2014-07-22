package Grafiche;

import it.nlmk.progetto01.Configurazione;
import it.nlmk.progetto01.Tools;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Classificatore_old extends JPanel {
	String nome ="";
	JLabel label = new JLabel(nome);
	JTextField textField = new JTextField();
	JComboBox comboGruppi = getComboGruppi(getListaParametri());
	
	public Classificatore_old(){
		
	}
	
	public Classificatore_old(String nome){
//		this.nome = nome;
		label.setText(nome);
		Tools tools = new Tools();
		String nomeFile = "groups.ini";
		//conf.verificoParametriIp();
		String[] parametri;
		try {
			parametri = tools.listToArray(tools.leggiFileRitorna(nomeFile));
		} catch (IOException e) {
			System.out.println("problemi con la creazione della lista dei parametri");
			// TODO Auto-generated catch block
			parametri = null;
			e.printStackTrace();
		}
		
		setLayout(new GridLayout(1,3));
		setSize(400, 45);
	
		
		
		
		add(label);
		add(comboGruppi);
//		add(getComboGruppi(parametri));
		add(textField);
	
	}


public String[] getListaParametri(){
	Tools tools = new Tools();
	String nomeFile="groups.ini";
	String[] parametri;
	try {
		parametri = tools.listToArray(tools.leggiFileRitorna(nomeFile));
	} catch (IOException e) {
		System.out.println("problemi con il getListaParametri() in Classificatore");
		
		e.printStackTrace();
		return null;
	}
	return parametri;
}
	
	
	
public JComboBox getComboGruppi(String[] elencoGruppi){
//	Configurazione conf = new Configurazione();
//	conf.verificoParametriIp();
//	String[] elencoIp = conf.getListaIp();

	JComboBox comboGruppi = new JComboBox(elencoGruppi);
	
	comboGruppi.setSelectedIndex(0);
	add(comboGruppi);
	return comboGruppi;
}

public String getLabel(){
	return label.getText();
}

public String getTextField(){
	return textField.getText();
}

public String getValComboBox(){
	return (String)comboGruppi.getSelectedItem();
}

}



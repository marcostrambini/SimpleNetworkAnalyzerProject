package it.nlmk.progetto01;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Classificatore extends JFrame {
	String nome ="";
	
	public Classificatore(String nome){
		this.nome = nome;
		Configurazione conf = new Configurazione();
		conf.verificoParametriIp();
		String[] elencoIp = conf.getListaIp();
		
		setLayout(new GridLayout(1,3));
		setSize(400, 80);
	
		JLabel label = new JLabel(nome);
		JTextField textField = new JTextField();
		
		
		
		
		add(label);
		add(getComboGruppi(elencoIp));
		add(textField);
	
	}


	
	
	
	
private JComboBox getComboGruppi(String[] elencoGruppi){
//	Configurazione conf = new Configurazione();
//	conf.verificoParametriIp();
//	String[] elencoIp = conf.getListaIp();
	String[] elencoValori = {"Acciaieria", "Laminatoio", "Trusted"};
	JComboBox comboGruppi = new JComboBox(elencoGruppi);
	
	comboGruppi.setSelectedIndex(0);
	add(comboGruppi);
	return comboGruppi;
}




}



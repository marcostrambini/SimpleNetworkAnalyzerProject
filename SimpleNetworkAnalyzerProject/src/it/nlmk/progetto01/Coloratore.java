package it.nlmk.progetto01;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Classe che gestisci il cambio dei colori di alcuni oggetti grafici
 * @author marcostrambini
 *
 */
public class Coloratore {

	/**
	 * metodo che colora di rosso lo sfondo di un JTextField passato come parametro
	 * @param text
	 */
	public void coloraSfondoTextRosso(JTextField text){
		text.setBackground(Color.RED);
	}
	
	/**
	 * metodo che colora di bianco lo sfondo di un JTextField passato come parametro
	 * @param text
	 */
	public void coloraSfondoTextBianco(JTextField text){
		text.setBackground(Color.WHITE);
	}
	
	/**
	 * metodo che colora di rosso il testo di un JTextField passato come parametro
	 * @param text
	 */
	public void coloraTextRosso(JTextField text){
		text.setForeground(Color.RED);
	}
	
	/**
	 * metodo che colora di Nero il testo di un JTextField passato come parametro
	 * @param text
	 */
	public void coloraTextNero(JTextField text){
		text.setForeground(Color.BLACK);
	}
	
	/**
	 * metodo che colora di rosso lo sfondo di un JButton passato come parametro
	 * @param button
	 */
	public void coloraBottoneRosso(JButton button){
		button.setBackground(Color.RED);
	}
	
	/**
	 * metodo che colora di verde lo sfondo di un JButton passato come parametro
	 * @param button
	 */
	public void coloraBottoneVerde(JButton button){
		button.setBackground(Color.GREEN);
	}
}

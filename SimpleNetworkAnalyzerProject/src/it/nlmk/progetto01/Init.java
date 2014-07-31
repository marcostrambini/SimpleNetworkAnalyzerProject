package it.nlmk.progetto01;

import java.io.IOException;
import java.util.ArrayList;

/**
 * classe che inizializza degli array statici che contengono i nomi dei gruppi e la configurazione effettuata la volta precedente
 * @author marcostrambini
 *
 */
public class Init {

	public static ArrayList<String> listaGruppi = new ArrayList<String>();
	public static ArrayList<String> listaClassificazione = new ArrayList<String>();
	
	
	public Init(){
		
		Tools tools = new Tools();
		String nomeFileGruppi = "groups.ini";
		String nomeClassificazione = "classificazione.txt";
		
		try {
			listaGruppi = tools.leggiFileRitorna(nomeFileGruppi);
		} catch (IOException e) {
			System.out.println("Problemi ad inizializzare la lista dei gruppi esistenti");
		}
		
		try {
			listaClassificazione= tools.leggiFileRitorna(nomeClassificazione);
		} catch (IOException e) {
			System.out.println("Problemi ad inizializzare la lista della configurazione esistente");
		}
		
		
	}
	
	public static void resetListaGruppi(){
		listaGruppi.removeAll(listaGruppi);
	}
	
	public static void resetListaClassificazione(){
		
		listaClassificazione.removeAll(listaClassificazione);
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Init init = new Init();
	
	for(String s : init.listaGruppi)
	System.out.println(s);
	
	System.out.println("----------------------");
	
	for(String s : init.listaClassificazione)
	System.out.println(s);

	resetListaGruppi();
	System.out.println("----------------------");
	for(String s : init.listaGruppi)
		System.out.println(s);
	
	
	}

}

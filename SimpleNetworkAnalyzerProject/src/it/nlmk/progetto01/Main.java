package it.nlmk.progetto01;

import java.io.FileNotFoundException;

import Grafiche.FrameLog;
import Grafiche.InterfacciaUtente;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/**
		 * avvio l'inizializzazione dei parametri
		 */
		Init init = new Init();
		
		InterfacciaUtente interfaccia = new InterfacciaUtente();
        FrameLog fl = new FrameLog(interfaccia);
	}

}

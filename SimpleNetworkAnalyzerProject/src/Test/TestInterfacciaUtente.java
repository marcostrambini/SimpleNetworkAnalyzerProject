package Test;

import java.io.FileNotFoundException;

import it.nlmk.progetto01.Init;
import it.nlmk.progetto01.Tools;
import Grafiche.FrameLog;
import Grafiche.InterfacciaUtente;

public class TestInterfacciaUtente {

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

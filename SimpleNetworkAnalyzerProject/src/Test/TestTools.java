package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import it.nlmk.progetto01.Configurazione;
import it.nlmk.progetto01.Tools;

public class TestTools {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		Tools tools = new Tools();
		ArrayList<String> listaGruppi = tools.leggiFileRitorna("groups.ini");
		tools.stampaSuConsole(listaGruppi);
		
		String[][] tabConfigurazione = tools.getTabellaFiltrata(listaGruppi.get(1), tools.getTabellaClassificazione());

		tools.stampaSuConsole(tabConfigurazione);
		
}
}
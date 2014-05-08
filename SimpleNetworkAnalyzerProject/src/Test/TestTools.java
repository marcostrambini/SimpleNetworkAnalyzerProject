package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import it.nlmk.progetto01.Tools;

public class TestTools {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String nomeFile = "pippo.txt";
		
		Tools tools = new Tools();
		tools.creaFile("pippo.txt");
		tools.scriviFile("pippo.txt", "marco");
		tools.scriviFile("pippo.txt", "strambini");
		
		String[] parole = new String[]{"ciao", "come", "va?"};
		tools.scriviFile("pippo.txt", parole);
		
		tools.leggiFile(nomeFile);
		System.out.println("-------------------------------------------");
		ArrayList<String> testArrayFile = new ArrayList<String>();
		testArrayFile = tools.leggiFileRitorna(nomeFile);
		
		for(int i=0; i<testArrayFile.size(); i++)
			System.out.println(testArrayFile.get(i));
		
	}

}

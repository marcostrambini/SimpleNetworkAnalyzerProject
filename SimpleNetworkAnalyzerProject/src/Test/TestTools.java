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
		String nomeFile2 = "test.txt";
		
		Tools tools = new Tools();
		tools.creaFile(nomeFile);
		tools.creaFile(nomeFile2);
		
		tools.clearFile(nomeFile);
		tools.clearFile(nomeFile2);
		
		
		tools.scriviFile(nomeFile, "marco");
		tools.scriviFile(nomeFile, "strambini");
		
		tools.scriviFile(nomeFile2, "prova del secondo file");
		
		
		String[] parole = new String[]{"ciao", "come", "va?"};
		tools.scriviFile(nomeFile, parole);
		
		tools.leggiFile(nomeFile);
		System.out.println("1: ----------------------------------------");
		tools.leggiFile(nomeFile2);
		System.out.println("2: ----------------------------------------");
		ArrayList<String> testArrayFile = new ArrayList<String>();
		testArrayFile = tools.leggiFileRitorna(nomeFile);
		
		for(int i=0; i<testArrayFile.size(); i++)
			System.out.println(testArrayFile.get(i));
		
		tools.deleteFile(nomeFile);
		tools.deleteFile(nomeFile2);
		tools.clearFile("groups.txt");
		tools.scriviFile("groups.txt", "test");
		tools.leggiFile("groups.txt");
//		tools.clearFile("groups.txt");
		System.out.println("3: ---------------------------------------");
		tools.leggiFile("groups.txt");
//		tools.leggiFile("config2.ini");
		String ipAddress = "100.200.30.40";
//		tools.verificoConsistenzaValorParametriIp(ipAddress);
		System.out.println("4: ---------------------------------------");
	
		System.out.println(tools.checkIp(ipAddress));
	}

}

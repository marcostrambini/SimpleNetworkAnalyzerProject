package it.nlmk.progetto01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Tools {

	/**
	 * metodo che esegue un ping passando come parametro indirizzo ip
	 * @param ipAddress
	 * @return
	 * @throws IOException
	 */
	public boolean ping(String ipAddress) throws IOException{
		
	    InetAddress inet = InetAddress.getByName(ipAddress);
	    return inet.isReachable(3000);
	}
	
	/**
	 * metodo che esegue un ping passando come parametro indirizzo ip e timeout
	 * @param ipAddress
	 * @param time
	 * @return
	 * @throws IOException
	 */
	public boolean ping(String ipAddress, int time) throws IOException{
		
	    InetAddress inet = InetAddress.getByName(ipAddress);
	    return inet.isReachable(time);
	}
	
	/**
	 * metodo per la creazione di un file passado il nome
	 * @param nomeFile
	 * @throws FileNotFoundException 
	 */
	public void creaFile(String nomeFile) throws FileNotFoundException{
		File file = new File(nomeFile);
		
		if (file.exists())
			System.out.println(nomeFile + " esiste gia'");
		else{

			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}
	}
	
    /**
     * metodo che scrive una stringa in un file
     * @param nomeFile
     * @param parola
     * @throws FileNotFoundException
     */
	public void scriviFile(String nomeFile, String parola) throws FileNotFoundException{
		FileOutputStream fos = new FileOutputStream(nomeFile, true);
		PrintWriter scrivi = new PrintWriter(fos);
		scrivi.println(parola);
		scrivi.close();
	}

	/**
	 * metodo che scrive una array di sctringhe su file
	 * @param nomeFile
	 * @param parole
	 * @throws FileNotFoundException
	 */
	public void scriviFile(String nomeFile, String[] parole) throws FileNotFoundException{
		FileOutputStream fos = new FileOutputStream(nomeFile, true);
		PrintWriter scrivi = new PrintWriter(fos);
		for (int i=0; i<parole.length; i++)
		  scrivi.println(parole[i]);
		
		scrivi.close();
	}
	
	/**
	 * metodo che legge un file e ne stampa il contenuto riga per riga nel terminale
	 * @param nomeFile
	 * @throws IOException
	 */
	public void leggiFile(String nomeFile) throws IOException{
		FileReader fr = new FileReader(nomeFile);
        BufferedReader br = new BufferedReader(fr);
        String sCurrentLine;
        while((sCurrentLine = br.readLine()) != null){
        	System.out.println(sCurrentLine);
        }
		fr.close();
			
	}
	
	/**
	 * metodo che legge il contenuto di un file e lo restituisce in un array di stringhe
	 * @param nomeFile
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String>  leggiFileRitorna(String nomeFile) throws IOException{
		ArrayList<String> arrayLetto = new ArrayList<String>();
		String stringa;
		FileReader fr = new FileReader(nomeFile);
		BufferedReader br = new BufferedReader(fr);
		//      br.readLine();
		String sCurrentLine;
		while((sCurrentLine = br.readLine()) != null){
			
			arrayLetto.add(sCurrentLine);
		}
		arrayLetto.add("FINE");
		fr.close();
		return arrayLetto;
	}

	/**
	 * pulisce il contenuto di un file dato il nome come parametro
	 * @param nomeFile
	 * @throws FileNotFoundException
	 */
	public void clearFile(String nomeFile) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(nomeFile); 
		pw.close();
		
	}
	
	/**
	 * cancella un file dato il nome come parametro
	 * @param nomeFile
	 */
	public void deleteFile(String nomeFile){
		File fileDelete = new File(nomeFile);
		fileDelete.delete();
	}
	
	public void generaConfigIni(String[] listaParametri) throws IOException{
		String nomeFile = "config.ini";
		
		creaFile(nomeFile);
		clearFile(nomeFile);
		
		scriviFile(nomeFile, "**************************");
		scriviFile(nomeFile, "* File di configurazione *");
		scriviFile(nomeFile, "**************************");
		scriviFile(nomeFile, "* ip address start");
		scriviFile(nomeFile, "ipStart = "+listaParametri[0]);
		scriviFile(nomeFile, "* ip address end");
		scriviFile(nomeFile, "ipEnd = "+listaParametri[1]);
		scriviFile(nomeFile, "* subnet mask");
		scriviFile(nomeFile, "ipEnd = "+listaParametri[2]);
		scriviFile(nomeFile, "* gateway");
		scriviFile(nomeFile, "ipEnd = "+listaParametri[3]);
		scriviFile(nomeFile, "* ip db");
		scriviFile(nomeFile, "ipDb = "+listaParametri[4]);
		scriviFile(nomeFile, "* Nome db");
		scriviFile(nomeFile, "nomeDb = "+listaParametri[5]);
		scriviFile(nomeFile, "* user Db");
		scriviFile(nomeFile, "userDb = "+listaParametri[6]);
		scriviFile(nomeFile, "* pwd db");
		scriviFile(nomeFile, "pwdDb = "+listaParametri[7]);
		
	}
	
	
}

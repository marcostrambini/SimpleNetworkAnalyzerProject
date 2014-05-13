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
	
	/**
	 * metodo che genera il file di configurazione config.ini
	 * i parametri sono verificate in fase di inserimento tramite il PannelloInserimentoConfig
	 * @param listaParametri
	 * @throws IOException
	 */
	public void generaConfigIni(String[] listaParametri) throws IOException{
		String nomeFile = "config.ini";
		
		creaFile(nomeFile);
		clearFile(nomeFile);
		
		scriviFile(nomeFile, "**************************");
		scriviFile(nomeFile, "* File di configurazione *");
		scriviFile(nomeFile, "**************************");
		scriviFile(nomeFile, "* ip address start");
		if (listaParametri[0] != null)
			scriviFile(nomeFile, "ipStart = "+listaParametri[0]);
		else
			scriviFile(nomeFile, "ipStart = 0.0.0.0");	
		
		scriviFile(nomeFile, "* ip address end");
		if (listaParametri[1] != null)
		scriviFile(nomeFile, "ipEnd = "+listaParametri[1]);
		else
			scriviFile(nomeFile, "ipEnd = 0.0.0.0");	
		scriviFile(nomeFile, "* subnet mask");
		
		if (listaParametri[2] != null)
		scriviFile(nomeFile, "mask = "+listaParametri[2]);
		else
			scriviFile(nomeFile, "mask = 0.0.0.0");	
		scriviFile(nomeFile, "* gateway");
		
		if (listaParametri[3] != null)
		scriviFile(nomeFile, "gateway = "+listaParametri[3]);
		else
			scriviFile(nomeFile, "gateway = 0.0.0.0");	
		scriviFile(nomeFile, "* ip db");
		
		if (listaParametri[4] != null)
		scriviFile(nomeFile, "ipDb = "+listaParametri[4]);
		else
			scriviFile(nomeFile, "ipDb = 0.0.0.0");	
		scriviFile(nomeFile, "* Nome db");
		
		if (listaParametri[5] != null)
		scriviFile(nomeFile, "nomeDb = "+listaParametri[5]);
		else
			scriviFile(nomeFile, "nomeDb = no_name");	
		scriviFile(nomeFile, "* user Db");
		
		if (listaParametri[6] != null)
		scriviFile(nomeFile, "userDb = "+listaParametri[6]);
		else
			scriviFile(nomeFile, "userDb = no_name");	
		scriviFile(nomeFile, "* pwd db");
		
		if (listaParametri[7] != null)
		scriviFile(nomeFile, "pwdDb = "+listaParametri[7]);
		else
			scriviFile(nomeFile, "pwdDb = no_name");	
		
	}
	
	
	/**
	 * metodo che verifica che la lunghezza della stringa ipAddress sia da 7 a 15 caratteri
	 * @param ipAddress
	 * @return
	 */
	private boolean verificoLughezzaIp(String ipAddress){
		
		if (ipAddress.length()>=7 && ipAddress.length()<=15 )
			return true;
		else 
			return false;
	}
	
	/**
	 * metodo che verifica che ci siano 3 puntini nella stringa ipAddress
	 * @param ipAddress
	 * @return
	 */
	private boolean verificoPuntiniIp(String ipAddress){
		int contaPuntiniCharAt =0;
		for (int i =0; i<ipAddress.length(); i++){
			if (ipAddress.charAt(i) == '.'){
				contaPuntiniCharAt++;
			}
		}
		if (contaPuntiniCharAt == 3)
			return true;
		else
			return false;
	}
	
	/**
	 * metodo che verifica la consistenza di ogni parametro che compone l'ip minimo 0, max 255
	 * @param ipAddress
	 * @return
	 */
	private boolean verificoConsistenzaValorParametriIp(String ipAddress){
		String test;
		

		
		test = ipAddress.substring(0, ipAddress.indexOf('.'));
//		System.out.println(test);
		if (verificoInt255(test)){
			
			ipAddress = ipAddress.substring(ipAddress.indexOf('.')+1);
			test = ipAddress.substring(0, ipAddress.indexOf('.'));
//			System.out.println(test);
			if (verificoInt255(test)){
			
				ipAddress = ipAddress.substring(ipAddress.indexOf('.')+1);
				test = ipAddress.substring(0, ipAddress.indexOf('.'));
//				System.out.println(test);
				if (verificoInt255(test)){
					ipAddress = ipAddress.substring(ipAddress.indexOf('.')+1);
//					System.out.println(ipAddress);
					return verificoInt255(ipAddress);
					}else
						return false;
			}else
				return false;
		}else
			return false;
				

	}
	
	/**
	 * metodo che verifica se una stringa trasformata in un numero sia compresa tra 0 e 255
	 * @param valore
	 * @return
	 */
	private boolean verificoInt255(String valore){
		if (Integer.parseInt(valore) >=0 && Integer.parseInt(valore) <= 255){
//			System.out.println("vero");
			return true;
		}else{
//			System.out.println("falso");
			return false;
		}
	}
	
	/**
	 * metodo che verifica la consistenza di un indirizzo ip
	 * @param ipAddress
	 * @return
	 */
	public boolean checkIp(String ipAddress){
		if (verificoLughezzaIp(ipAddress)){
//			System.out.println("lunghezza ok");
			if(verificoPuntiniIp(ipAddress)){
//				System.out.println("puntini ok");
				if (verificoConsistenzaValorParametriIp(ipAddress)){
//					System.out.println("consistenza parametri");
					return true;
			}else
					return false;
			}else	
				return false;
			}else
			return false;
	}
	
	
}

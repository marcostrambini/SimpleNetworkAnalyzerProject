package it.nlmk.progetto01;

import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Configurazione {

	private String mask;
	private String ipStart ;
	private String gateway;
	private String ipEnd;
	private String ipDb;
	private String nomeDb;
	private String userDb;
	private String pwdDb;



	/**
	 * @param args
	 * @throws IOException 
	 */
	public Configurazione() throws IOException{
				
		Tools tools = new Tools();
		String nomeFile = "config.ini";
		ArrayList<String> fileLetto;

		checkFile(nomeFile);
		fileLetto = tools.leggiFileRitorna(nomeFile);
//		System.out.println("Dimensione del file di configurazione: "+fileLetto.size());
		getConfig(fileLetto);
		
//		for(int i = 0; i<fileLetto.size();i++)	
//			System.out.println(fileLetto.get(i));
//		System.out.println("fine costruttore Configurazione()");

	}


	//	/**
	//	 * Funzione che prende in carico le stringhe ip e ne verifica la consistenza
	//	 */
	//	public void verificoParametriIp(){
	//		String[] array = getConfig(readFileConfig());
	//		int numFalse =0;
	//		for (int i =0; i<array.length; i++){
	//			System.out.println("ip " + (i+1) + " " + array[i]);
	//			if(!checkIp(array[i]))
	//				numFalse++;
	//			
	//			
	//		}
	//		if (numFalse>0)
	//			System.out.println("Il file di configurazione presenta degli errori negli ip");
	//	}
	//	


	/**
	 * Funzione che dato il file di configurazione, salva nelle variabili le stringhe
	 * associate
	 * @return 
	 * @throws IOException 
	 */
	public void getConfig(ArrayList<String> nomeFile) 	{

		String[] listaParametri = new String[nomeFile.size()];
		String parametro;
		String valpar;
		String uguale;
		String riga;
//		System.out.println("all'interno del getConfig il size() e': "+nomeFile.size());
		if (nomeFile.size() > 1){
			
				for (int n = 0; n < listaParametri.length -1 ; n++){
					//					String a;
//					System.out.println("ciclo n�: "+n);
					if (nomeFile.get(n).contains("*")){
//						System.out.println("la riga "+ n + " contiene *");
					}else{
					
					
					
					StringTokenizer st = new StringTokenizer(nomeFile.get(n));
					parametro = st.nextToken();
					st.nextToken();
					valpar = st.nextToken();
//					System.out.println("Parametro: "+parametro);
//					System.out.println("Valore: "+valpar);
	


					/* recupero ipStart */
					if(parametro.compareTo("ipStart")==0)   
						setIpStart(valpar);
//					else 
//						setIpStart("0.0.0.0");

				
					/* recupero ipEnd  */
					if(parametro.compareTo("ipEnd")==0)  
						setIpEnd(valpar);
//						else 
//							setIpEnd("0.0.0.0");
						//
						/* recupero mask  */
						if(parametro.compareTo("mask")==0) 
							setMask(valpar);
//						else 
//							setMask("0.0.0.0");

						/* recupero gateway  */
						if(parametro.compareTo("gateway")==0)   
							setGateway(valpar);
//						else 
//							setGateway("0.0.0.0");

						/* recupero ip database  */
						if(parametro.compareTo("ipDb")==0)   
							setIpDb(valpar);
//						else 
//							setIpDb("0.0.0.0");

						/* recupero nome Db  */
						if(parametro.compareTo("nomeDb")==0)    
							setNomeDb(valpar);
//						else 
//							setNomeDb(null);

						/* recupero user Db  */
						if(parametro.compareTo("userDb")==0)   
							setUserDb(valpar);
//						else 
//							setUserDb("no name");

						//						/* recupero pwd Db  */
						if(parametro.compareTo("pwdDb")==0)  
							setPwdDb(valpar);
//						else 
//							setPwdDb("no name");
//
//					}
				}
			
			}
		}

		}

		

	public String getMask() {
		return mask;
	}


	private void setMask(String mask) {
		this.mask = mask;
	}


	public String getIpStart() {
		return ipStart;
	}


	private void setIpStart(String ipStart) {
		this.ipStart = ipStart;
	}


	public String getGateway() {
		return gateway;
	}


	private void setGateway(String gateway) {
		this.gateway = gateway;
	}


	public String getIpEnd() {
		return ipEnd;
	}


	private void setIpEnd(String ipEnd) {
		this.ipEnd = ipEnd;
	}


	public String getIpDb() {
		return ipDb;
	}


	private void setIpDb(String ipDb) {
		this.ipDb = ipDb;
	}


	public String getNomeDb() {
		return nomeDb;
	}


	private void setNomeDb(String nomeDb) {
		this.nomeDb = nomeDb;
	}


	public String getUserDb() {
		return userDb;
	}


	private void setUserDb(String userDb) {
		this.userDb = userDb;
	}


	public String getPwdDb() {
		return pwdDb;
	}


	private void setPwdDb(String pwdDb) {
		this.pwdDb = pwdDb;
	}


	//	}
	
	/**
	 * Funzione che controlla se esiste il file di configurazione
	 */
	public void checkFile(String nomeFile){
		File f = new File(nomeFile);
		if (f.exists())
			System.out.println("Il file esiste");
		else
			System.out.println("File di configurazione mancante");
	}
	
     


	
	/**
	 * Funzione che ritorna le cifre dell'ip data la posizione da 1 a 4
	 * @param pos
	 * @param ipAddress
	 * @return
	 */
	public int getValorePos(int pos, String ipAddress){
		
		int val1 =0;
//		if (pos >=1 && pos<=4)
//			System.out.println("Posizione valida "+pos);
	
		Integer[] listaParametri = new Integer[]{0,0,0,0};
		for (int i=0; i<4; i++){
			if (ipAddress.indexOf('.')<0){
				listaParametri[i]= Integer.parseInt(ipAddress);
			}else{
				listaParametri[i] = Integer.parseInt(ipAddress.substring(0, ipAddress.indexOf('.')));
				ipAddress = ipAddress.substring(ipAddress.indexOf('.')+1);
				}
			}
		
		return listaParametri[pos-1];
		
	}

	/**
	 * Funzione che verifica che gli ip stiano nella stessa rete
	 * considera ip con subnet 255.255.255.0
	 * @param ip1
	 * @param ip2
	 * @return
	 */	
	public boolean checkAppartenenzaIpRete(String ip1, String ip2){
//		ip1 = getIpStart();
//		ip2 = getIpEnd();
//		
		if ((getValorePos(1, ip2) - getValorePos(1, ip1)) == 0)
			if ((getValorePos(2, ip2) - getValorePos(2, ip1)) == 0)
				if ((getValorePos(3, ip2) - getValorePos(3, ip1)) == 0)
					return true;
				else
					return false;
			else
				return false;
		else
			return false;
	}
	
	
	/**
	 * Funzione che restituisce il numero di ip compresi nel range definito nel file di
	 * configurazione
	 * @return
	 */
	public int getNumeroDiIpRange(){
		int ipHostStart = getValorePos(4, getIpStart());
		int ipHostEnd = getValorePos(4, getIpEnd());
		
		return ((ipHostEnd-ipHostStart)+1);
	}	
	
	
	public String[] getListaIp(){
		if(checkAppartenenzaIpRete(getIpStart(), getIpEnd())){
			String subnet = "";
			int ipHostStart = getValorePos(4, getIpStart());
//			int ipHostEnd = getValorePos(4, getIpEnd());
			String[] listaIp = new String[getNumeroDiIpRange()];
			subnet = (getValorePos(1, getIpStart())+"."+getValorePos(2, getIpStart())+"."+getValorePos(3, getIpStart())+".");
				for (int i=0; i<(getNumeroDiIpRange()); i++){
					
					System.out.println(subnet + (ipHostStart+i));
					listaIp[i] = (subnet + (ipHostStart+i));
			}
			return listaIp; 
		}
		
		else 
			return null;
	}
	
	
	
	/**
	 * Funzione che controlla la consistenza di un idirizzo ip preso come stringa
	 * controllo che la lunghezza sia tra 7 e 15 caratteri
	 * controllo che ci siano esattamente 3 puntini
	 * controllo che ogni parte che compone l'ip stia tra 0 e 255
	 * @param ipAddress
	 * @return
	 */	
	public boolean checkIp(String ipAddress){
	int contaPuntiniCharAt =0;
	
//  condizione che verifica la lunghezza dell'ip come stringa 
	if (ipAddress.length()>=7 && ipAddress.length()<=15 ){
		
//	A verifico quanto puntini ci sono

	for (int i =0; i<ipAddress.length(); i++){
		if (ipAddress.charAt(i) == '.'){
			contaPuntiniCharAt++;
		}
	}
	if (contaPuntiniCharAt == 3){
		System.out.println("numero puntini ok = "+contaPuntiniCharAt);
	

//	A fine
	
//  B inserisco i valori dei paramtri in un array	
	String[] listaParametri = new String[]{"","","",""};
	for (int i=0; i<4; i++){
		if (ipAddress.indexOf('.')<0){
			listaParametri[i]= ipAddress;
		}else{
			listaParametri[i] = ipAddress.substring(0, ipAddress.indexOf('.'));
			ipAddress = ipAddress.substring(ipAddress.indexOf('.')+1);
			}
		}
	
	
	
	for (int i=0; i<4; i++){
		System.out.println("Parametro " + (i+1) + " : " + listaParametri[i]);
	}
//  B fine blocco
	
//	C controllo se i parametri dell'ip stanno tra 0 e 255
	for (int i=0; i<listaParametri.length;i++){
	
		if (Integer.parseInt(listaParametri[i]) >=0 && Integer.parseInt(listaParametri[i]) <= 255){
			System.out.println("Parametro "+(i+1)+" consistente = "+listaParametri[i]);
			return true;
		}
		else{
			System.out.println("Parametro "+(i+1)+" non consistente = "+listaParametri[i]);
			return false;
		}
	}
//  C fine blocco	
	
	}
	
	else{
		System.out.println("numero puntini sbagliato = "+contaPuntiniCharAt);
		return false;
	}
	return true;
	}
	
	else{
		System.out.println("numero di caratteri sbagliato");
	return false;
	}
	
	
	
	}

	
} 

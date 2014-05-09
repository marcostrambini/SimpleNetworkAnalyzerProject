package it.nlmk.progetto01;

import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Configurazione {

	private  String mask;
	private  String ipStart;
	private  String gateway;
	private  String ipEnd;

	/**
	 * @param args
	 */
	public Configurazione(){
	
	}
		
	
	/**
	 * Funzione che prende in carico le stringhe ip e ne verifica la consistenza
	 */
	public void verificoParametriIp(){
		String[] array = getConfig(readFileConfig());
		int numFalse =0;
		for (int i =0; i<array.length; i++){
			System.out.println("ip " + (i+1) + " " + array[i]);
			if(!checkIp(array[i]))
				numFalse++;
		}
		if (numFalse>0)
			System.out.println("Il file di configurazione presenta degli errori negli ip");
	}
	
	

	/**
	 * Funzione che dato il file di configurazione, salva nelle variabili le stringhe
	 * associate
	 */
	public String[] getConfig(String[] arrconf)	{
		arrconf = readFileConfig();
		String[] arrayParametri = new String[4];
		String parametro;
		String valpar;
		if (arrconf.length > 1){
			try{
				for (int n = 0; n < arrconf.length ; n++){
					if (arrconf[n]== null ){ 
					}else{

						StringTokenizer st = new StringTokenizer(arrconf[n]);
						parametro = st.nextToken(); //acquisisco il primo token (codice del parametro)
						st.nextToken(); //secondo token (simbolo =)
						valpar = st.nextToken(); //acquisisco il terzo token (il valore del parametro)
						
//						System.out.println(parametro + "="+valpar);

						/* recupero ipStart */
						if(parametro.compareTo("ipStart")==0){    
							ipStart = valpar;
							arrayParametri[0]= ipStart;
						}

						/* recupero ipEnd  */
						if(parametro.compareTo("ipEnd")==0){    
							ipEnd  = valpar;
							arrayParametri[1]= ipEnd;
						}

						/* recupero mask  */
						if(parametro.compareTo("mask")==0){    
							mask  = valpar;
							arrayParametri[2]= mask;
						}
						/* recupero gateway  */
						if(parametro.compareTo("gateway")==0){    
							gateway  = valpar;
							arrayParametri[3]= gateway;
						}


					}
				}
			}catch (Exception ex){
				System.err.println("Errore file di configurazione");
			}

		}

//		System.out.println(ipStart + " " + ipEnd + " " + mask + " " + gateway);

		return arrayParametri;
	}


	//	}
	
	/**
	 * Funzione che controlla se esiste il file di configurazione
	 */
	public void checkFile(){
		File f = new File("config.ini");
		if (f.exists())
			System.out.println("Il file esiste");
		else
			System.out.println("File di configurazione mancante");
	}
	
	
	/**
	 * Funzione che legge tutto il file di configurazione e lo salva riga per riga in
	 * un array di stringhe
	 * @return
	 */
	public String[] readFileConfig() {
		BufferedReader br = null;
		File f = new File("config.ini");
		String[] cnfg = new String[20]; 
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(f));
			int o = 0;

			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine.substring(0,1));
				String str = sCurrentLine.substring(0,1);

				if (str.compareTo("*")!=0){
					o ++;
					cnfg[o]=sCurrentLine;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return cnfg;
	}         

	/**
	 * Funzione che ritorna l'ip iniziale
	 * @return
	 */
	public String getIpStart(){
		return ipStart;
	}

	/**
	 * Funzione che ritorna l'ip finale
	 * @return
	 */
	public String getIpEnd(){
		return ipEnd;
	}

	/**
	 * Funzione che ritorna la maschera di sottorete
	 * @return
	 */
	public String getMask(){
		return mask;
	}

	/**
	 * Funzione che ritorna il gateway
	 * @return
	 */
	public String getGateway(){
		return gateway;
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
	private boolean checkIp(String ipAddress){
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
			
		}
		else
			System.out.println("Parametro "+(i+1)+" non consistente = "+listaParametri[i]);
	}
//  C fine blocco	
	return true;
	}
	
	else{
		System.out.println("numero puntini sbagliato = "+contaPuntiniCharAt);
		return false;
	}
	}
	
	else{
		System.out.println("numero di caratteri sbagliato");
	return false;
	}
	
	
	
	}

	
} 

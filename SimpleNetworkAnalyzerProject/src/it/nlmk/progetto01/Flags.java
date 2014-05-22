package it.nlmk.progetto01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Flags {

//	private static boolean flagPannelloComandi = false;
//	private boolean flagPannelloGestionGruppi = false;
//	private boolean flagClassificatore = false;
	
	public Flags(){
		Tools tools = new Tools();
		String nomeFile = "flags.txt";
		
		if(tools.esisteFile(nomeFile))
			try {
				tools.clearFile(nomeFile);
				tools.creaFile(nomeFile);
				String[] flags = new String[]{"flagPannelloComandi false", "flagPannelloGestionGruppi false", "flagClassificatore false"};
				tools.scriviFile(nomeFile, flags);			
			} catch (FileNotFoundException e) {
			System.out.println("problemi di creazionde del file flags.txt");
			}
		
	}
	
	public void aggiornaFlag(String flag, String value){
		
		Tools tools = new Tools();
		String nomeFile = "flags.txt";
		ArrayList<String> listaFlags = new ArrayList<>();
		String nomeFlag="";
		String valoreFlag ="";
		
		
		try {
			listaFlags= tools.leggiFileRitorna(nomeFile);
			String[] arrayFlags = tools.listToArray(listaFlags);
			String[][] tabellaFlags = new String[arrayFlags.length][2];
			
			for(int i= 0; i<arrayFlags.length; i++){
			StringTokenizer st = new StringTokenizer(arrayFlags[i]);
			
			nomeFlag = st.nextToken();
			valoreFlag = st.nextToken();
			
		
			tabellaFlags[i][0] = nomeFlag;
			
			tabellaFlags[i][1] = valoreFlag;

			}
			
			String[] arrayFlagsRet = new String[arrayFlags.length];
			
			for(int i= 0; i<arrayFlags.length; i++){
			
				if(tabellaFlags[i][0].equals(flag))
					tabellaFlags[i][1] = value;
				
				nomeFlag = tabellaFlags[i][0];
				valoreFlag = tabellaFlags[i][1];
				
				
				arrayFlags[i] = (nomeFlag + " " + valoreFlag );
			}
			
			tools.clearFile(nomeFile);
			tools.scriviFile(nomeFile, arrayFlags);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

		
		

		
//		String[] flags = new String[]{"flagPannelloComandi = "+flagPannelloComandi, flagPannelloGestionGruppi,flagClassificatore};
		
		
	}
	
//	public void setFlagPannelloComandi(boolean value){
//		this.flagPannelloComandi = value;
//	}
//	
//	public boolean getFlagPannelloComandi(){
//		return this.flagPannelloComandi;
//	}
//	
//	
//	public void setFlagPannelloGestioneGruppi(boolean value){
//		this.flagPannelloGestionGruppi = value;
//	}
	
	
	public boolean getStatoFlag(String nomeFlag) throws IOException{
		
		Tools tools = new Tools();
		String nomeFile = "flags.txt";
		ArrayList<String> listaFlags = new ArrayList<>();
					
	
			listaFlags= tools.leggiFileRitorna(nomeFile);
			String[] arrayFlags = tools.listToArray(listaFlags);
			String[][] tabellaFlags = new String[arrayFlags.length][2];
			
			for(int i= 0; i<arrayFlags.length; i++){
			StringTokenizer st = new StringTokenizer(arrayFlags[i]);
			
			tabellaFlags[i][0] = st.nextToken();
			tabellaFlags[i][1] = st.nextToken();
					
			}
			
			String[] arrayFlagsRet = new String[arrayFlags.length];
			
			boolean stato=false;
			for(int i= 0; i<arrayFlags.length; i++){
			
				if(tabellaFlags[i][0].equals(nomeFlag))
					if(tabellaFlags[i][1].equals("true"))
						stato = true;
					else
						stato = false;
				
			}
			
			return stato;
	
	
		
	
	}
	
	
	
	public static void main(String[] args) throws IOException{
		Flags flags = new Flags();
		Tools tools = new Tools();

		
		try {
			tools.leggiFile("flags.txt");
			 
		} catch (IOException e) {
		System.out.println("errore lettura");
		}
		

		flags.aggiornaFlag("flagPannelloComandi", "false");
		flags.aggiornaFlag("flagPannelloGestionGruppi", "false");
		flags.aggiornaFlag("flagClassificatore", "true");
		
		try {
			tools.leggiFile("flags.txt");
			 
		} catch (IOException e) {
		System.out.println("errore lettura");
		}
	
		System.out.println(flags.getStatoFlag("flagClassificatore"));
		System.out.println(flags.getStatoFlag("flagPannelloComandi"));
		
	}
}

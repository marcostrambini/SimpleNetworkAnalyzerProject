package it.nlmk.progetto01;

import java.io.IOException;
import java.util.ArrayList;

public class Config {


	
	private  String ipStart;
	private  String ipEnd;
	private  String mask;
	private  String gateway;
	private  String ipDb;
	private  String nomeDb;
	private  String userDb;
	private  String pwdDb;
	
	Tools tools = new Tools();
	
	
	private ArrayList<String> leggiConfigIni() throws IOException{
		String nomeFile = "config.ini";
		return tools.leggiFileRitorna(nomeFile);
	}
	
	private void interpretaConfig(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 
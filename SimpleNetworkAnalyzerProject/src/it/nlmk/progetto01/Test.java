package it.nlmk.progetto01;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

	Configurazione cnfg =  new Configurazione();
	cnfg.verificoParametriIp();
//	String ip1 = "192.168.5.1";
////	String ip2 = "192.168.5.10";
//	
	System.out.println("1:________________________________________________");
//	
//	System.out.println(cnfg.getValorePos(4, cnfg.getIpStart()));
//	System.out.println(cnfg.getValorePos(4, cnfg.getIpEnd()));
//
//	int differenza = 0;
//	differenza = (cnfg.getValorePos(4, cnfg.getIpEnd())) - (cnfg.getValorePos(4, cnfg.getIpStart()));
//	System.out.println("la differenza tra i due ip : "+differenza);
//	System.out.println("gli ip considerati sono "+ cnfg.getNumeroDiIpRange());
////	System.out.println(ip1 + " e " + ip2 + "  appartengono alla stessa rete: " + cnfg.checkAppartenenzaIpRete(ip1, ip2));
//		
	System.out.println("2:________________________________________________");
//	
//	
//	
//	if(cnfg.checkAppartenenzaIpRete(cnfg.getIpStart(), cnfg.getIpEnd())){
//	String subnet = "";
//	int ipHostStart = (cnfg.getValorePos(4, cnfg.getIpStart()));
//	int ipHostEnd = (cnfg.getValorePos(4, cnfg.getIpEnd()));
//	String[] listaIp = new String[cnfg.getNumeroDiIpRange()];
//	subnet = (cnfg.getValorePos(1, cnfg.getIpStart())+"."+cnfg.getValorePos(2, cnfg.getIpStart())+"."+cnfg.getValorePos(3, cnfg.getIpStart())+".");
//		for (int i=0; i<(differenza+1); i++){
//			
//			System.out.println(subnet + (ipHostStart+i));
//			listaIp[i] = (subnet + (ipHostStart+i));
//	}
//		System.out.println("3:________________________________________________");
//		System.out.println("Ip alla posizione 3 dell'array = "+listaIp[3-1]);
//		System.out.println("Ip alla posizione 10 dell'array = "+listaIp[10-1]);
////		System.out.println("Ip alla posizione 200 dell'array = "+listaIp[200-1]);
//	}

	
	System.out.println("3:________________________________________________");
	Tools pingatore = new Tools();
	String[] listaip = cnfg.getListaIp();

	int par = 0;
	int count = 0;
	int giro = 0;
	int time = 0;
	
	while(true){
	System.out.println("---------------------------");	
	System.out.println("Giro: "+ ++giro);	
	if (giro%2 == 0)
		time = 5000;
	else
		time = 2000;
	
	System.out.println("Timeoute = "+time);
	
	while (par < listaip.length){
//	System.out.println("Ping di "+listaip[par]+" result: " + pingatore.ping(listaip[par]));
	
	if(pingatore.ping(listaip[par], time)){
		System.out.println("Ping di "+listaip[par]+" result: " + pingatore.ping(listaip[par], time));
		count++; 
	} else {	}

	par++;
	}
	System.out.println("Ip alive: " + count);
	par =0;
	count =0;
	}

	}
	
	
	
	
}

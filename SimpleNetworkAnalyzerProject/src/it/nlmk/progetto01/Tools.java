package it.nlmk.progetto01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Tools {

	
	public boolean ping(String ipAddress) throws IOException{
		
	    InetAddress inet = InetAddress.getByName(ipAddress);
	    return inet.isReachable(3000);
	}
	
	
	public boolean ping(String ipAddress, int time) throws IOException{
		
	    InetAddress inet = InetAddress.getByName(ipAddress);
	    return inet.isReachable(time);
	}
	
	
}

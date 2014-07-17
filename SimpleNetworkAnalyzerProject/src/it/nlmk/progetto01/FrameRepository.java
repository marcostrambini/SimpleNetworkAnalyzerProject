package it.nlmk.progetto01;

import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * classe per la raccolta di oggetti Frame
 * @author marcostrambini
 *
 */
public class FrameRepository
{
    /**
     * ArrayList di Frame
     */
	private static ArrayList<JFrame> list = new ArrayList<JFrame>();

    /**
     * metodo che aggiunge un JFrame all'ArrayList
     * @param thread
     */
    public static void add(JFrame frame)
    {
    	list.add(frame);

    }
    
    public static void remove(JFrame frame)
    {
    	list.remove(frame);
    }

    /**
     * metodo che ritorna il numero di JFrame nell'ArrayList
     * @return
     */
    public static int Count()
    {
    	return list.size();
    }

    /**
     * metodo che chiude tutti i JFrame presenti nell'ArrayList
     */
    public static void closeAllFrame() {

    	for(int i=0; i<list.size();i++){
    		list.get(i).dispose();
    		
    	}

    }
    
    
//    /**
//     * metodo che ferma una specifica thread presente nell'ArrayList
//     * @param name = nome della Thread
//     */
//    public static void stopSpecificThread(String name) {
//
//    	for(int i=0; i<list.size();i++){
//    		if(list.get(i).getName().equals(name)){
//
//    			if(!Thread.interrupted()){
//    				list.get(i).interrupt();
//    				System.out.println("Interrotta Thread: "+list.get(i).getName()+" - ID: "+list.get(i).getId());
//
//    			}
//    		}
//    	}
//    }
    
        
    /**
     * metodo che stampa gli oggetti presenti nell'ArrayList
     */
    public static void toStringList(){
	   for(JFrame t:list)
		   System.out.println(t);
    }
}
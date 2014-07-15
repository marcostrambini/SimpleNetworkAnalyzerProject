package it.nlmk.progetto01;

import java.util.ArrayList;

/**
 * classe per la raccolta di oggetti ThreadPingIcon
 * @author marcostrambini
 *
 */
public class ThreadRepository
{
    /**
     * ArrayList di ThreadPingIcon
     */
	private static ArrayList<ThreadPingIcon> list = new ArrayList<ThreadPingIcon>();

    /**
     * metodo che aggiunge un ThreadPingIcon all'ArrayList
     * @param thread
     */
    public static void Pool(ThreadPingIcon thread)
    {
    	list.add(thread);

    }

    /**
     * metodo che ritorna il numero di ThreadPingIcon nell'ArrayList
     * @return
     */
    public static int Count()
    {
    	return list.size();
    }

    /**
     * metodo che ferma tutte le thread presenti nell'ArrayList
     */
    public static void stopAllThread() {

    	for(int i=0; i<list.size();i++){
    		
    		System.out.println(i+" ------------------------------------------------------------------------");
    		System.out.println("Thread da gestire: " +list.get(i).getName() + " - ID: "+list.get(i).getId());
    		//    		if(!Thread.interrupted()){
    		list.get(i).stopMe();
    		if(list.get(i).isInterrupted())
    			System.out.println("Interrotta Thread: "+list.get(i).getName()+" - ID: "+list.get(i).getId());
    		else
    			System.out.println("non sono riuscito a interrompere la thread: "+list.get(i).getName()+" - ID: "+list.get(i).getId());
    		//    		}
    	}

    }
    
    public static void stopAllThread2() {

    	for(int i=0; i<list.size();i++){
    		new ThreadStopper(list.get(i)).start();
      	}

    }
    
    /**
     * metodo che ferma una specifica thread presente nell'ArrayList
     * @param name = nome della Thread
     */
    public static void stopSpecificThread(String name) {

    	for(int i=0; i<list.size();i++){
    		if(list.get(i).getName().equals(name)){

    			if(!Thread.interrupted()){
    				list.get(i).stopMe();
    				System.out.println("Interrotta Thread: "+list.get(i).getName()+" - ID: "+list.get(i).getId());

    			}
    		}
    	}
    }
    
        
    /**
     * metodo che avvia tutte le thread presenti nell'ArrayList
     */
    public static synchronized void startAllThread() {

    	for(int i=0; i<list.size();i++){
    		list.get(i).start();

    	}
    }

    /**
     * metodo che stampa gli oggetti presenti nell'ArrayList
     */
    public static void toStringList(){
	   for(ThreadPingIcon t:list)
		   System.out.println(t);
    }
}
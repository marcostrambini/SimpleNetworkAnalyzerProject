package it.nlmk.progetto01;

public class Flags {

	private boolean flagPannelloComandi = false;
	private boolean flagPannelloGestionGruppi = false;
	
	
	public void setFlagPannelloComandi(boolean value){
		this.flagPannelloComandi = value;
	}
	
	public boolean getFlagPannelloComandi(){
		return this.flagPannelloComandi;
	}
	
	
	public void setFlagPannelloGestioneGruppi(boolean value){
		this.flagPannelloGestionGruppi = value;
	}
	
	public static void main(String[] args){
		Flags flags = new Flags();
		System.out.println(flags.getFlagPannelloComandi());
		flags.setFlagPannelloComandi(true);
		System.out.println(flags.getFlagPannelloComandi());
		flags.setFlagPannelloComandi(false);
		if(flags.getFlagPannelloComandi())
			System.out.println("valore vero");
		else
			System.out.println("valore falso");
	}
}

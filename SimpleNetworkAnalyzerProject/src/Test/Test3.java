package Test;

import java.io.IOException;

import it.nlmk.progetto01.FrameControls;
import it.nlmk.progetto01.Tools;

import javax.swing.JFrame;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools tools = new Tools();
		try {
			tools.leggiFile("classificazione.csv");
		} catch (IOException e) {
			System.out.println("problemi di lettura file");
		}

	}

}

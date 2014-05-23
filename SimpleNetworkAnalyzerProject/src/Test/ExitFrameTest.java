package Test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class ExitFrameTest extends JFrame {

public ExitFrameTest(){
	setSize(300, 300);
	setVisible(true);
//	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	this.addWindowListener(new WindowAdapter() {
		public void windowsClosing(){
			System.out.println("chiuso");
		}
		
	});
	
	
	
}

public static void main(String[] args){
	
	ExitFrameTest eft = new ExitFrameTest();
}


}

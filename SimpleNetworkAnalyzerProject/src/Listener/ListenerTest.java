package Listener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class ListenerTest {

	
	public ListenerTest(JPanel panel){
		panel.add(new JLabel("Prova listener"));
		panel.repaint();
		panel.setVisible(true);
		
		
		
	}
}

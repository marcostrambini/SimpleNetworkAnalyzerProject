package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.PageAttributes.OrientationRequestedType;
import java.awt.Scrollbar;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class JScrollPaneEsempio extends JFrame {

	JScrollBar sb = new JScrollBar();
	JScrollPane sp;
	
	public JScrollPaneEsempio(){
		
	
		JLabel[] arrayLabel = new JLabel[50];
		
		
		JPanel panel = new JPanel();
		panel.setSize(400, 1000);
		panel.setLayout(new GridLayout(50,1));
		for (int i=0; i<50; i++){
		panel.add(new JLabel("test "+i));
			arrayLabel[i] = new JLabel("test "+i);
		
		}
		sp = new JScrollPane(panel);
		sp.setSize(400, 400);
		this.add(sp, BorderLayout.CENTER);

		sb.setOrientation(JScrollBar.VERTICAL);
		sb.setMaximum(100);
		sb.setMinimum(1);
		sb.setUnitIncrement(10);
		sb.setValue(30);
		//		this.add(sb, BorderLayout.EAST);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
	
	
public static void main(String[] args){
	JScrollPaneEsempio a = new JScrollPaneEsempio();
}
	
}
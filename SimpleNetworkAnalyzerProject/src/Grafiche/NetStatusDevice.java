package Grafiche;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NetStatusDevice extends JFrame{

	
	public NetStatusDevice(){
		
	setLayout(new GridLayout(1,2));
	setSize(400, 100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
	JPanel panelSX =  new JPanel();
	JPanel panelDX =  new JPanel();
	ImageIcon icon = new ImageIcon("freccia_rossa_down.png");
	JLabel label = new JLabel();
	label.setIcon(icon);
	panelDX.add(label);
	
	panelSX.setSize(300, 100);
	panelDX.setSize(100, 100);
	
	panelSX.setBackground(Color.RED);
	
	add(panelSX);
	add(panelDX);

		
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NetStatusDevice nsd = new NetStatusDevice();
	}

}

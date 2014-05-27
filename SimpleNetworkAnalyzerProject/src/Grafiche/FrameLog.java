package Grafiche;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameLog extends JFrame {

	private static JLabel label = new JLabel();
	private static JTextArea textArea = new JTextArea();
	InterfacciaUtente iu;
	
	public FrameLog(InterfacciaUtente iu){
		this.iu = iu;
		setSize(300, 300);
		setLocation(iu.getPositionX(), iu.getPositionY()+iu.getSize().height);
		add(label);
		add(new JScrollPane(textArea));
		
		setVisible(true);
		
		
	}
	
	
	public static void setLabel(String value){
		label.setText(value);
		
	}
	
	public static void setTextArea(String value){
		String temp = textArea.getText();
		textArea.setText(temp + "\n" + value);
	}
	
	public static void setTextArea(ArrayList<String> value){
		for(int i=0; i<value.size(); i++){
		String temp = textArea.getText();
		textArea.setText(temp + "\n" + value.get(i));
		}
	}
	
}

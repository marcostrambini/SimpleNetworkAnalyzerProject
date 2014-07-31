package Grafiche;

import java.awt.Color;
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
		
		setTitle("Frame Log");
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
		textArea.setText(value + "\n" + temp);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.YELLOW);
	}
	
	public static void setTextArea(ArrayList<String> value){
		for(int i=0; i<value.size(); i++){
		String temp = textArea.getText();
		textArea.setText(value.get(i) + "\n" + temp  );
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.YELLOW);
		}
	}
	
}

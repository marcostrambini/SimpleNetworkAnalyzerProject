package Test;

import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;

public class MyFrame extends JFrame
{
	public MyFrame()
	{
		super("MouseTest");
		this.addMouseListener(new MouseSpy());
		this.addWindowListener((WindowListener) new ExitFrameTest());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	MyFrame frame = new MyFrame();	
	}	
}
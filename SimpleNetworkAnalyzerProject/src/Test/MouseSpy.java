package Test;

import java.awt.event.*;
import javax.swing.*;

public class MouseSpy implements MouseListener
{
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click su ("+e.getX()+","+e.getY()+")");
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("Premuto su ("+e.getX()+","+e.getY()+")");
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("Rilasciato su ("+e.getX()+","+e.getY()+")");
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("sono su ("+e.getX()+","+e.getY()+")");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("sono fuori dal frame");
	}
}


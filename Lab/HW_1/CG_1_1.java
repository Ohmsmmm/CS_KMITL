// 61050150, 61050193

import java.awt.*;
import javax.swing.*;

class CG_1_1 extends JPanel {
	public static void main(String[] args) {
		CG_1_1 m = new CG_1_1();
		JFrame f = new JFrame();
		f.add(m);
		f.setTitle("CG_1_1");
		f.setSize(20, 20);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

	public void paintComponent(Graphics g) {
		int diameter = 18;
		int radius = diameter/2;
		 // Outer upper circle
		 g.setColor(Color.BLACK);
		 g.fillArc(0, 0, diameter, diameter, 0, 180);
		 
		 // Outer lower circle        
		 g.setColor(Color.WHITE);
		 g.fillArc(0, 0, diameter, diameter, 0, -180);
		 
		 // Inner upper circle (white) - left side
		 g.setColor(Color.WHITE);
		 g.fillArc(0, diameter/4+1, radius, radius, 0, 180);
		 
		 // Inner lower circle (black) - right side
		 g.setColor(Color.BLACK);
		 g.fillArc(radius, diameter/4, radius, radius, 0, -180);
		 
		 // Inner left circle (black on white)
		 g.setColor(Color.BLACK);
		 g.fillArc(diameter/4-radius/8, diameter/2-radius/8, radius/4, radius/4, 0, 360);
		 
		 // Inner right circle (white on black)
		 g.setColor(Color.WHITE);
		 g.fillArc(diameter/2+(radius/8)*3, diameter/2-radius/8, radius/4, radius/4, 0, 360);
	}
}

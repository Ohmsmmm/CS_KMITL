import java.awt.*; 
import javax.swing.*;

class Assignment3_61050150 extends JPanel implements Runnable{
	double circleMove = 0;
	double circleMove2 = 220;
	double circleMove3 = 20;
	double circleMove4 = 230;
	double circleMove5 = 10;
	double Move = 100;
	double Move2 = 100;
	double Move3 = 90;
	double Move4 = 110;
	double Move5 = 100;
	public static void main(String[] args) {
		Assignment3_61050150 m = new Assignment3_61050150();
		JFrame f=new JFrame();
		f.add(m);
		f.setTitle("Assignment3_61050150");
		f.setSize(600,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);		
		(new Thread(m)).start();
	}
	public void paintComponent(Graphics g)	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(randomColor());
		g2.fillRect(0, 0, 600, 600);
		//1
		g2.setColor(Color.BLACK);
		g2.translate(circleMove, 0);
		String c = "OverFlow!!";
		g2.setFont(new Font(c, Font.PLAIN, 75));
		g2.drawString(String.valueOf(c), 0, 100);
		g2.translate(-circleMove, 0);
		//2
		g2.setColor(Color.BLACK);
		g2.translate(circleMove2, 0);
		String c2 = "OverFlow!!";
		g2.setFont(new Font(c2, Font.PLAIN, 75));
		g2.drawString(String.valueOf(c2), 0, 200);
		g2.translate(-circleMove2, 0);
		//3
		g2.setColor(Color.BLACK);
		g2.translate(circleMove3, 0);
		String c3 = "OverFlow!!";
		g2.setFont(new Font(c, Font.PLAIN, 75));
		g2.drawString(String.valueOf(c), 0, 300);
		g2.translate(-circleMove3, 0);
		//4
		g2.setColor(Color.BLACK);
		g2.translate(circleMove4, 0);
		String c4 = "OverFlow!!";
		g2.setFont(new Font(c2, Font.PLAIN, 75));
		g2.drawString(String.valueOf(c2), 0, 400);
		g2.translate(-circleMove4, 0);
		//5
		g2.setColor(Color.BLACK);
		g2.translate(circleMove5, 0);
		String c5 = "OverFlow!!";
		g2.setFont(new Font(c2, Font.PLAIN, 75));
		g2.drawString(String.valueOf(c2), 0, 500);
		g2.translate(-circleMove5, 0);
		
		}
	
	public void run()	{		
		double lastTime = System.currentTimeMillis();
		double currentTime, elapsedTime;
		double startTime = System.currentTimeMillis();
		while (true){
			currentTime = System.currentTimeMillis();
			elapsedTime = currentTime - lastTime;
			//1
			if (circleMove < 0 || circleMove > 230) {
				Move = (-Move);
			}
			circleMove += Move * elapsedTime / 1000.0;
			//2
			if (circleMove2 < 0 || circleMove2 > 230) {
				Move2 = (-Move2);
			}
			circleMove2 += Move2 * elapsedTime / 1000.0;
			//3
			if (circleMove3 < 0 || circleMove3 > 230) {
				Move3 = (-Move3);
			}
			circleMove3 += Move3 * elapsedTime / 1000.0;
			//4
			if (circleMove4 < 0 || circleMove4 > 230) {
				Move4 = (-Move4);
			}
			circleMove4 += Move4 * elapsedTime / 1000.0;
			//5
			if (circleMove5 < 0 || circleMove5 > 230) {
				Move5 = (-Move5);
			}
			circleMove5 += Move5 * elapsedTime / 1000.0;
            
			repaint();
            lastTime = currentTime;
            
		    try	{
			    Thread.sleep(1000/60);
		    }
		    catch (InterruptedException e)	{
			    System.err.println(e);
		    }
        }
    }
    public Color randomColor(){
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        return(new Color(r, g, b));
    }
}
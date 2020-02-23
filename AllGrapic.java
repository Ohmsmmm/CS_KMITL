import javax.swing.JFrame;
import java.awt.*;
import java.awt.Graphics2D;
import javax.swing.*;

class AllGraphic extends JPanel implements Runnable{
    
    double circleMove=500;
	double cloudmove=-300;
    double submarine = 0;
    double wavemove=0, movewave = 20;
    double bubble=0;

    public static void main(String args[]){

        AllGraphic m = new AllGraphic();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();

        
    }//main

    public void run(){

        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;
        double startTime = System.currentTimeMillis();

                while (true){

                currentTime = System.currentTimeMillis();
                elapsedTime = currentTime - lastTime;

                //TODO: update logics
                if(circleMove>500 || circleMove<-60){circleMove=500;circleMove   -= 80.0 * elapsedTime / 1000.0;}
				circleMove   -= 80.0 * elapsedTime / 1000.0;
                
				submarine += 10.0 * elapsedTime / 1000.0;
                if(wavemove<-20 || wavemove>1)
				{	
				movewave = -movewave;
				}
				wavemove += movewave * elapsedTime / 1000.0;

				if(cloudmove<-300 || cloudmove>430){cloudmove=-300;cloudmove += 50.0 * elapsedTime / 1000.0;}
				cloudmove += 50.0 * elapsedTime / 1000.0;
                //Display
                
                if(bubble<-80){ 
                    bubble=0;
                    bubble  -= 20.0 * elapsedTime / 1000.0;
                    
                }
                    bubble  -= 20.0 * elapsedTime / 1000.0;
                


                repaint();
                lastTime = currentTime;

                //take a little nap: 60fps
                    try
                    {
                    Thread.sleep(1000/60);
                     }
                    catch (InterruptedException e)
                    {
                    System.err.println(e);
                    }
              }

    }

    public void paintComponent(Graphics g){
        for (int i = 0; i <= 600; i++) {
            for (int j = 0; j<= 600; j++) {
                if(j<=199)
                g.setColor(Color.decode("#94d0db"));
                else
                g.setColor(Color.decode("#5080a8"));
                g.fillRect(i, j, 1, 1);
            }
        }
			Graphics2D g2 = (Graphics2D) g; //Animation Part
			g2.translate(wavemove,0);
		  g.setColor(Color.decode("#5080a8")); //wave
            g.fillRect(44, 196, 8, 4);
            g.fillRect(96, 196, 12, 4);
            g.fillRect(148, 196, 12, 4);
            g.fillRect(204, 196, 8, 4);
            g.fillRect(256, 196, 12, 4);
            g.fillRect(308, 196, 12, 4);
            g.fillRect(364, 196, 8, 4);
            g.fillRect(416, 196, 12, 4);
            g.fillRect(468, 196, 12, 4);
            g.fillRect(524, 196, 8, 4);
            g.fillRect(576, 196, 12, 4);
    
            g.setColor(Color.decode("#77abc0"));	//wave
            g.fillRect(200, 196, 4, 4);  
            g.fillRect(320, 196, 4, 4);  
            g.fillRect(360, 196, 4, 4);  
            g.fillRect(520, 196, 4, 4);
            g.fillRect(480, 196, 4, 4);

			g.setColor(Color.decode("#6398b9")); //wave
            g.fillRect(40, 196, 4, 4);   
            g.fillRect(52, 196, 4, 4);  
            g.fillRect(212, 196, 4, 4); 
            g.fillRect(372, 196, 4, 4);  
            g.fillRect(532, 196, 4, 4);  
			g2.translate(-wavemove,0);

        g2.setColor(Color.decode("#d9e3dc"));  //Cloud
		g2.translate(cloudmove, 0);
        g2.fillRect(132, 28, 28, 4); g2.fillRect(96, 80, 156, 16);  
        g2.fillRect(124, 32, 44, 4); g2.fillRect(104, 96, 144, 4);    
        g2.fillRect(120, 36, 52, 4); g2.fillRect(100, 76, 148, 4);   
        g2.fillRect(116, 40, 60, 4); g2.fillRect(428, 108, 20, 8);    
        g2.fillRect(116, 44, 88, 4); g2.fillRect(424, 116, 72, 8);  
        g2.fillRect(112, 48, 100, 4); g2.fillRect(472, 108, 20, 4); 
        g2.fillRect(112, 52, 104, 4); g2.fillRect(468, 112, 28, 4);  
        g2.fillRect(112, 56, 108, 4); g2.fillRect(408, 124, 88, 8); 
        g2.fillRect(112, 60, 112, 8); g2.fillRect(408, 132, 84, 4); 
        g2.fillRect(112, 68, 116, 4); g2.fillRect(416, 120, 4, 4);  
        g2.fillRect(104, 72, 140, 4);    
        g2.translate(-cloudmove, 0);

        g2.setColor(Color.decode("#a4807f"));//เรือสีม่าวง
        g2.translate(-submarine, 0);
        //g2.translate(submarine, 0);

        g2.fillRect(468, 232, 4, 4); g2.fillRect(428, 408, 4, 4);
        g2.fillRect(472, 244, 4, 4); g2.fillRect(472, 408, 4, 4);
        g2.fillRect(416, 404, 4, 4); g2.fillRect(532, 348, 4, 4);
        g2.fillRect(560, 336, 4, 4); g2.fillRect(560, 348, 4, 4); g2.fillRect(537, 304, 4, 4);
        g2.fillRect(560, 312, 4, 8); g2.fillRect(552, 308, 4, 12);g2.fillRect(552, 332, 4, 16);
        g2.fillRect(408, 357, 4, 4); g2.fillRect(464, 344, 4, 4);

		//===============brown===============

        g2.setColor(Color.decode("#77817d"));
        g2.fillRect(408, 292, 8, 4); g2.fillRect(408, 280, 4, 4); g2.fillRect(456, 224, 4, 4); g2.fillRect(456, 312, 4, 8);
        g2.fillRect(408, 268, 4, 4); g2.fillRect(408, 256, 4, 4); g2.fillRect(464, 228, 4, 4); g2.fillRect(476, 309, 8, 4);
        g2.fillRect(416, 248, 4, 4); g2.fillRect(424, 232, 4, 4); g2.fillRect(484, 248, 4, 4);
        g2.fillRect(428, 228, 4, 4); g2.fillRect(436, 224, 4, 4); g2.fillRect(492, 252, 4, 4);
        g2.fillRect(504, 260, 4, 4); g2.fillRect(509, 264, 4, 4); g2.fillRect(512, 268, 4, 4);
        g2.fillRect(516, 272, 4, 4); g2.fillRect(524, 284, 4, 4); g2.fillRect(528, 292, 4, 4);
        g2.fillRect(552, 304, 4, 4); g2.fillRect(560, 300, 4, 4); g2.fillRect(572, 320, 4, 4);
        g2.fillRect(560, 332, 4, 4); g2.fillRect(564, 352, 4, 4); g2.fillRect(536, 348, 16, 4);
        g2.fillRect(424, 408, 4, 4); g2.fillRect(444, 412, 16, 4);g2.fillRect(476, 408, 4, 4);
        g2.fillRect(484, 404, 4, 4); g2.fillRect(492, 400, 4, 4); g2.fillRect(500, 396, 4, 4);
        g2.fillRect(504, 392, 4, 4); g2.fillRect(508, 388, 4, 4); g2.fillRect(512, 384, 4, 4);
        g2.fillRect(516, 380, 4, 4); g2.fillRect(520, 376, 4, 4); g2.fillRect(524, 368, 4, 4);
        g2.fillRect(528, 360, 4, 4); g2.fillRect(532, 352, 4, 4); g2.fillRect(408, 304, 4, 4);
        g2.fillRect(412, 320, 4, 4); g2.fillRect(412, 328, 4, 4); g2.fillRect(412, 340, 4, 4);
        g2.fillRect(408, 368, 4, 4); g2.fillRect(408, 380, 4, 4); g2.fillRect(408, 392, 4, 4);
        g2.fillRect(452, 332, 4, 4); g2.fillRect(476, 344, 4, 4); g2.fillRect(488, 316, 4, 4);
        g2.fillRect(468, 308, 4, 4); g2.fillRect(480, 340, 8, 4); g2.fillRect(488, 324, 4, 8);
		g2.setColor(Color.decode("#7b5b64"));
        g2.fillRect(412, 280, 4, 4); g2.fillRect(412, 268, 4, 4); g2.fillRect(412, 344, 4, 4); 
        g2.fillRect(412, 256, 4, 4); g2.fillRect(412, 304, 4, 4); g2.fillRect(412, 356, 4, 4);
        g2.fillRect(412, 316, 4, 4); g2.fillRect(412, 332, 4, 4); g2.fillRect(412, 368, 4, 4);
        g2.fillRect(412, 380, 4, 4); g2.fillRect(412, 392, 4, 4); g2.fillRect(464, 309, 4, 4);
        g2.fillRect(484, 312, 4, 4); g2.fillRect(488, 320, 4, 4); g2.fillRect(456, 336, 4, 4);
        g2.fillRect(460, 340, 4, 4); g2.fillRect(488, 332, 4, 4); g2.fillRect(468, 345, 8, 4);
        g2.fillRect(452, 320, 4, 12);
        
        g2.setColor(Color.decode("#a1ccc1"));	//blue grass
         g2.fillRect(364, 288, 4, 4);  g2.fillRect(480, 316, 8, 4);
         g2.fillRect(368, 284, 4, 4); g2.fillRect(472, 328, 4, 8);
          g2.fillRect(376, 276, 32, 8);  g2.fillRect(468, 332, 4, 8);
        g2.fillRect(381, 284, 28, 4); g2.fillRect(460, 308, 4, 4);
         g2.fillRect(360, 296, 4, 4);  g2.fillRect(396, 268, 12, 8); g2.fillRect(460, 336, 4, 4);
         g2.fillRect(368, 288, 40, 12);  g2.fillRect(392, 264, 8, 4); g2.fillRect(464, 340, 4, 4);
        g2.fillRect(400, 260, 8, 4);  g2.fillRect(392, 272, 4, 4);  g2.fillRect(404, 264, 4, 4);  g2.fillRect(476, 340, 4, 4);
        g2.fillRect(384, 268, 4, 4);  g2.fillRect(380, 272, 4, 4); g2.fillRect(436, 188, 4, 4);  g2.fillRect(480, 336, 4, 4);
        g2.fillRect(440, 176, 4, 4); g2.fillRect(456, 184, 4, 8); g2.fillRect(452, 160, 4, 8);   g2.fillRect(482, 332, 4, 4);
        g2.fillRect(456, 320, 8, 16); g2.fillRect(460, 312, 16, 8); g2.fillRect(464, 320, 8, 8);  g2.fillRect(464, 328, 4, 4);
        g2.fillRect(472, 320, 4, 4); g2.fillRect(476, 324, 4, 4);  g2.fillRect(480, 320, 4, 4); g2.fillRect(476, 312, 4, 4);
        g2.fillRect(368, 300, 40, 60); g2.fillRect(372, 360, 36, 8); g2.fillRect(376, 368, 32, 4);  g2.fillRect(380, 372, 28, 4);
        g2.fillRect(384, 376, 24, 4); g2.fillRect(388, 380, 20, 4); g2.fillRect(396, 384, 12, 4); g2.fillRect(404, 388, 4, 8);
        g2.fillRect(416, 376, 4, 8); g2.fillRect(416, 396, 4, 4); g2.fillRect(408, 400, 4, 4);  g2.fillRect(400, 392, 4, 4);
        g2.fillRect(388, 388, 8, 4);  g2.fillRect(384, 384, 4, 4); g2.fillRect(380, 380, 4, 4);  g2.fillRect(368, 372, 4, 4);
        g2.fillRect(364, 364, 4, 4);  g2.fillRect(360, 360, 4, 4); g2.fillRect(356, 348, 4, 4); g2.fillRect(352, 320, 4, 16);
        g2.fillRect(356, 304, 4, 4);  g2.fillRect(364, 304, 4, 48);  g2.fillRect(360, 320, 4, 16); g2.fillRect(408, 344, 4, 4);
        g2.fillRect(408, 332, 4, 4);  g2.fillRect(408, 316, 4, 4);  g2.fillRect(412, 308, 4, 4);  g2.fillRect(557, 328, 16, 4);

        g2.setColor(Color.decode("#87c0be")); //blue shadow grass
          g2.fillRect(360, 292, 8, 4);  g2.fillRect(480, 312, 4, 4); g2.fillRect(472, 336, 8, 4);
          g2.fillRect(372, 276, 4, 12);  g2.fillRect(452, 340, 4, 4); g2.fillRect(476, 328, 8, 8);
          g2.fillRect(388, 264, 4, 12); g2.fillRect(468, 328, 4, 4); g2.fillRect(484, 320, 4, 12);
         g2.fillRect(384, 272, 4, 4); g2.fillRect(472, 324, 4, 4); g2.fillRect(480, 324, 4, 4);
         g2.fillRect(392, 268, 4, 4); g2.fillRect(476, 316, 4, 8);  g2.fillRect(576, 324, 4, 4);
        g2.fillRect(572, 196, 4, 4);  g2.fillRect(396, 260, 4, 4); g2.fillRect(464, 332, 4, 8);  g2.fillRect(572, 328, 4, 4);
        g2.fillRect(364, 296, 4, 4); g2.fillRect(400, 264, 4, 4); g2.fillRect(468, 340, 8, 4);    g2.fillRect(356, 308, 8, 12);
        g2.fillRect(360, 300, 8, 4);   g2.fillRect(360, 304, 4, 4);  g2.fillRect(352, 316, 4, 4);  g2.fillRect(356, 320, 4, 16);
        g2.fillRect(356, 336, 8, 12);  g2.fillRect(360, 352, 8, 8);  g2.fillRect(352, 336, 4, 4); g2.fillRect(360, 348, 4, 4);
        g2.fillRect(356, 352, 4, 4);   g2.fillRect(364, 360, 8, 4);   g2.fillRect(368, 365, 4, 8);  g2.fillRect(372, 372, 8, 4);
        g2.fillRect(376, 376, 8, 4);  g2.fillRect(388, 384, 8, 4);  g2.fillRect(396, 388, 8, 4);    g2.fillRect(372, 368, 4, 4);
        g2.fillRect(384, 380, 4, 4);

        g2.setColor(Color.decode("#d9e3dc"));  //white part of submarine
        g2.fillRect(408, 260, 12, 8);  g2.fillRect(412, 312, 4, 4);
        g2.fillRect(412, 252, 8, 4);   g2.fillRect(408, 320, 4, 12);
        g2.fillRect(416, 256, 4, 4);   g2.fillRect(412, 324, 4, 4);
        g2.fillRect(416, 268, 4, 4);   g2.fillRect(408, 336, 4, 8);
        g2.fillRect(408, 272, 12, 8);  g2.fillRect(412, 336, 4, 4);
        g2.fillRect(408, 284, 12, 8);  g2.fillRect(408, 348, 8, 8);
        g2.fillRect(416, 280, 4, 4);   g2.fillRect(408, 360, 8, 8);
        g2.fillRect(416, 292, 4, 4);   g2.fillRect(408, 372, 8, 8);
        g2.fillRect(408, 296, 12, 8);  g2.fillRect(408, 384, 8, 8);
         g2.fillRect(416, 304, 4, 72); g2.fillRect(408, 396, 8, 4);
        g2.fillRect(376, 284, 4, 4);   g2.fillRect(416, 384, 4, 12); g2.fillRect(416, 292, 4, 4);
        g2.fillRect(464, 164, 4, 20);  g2.fillRect(468, 168, 4, 8);  g2.fillRect(408, 308, 4, 8);  g2.fillRect(412, 400, 4, 4);
        g2.fillRect(412, 400, 4, 4);   g2.fillRect(556, 320, 12 ,8); g2.fillRect(568, 324, 8, 4);  g2.fillRect(448, 320, 4, 16); 
        g2.fillRect(460, 304, 4, 4);   g2.fillRect(492, 316, 4, 20); g2.fillRect(488, 336, 4, 8);  g2.fillRect(468, 348, 8, 4);
        g2.fillRect(452, 312, 4, 8);   g2.fillRect(456, 308, 4, 4);  g2.fillRect(480, 344, 4, 4);  g2.fillRect(460, 344, 4, 4);
        g2.fillRect(456, 340, 4, 4);   g2.fillRect(452, 336, 4, 4);  g2.fillRect(484, 308, 4, 4);  g2.fillRect(488, 312, 4, 4);
        g2.fillRect(464, 304, 20, 4);
		
		g2.setColor(new Color (69,122,97));
		g2.fillRect(570, 324, 20, 4);
		
		for (int i=0 ;i<submarine ;i++ )
		{
			g2.setColor(new Color(0,0,255));
			g2.fillRect(590,310,10+i,30);
			g2.setColor(new Color(255,255,255));
			g2.fillRect(590,300,10+i,10);
			g2.fillRect(590,340,10+i,10);
			g2.setColor(new Color(255,0,0));
			g2.fillRect(590,290,10+i,10);
			g2.fillRect(590,350,10+i,10);
		}

		g2.setColor(Color.decode("#5484ac"));
        g2.fillRect(500, 200, 4, 4);  g2.fillRect(552, 200, 8, 4); g2.fillRect(340, 200, 4, 4);
        g2.fillRect(536, 200, 4, 4);  g2.fillRect(392, 200, 8, 4); g2.fillRect(284, 200, 8, 4);
        g2.fillRect(232, 200, 4, 4);  g2.fillRect(196, 200, 4, 4); g2.fillRect(180, 200, 4, 4);
        g2.fillRect(124, 200, 8, 4);  g2.fillRect(72, 200, 4, 4); g2.fillRect(56, 200, 4, 4);
		g2.fillRect(20, 200, 4, 4);
		
		g.setColor(Color.decode("#7b5b64"));
        g.fillRect(412, 280, 4, 4); g.fillRect(412, 268, 4, 4); g.fillRect(412, 344, 4, 4); 
        g.fillRect(412, 256, 4, 4); g.fillRect(412, 304, 4, 4); g.fillRect(412, 356, 4, 4);
        g.fillRect(412, 316, 4, 4); g.fillRect(412, 332, 4, 4); g.fillRect(412, 368, 4, 4);
        g.fillRect(412, 380, 4, 4); g.fillRect(412, 392, 4, 4); g.fillRect(464, 309, 4, 4);
        g.fillRect(484, 312, 4, 4); g.fillRect(488, 320, 4, 4); g.fillRect(456, 336, 4, 4);
        g.fillRect(460, 340, 4, 4); g.fillRect(488, 332, 4, 4); g.fillRect(468, 345, 8, 4);
        g.fillRect(452, 320, 4, 12);



			//=================ตัวเรือ====================

            g2.setColor(Color.decode("#77abc0")); 
            g2.fillRect(474,310,1,1);
            
			g2.setColor(Color.decode("#d9ae4a")); 
			g2.fillRect(420 ,264,88, 36); g2.fillRect(420, 252, 72, 12); g2.fillRect(420, 300, 24,104);  g2.fillRect(456, 348, 8, 56); 
			g2.fillRect(424, 240, 48, 12); g2.fillRect(428, 232, 40, 8); g2.fillRect(444, 300,20, 4);    g2.fillRect(464, 352, 24, 52);
			g2.fillRect(444, 228, 20, 4); g2.fillRect(436, 228, 4, 4);   g2.fillRect(444, 304, 16, 4);   g2.fillRect(468, 408, 4, 4);
			g2.fillRect(468, 236, 4, 4); g2.fillRect(472, 248, 8, 4);    g2.fillRect(448, 308, 4, 8);    g2.fillRect(480, 404, 4, 4);
			g2.fillRect(492, 256, 4, 8); g2.fillRect(500, 260, 4, 4);    g2.fillRect(444, 312, 4, 92);   g2.fillRect(488, 344, 4, 56);
			g2.fillRect(508, 292, 20, 8); g2.fillRect(508, 284, 16, 8);  g2.fillRect(428, 404, 48, 4);   g2.fillRect(492, 340, 8, 56);
			g2.fillRect(508, 276, 12, 8); g2.fillRect(508, 268, 4, 8);   g2.fillRect(448, 336, 4, 68);   g2.fillRect(496, 396, 4, 4);
			g2.fillRect(512, 272, 4, 4); g2.fillRect(504, 264, 4, 8);    g2.fillRect(452, 344, 4, 60);   g2.fillRect(480, 348, 8, 4);
			g2.fillRect(500, 300, 4, 92); g2.fillRect(504, 300, 4, 88);  g2.fillRect(508, 300, 4, 84);   g2.fillRect(512, 300, 4, 80);
			g2.fillRect(516, 300, 8, 76); g2.fillRect(524, 300, 4, 68);  g2.fillRect(528, 300, 4, 60);   g2.fillRect(532, 304, 4, 44);
			g2.fillRect(536, 308, 16, 40); g2.fillRect(540, 304, 12, 4); g2.fillRect(476, 300, 24, 4);   g2.fillRect(488, 304, 12, 4);
			g2.fillRect(492, 308, 8, 8 );g2.fillRect(496, 316, 4, 24);
	 
			g2.setColor(Color.decode("#dcbf74"));
			g2.fillRect(496, 256, 4, 8); g2.fillRect(520, 280, 4, 4); g2.fillRect(420, 248, 4, 4); g2.fillRect(488, 400, 4, 4);
			g2.fillRect(528, 296, 4, 4); g2.fillRect(480, 248, 4, 4); g2.fillRect(456, 164, 4, 4); g2.fillRect(492, 396, 4, 4);
			g2.fillRect(524, 288, 4, 4); g2.fillRect(440, 228, 4, 4); g2.fillRect(444, 308, 4, 4); g2.fillRect(500, 392, 4, 4);
			g2.fillRect(432, 228, 4, 4); g2.fillRect(424, 236, 4, 4); g2.fillRect(452, 308, 4, 4); g2.fillRect(504, 388, 4, 4);
			g2.fillRect(448, 316, 4, 4); g2.fillRect(464, 308, 12, 4); g2.fillRect(484, 304, 4, 4); g2.fillRect(508, 384, 4, 4);
			g2.fillRect(488, 308, 4, 4); g2.fillRect(456, 344, 4, 4); g2.fillRect(464, 348, 4, 4); g2.fillRect(512, 380, 4, 4);
			g2.fillRect(476, 348, 4, 4); g2.fillRect(484, 344, 4, 4); g2.fillRect(492, 336, 4, 4); g2.fillRect(516, 376, 4, 4);
			g2.fillRect(552, 320, 4, 12);g2.fillRect(568, 320, 4, 4); g2.fillRect(416, 400, 4, 4);  g2.fillRect(464, 300, 12, 4);
			g2.fillRect(420, 404, 8, 4); g2.fillRect(432, 408, 36, 4); g2.fillRect(476, 404, 4, 4);
	
	
		
			g2.setColor(Color.decode("#f7645a")); //red
			g2.fillRect(440, 180, 16, 48);   g2.fillRect(560, 304, 12, 8); g2.fillRect(560, 340, 4, 8);
			g2.fillRect(444, 172, 20, 8);    g2.fillRect(564, 300, 8, 4);
			g2.fillRect(452, 168, 12, 4);    g2.fillRect(564, 312, 8, 8);
            g2.fillRect(456, 180, 4, 4);     g2.fillRect(564, 332, 8, 20);

            g2.translate(submarine, 0);

			g2.translate(circleMove,0);
			g2.setColor(Color.decode("#3c6f8f"));
				g.fillRect(0, 327, 25,4); //fish//
                g.fillRect(1, 331, 17,1);
				g.fillRect(3, 332, 14,1);
                g.fillRect(6, 333, 8,1);
                g.fillRect(23, 331, 2,1);
                g.fillRect(22, 325, 3,2);
                g.fillRect(20, 326, 2,1);
                g.fillRect(1, 326, 19,1);
                g.fillRect(3, 325, 15,1);
                g.fillRect(6, 324, 10,1);
                //g.fillRect(7, 339, 2,9);
				//g.fillRect(6, 340, 1,7);
                //g.fillRect(0, 341, 6,5);
                g.fillRect(0, 340, 1,7);
                g.fillRect(6, 351, 15,7);
                g.fillRect(6, 358, 14,1);
                g.fillRect(8, 359, 9,1);
                g.fillRect(1, 354, 5,2);
                g.fillRect(2, 356, 4,1);
                g.fillRect(4, 357, 2,1);
                g.fillRect(2, 353, 4,1);
                g.fillRect(4, 352, 2,1);
                g.fillRect(8, 350, 12,1);
                g.fillRect(21, 352, 1,6);
                g.fillRect(22, 353, 1,4);
                g.fillRect(23, 352, 4,6);
                g.fillRect(27, 351, 1,8);
                g.fillRect(15, 367, 20,2);
                g.fillRect(16, 369, 19,1);
                g.fillRect(17, 370, 12,1);
                g.fillRect(20, 371, 8,1);
                g.fillRect(16, 366, 19,1);
                g.fillRect(18, 365, 11,1);
                g.fillRect(20, 364, 8,1);
                g.fillRect(33, 365, 2,6);
                for(int i=0,j=0;i<61;i = i+20,j=j+10)
                {	g.fillRect(31+i, 320+j, 21,1);
                    g.fillRect(32+i, 321+j, 20,1);
                    g.fillRect(32+i, 319+j, 20,1);
                    g.fillRect(50+i, 318+j, 2,5);
                    g.fillRect(35+i, 322+j, 12,1);
                    g.fillRect(36+i, 323+j, 10,1);
                    g.fillRect(33+i, 318+j, 15,1);
                    g.fillRect(35+i, 317+j, 11,1);
                    g.fillRect(37+i, 316+j, 7,1);
                }
                g.fillRect(18, 340, 33,2);
                g.fillRect(19, 342, 32,1);
                g.fillRect(19, 339, 32,1);
                g.fillRect(20, 343, 31,1);
                g.fillRect(20, 338, 31,1);
                g.fillRect(50, 336, 2,11);
                g.fillRect(48, 337, 2,8);
                g.fillRect(22, 337, 21,8);
                g.fillRect(25, 336, 16,10);
                g.fillRect(27, 335, 11,12);
    
                g.fillRect(118, 340, 33,2);
                g.fillRect(119, 342, 32,1);
                g.fillRect(119, 339, 32,1);
                g.fillRect(120, 343, 31,1);
                g.fillRect(120, 338, 31,1);
                g.fillRect(150, 336, 2,11);
                g.fillRect(148, 337, 2,8);
                g.fillRect(122, 337, 21,8);
                g.fillRect(125, 336, 16,10);
                g.fillRect(127, 335, 11,12);
    
                g.fillRect(59, 373, 26,2);
                g.fillRect(60, 372, 25,4);
                g.fillRect(81, 371, 4,6);
                g.fillRect(83, 370, 2,8);
                g.fillRect(62, 371, 17,6);
                g.fillRect(63, 370, 14,8);
                g.fillRect(66, 369, 8,10);
    
                g.fillRect(37, 358, 26,2);
                g.fillRect(38, 357, 25,4);
                g.fillRect(59, 356, 4,6);
                g.fillRect(61, 355, 2,8);
                g.fillRect(40, 356, 17,6);
                g.fillRect(41, 355, 14,8);
                g.fillRect(44, 354, 8,10);//
				 g2.translate(-circleMove, 0);
            
            
    
  
            g.setColor(new Color(44,92,117));  
                g.fillRect(0, 580, 28,20);
                g.fillRect(8, 568, 20,12);
                g.fillRect(4, 576, 4,4);
                g.fillRect(28, 572, 12,8);
                g.fillRect(28, 580, 8,8);
                g.fillRect(28, 588, 4,4);
                g.fillRect(88, 556, 40,44);
                g.fillRect(80, 580, 8,16);
                g.fillRect(84, 596, 4,4);
                g.fillRect(84, 548, 16,8);
                g.fillRect(100, 552, 16,4);
                g.fillRect(128, 560, 8,8);
                g.fillRect(128, 568, 4,8);
                g.fillRect(128, 576, 8,12);
                g.fillRect(128, 588, 12,8);
                g.fillRect(128, 596, 16,4);
                g.fillRect(196, 556, 4,20);
                g.fillRect(200, 560, 36,40);
                g.fillRect(168, 540,4,16);
                
            g.setColor(new Color(60,111,143));
                g.fillRect(0, 572,4,8);
                g.fillRect(4, 568,4,8);
                g.fillRect(8, 564,4,4);
                g.fillRect(28, 568,8,4);
                g.fillRect(36, 580,44,20);
                g.fillRect(80, 596,4,4);
                g.fillRect(28, 592,8,8);
                g.fillRect(32, 588,4,4);
                g.fillRect(56, 560,32,20);
                g.fillRect(44, 568,12,12);
                g.fillRect(40, 572,4,8);
                g.fillRect(52, 564,4,4);
                g.fillRect(64, 556,24,4);
                g.fillRect(76, 548,8,8);
                g.fillRect(72, 552,4,4);
                g.fillRect(132, 568,4,8);
                g.fillRect(136, 560,4,28);
                g.fillRect(140, 560,4,36);
                g.fillRect(144, 556,52,44);
                g.fillRect(196, 576,4,24);
                g.fillRect(200, 584,4,12);
                g.fillRect(184, 532,4,4);
                g.fillRect(164, 528,4,4);
                g.fillRect(172, 512,4,4);
                g.fillRect(120, 500,4,4);
                g.fillRect(60, 536, 4,4);
                g.fillRect(56, 540, 4,4);
                
                
            g.setColor(new Color(247,100,90)); //red
                g.fillRect(176, 572, 12,4);
                g.fillRect(172, 576, 4,4);
            
            g.setColor(new Color(123,91,100)); //brown
                g.fillRect(180, 576, 4,8);
                g.fillRect(188, 572, 4,4);
                g.fillRect(172, 572, 4,4);
                g.fillRect(164, 540, 4,16);
                g.fillRect(152, 536, 8,20);
                g.fillRect(148, 532, 4,24);
                g.fillRect(140, 532, 4,28);
                g.fillRect(132, 528, 8,28);
                g.fillRect(128, 548, 4,4);
                g.fillRect(136, 556, 4,4);
                g.fillRect(128, 556, 4,4);
                g.fillRect(80, 540, 4,4);
                g.fillRect(112, 528,4,4);
                g.fillRect(120, 504,4,4);
                
            g.setColor(new Color(119,129,125));
                g.fillRect(176, 568, 4,4);
                g.fillRect(144, 556,4,4);
                g.fillRect(160, 552,4,4);
                g.fillRect(144, 544,4,4);
                g.fillRect(116, 552,4,4);
                g.fillRect(100, 548,8,4);
                g.fillRect(80, 544,12,4);
                g.fillRect(84, 536,16,4);
                g.fillRect(96, 540,4,4);
                g.fillRect(64, 548,4,8);
                g.fillRect(68, 552,4,4);
                g.fillRect(160, 528,4,4);
                g.fillRect(140, 516,8,4);
                g.fillRect(124, 508,4,4);
                g.fillRect(112, 496,4,4);
                g.fillRect(108, 500,4,4);
                g.fillRect(104, 496,4,4);
                g.fillRect(104, 504,4,4);
                g.fillRect(96, 508,4,4);
                g.fillRect(88, 512,4,4);
                g.fillRect(64, 532,4,4);
            
            g.setColor(new Color(164,128,127));
                g.fillRect(180, 564, 4,8);
                g.fillRect(176, 576, 4,4);
                g.fillRect(168, 568, 8,4);
                g.fillRect(160, 540, 4,12);
                g.fillRect(144, 548, 4,8);
                g.fillRect(144, 532, 4,12);
                g.fillRect(132, 556, 4,4);
                g.fillRect(120, 552, 12,4);
                g.fillRect(120, 528, 12,20);
                g.fillRect(108, 548, 20,4);
                g.fillRect(116, 532, 4,16);
                g.fillRect(100, 536, 16,12);
                g.fillRect(92, 544, 8,4);
                g.fillRect(84, 540, 12,4);
                g.fillRect(108, 528, 4,4);
                g.fillRect(80, 532, 28,4);
                g.fillRect(80, 536, 4,4);
                g.fillRect(68, 548, 8,4);
                g.fillRect(64, 536, 16,12);
                g.fillRect(76, 520, 4,4);
                g.fillRect(100, 508, 8,4);
                g.fillRect(108, 504, 4,4);
                g.fillRect(116, 496, 4,4);
                g.fillRect(124, 504, 4,4);
    
            g.setColor(new Color(217,227,220));
                g.fillRect(104, 528, 4,4);
                g.fillRect(108, 532, 8,4);
                g.fillRect(116, 528, 4,4);
                
            g.setColor(new Color(217,174,74));
                g.fillRect(68, 532, 4,4);
                g.fillRect(84, 516, 52,12);
                g.fillRect(84, 528, 16,4);
                g.fillRect(80, 520, 4,12);
                g.fillRect(72, 528, 8,8);
                g.fillRect(76, 524, 4,4);
                g.fillRect(96, 512, 32,4);
                g.fillRect(108, 508, 4,4);
                g.fillRect(116, 508, 8,4);
                g.fillRect(116, 500, 4,8);
                g.fillRect(136, 520, 4,8);
                g.fillRect(140, 524, 4,8);
                g.fillRect(144, 528, 8,4);
                g.fillRect(152, 532, 8,4);
                g.fillRect(160, 536, 4,4);
                g.fillRect(152, 524, 4,4);
                
            g.setColor(new Color(220,191,116));
                g.fillRect(100, 528, 4,4);
                g.fillRect(112, 500, 4,12);
                g.fillRect(104, 500, 4,4);
                g.fillRect(92, 512, 4,4);
                g.fillRect(80, 516, 4,4);
                g.fillRect(72, 524, 4,4);
                g.fillRect(68, 528, 4,4);
                g.fillRect(124, 500, 4,4);
                g.fillRect(128, 512, 4,4);
                g.fillRect(136, 516, 4,4);
                g.fillRect(164, 536, 4,4);
                g.fillRect(160, 532, 4,4);
                g.fillRect(152, 528, 8,4);
                g.fillRect(144, 524, 8,4);
                g.fillRect(140, 520, 8,4);
                
            g.setColor(new Color(33,134,110));
                g.fillRect(188, 552, 4,4);
                g.fillRect(184, 536, 4,12);
                g.fillRect(188, 528, 4,8);
                g.fillRect(200, 536, 4,4);
                g.fillRect(164, 512, 8,12);
                g.fillRect(168, 524, 4,16);
                g.fillRect(56, 536, 4,4);
                g.fillRect(56, 548, 4,8);
                g.fillRect(24, 536, 4,4);
                g.fillRect(20, 532, 4,32);
    
            g.setColor(new Color(48,150,137));
                g.fillRect(164, 532, 4,4);
                g.fillRect(172, 540, 4,4);
                g.fillRect(180, 520, 8,8);
                g.fillRect(188, 524, 4,4);
                g.fillRect(180, 528, 4,28);
                g.fillRect(176, 544, 4,8);
                g.fillRect(188, 548, 4,4);
                g.fillRect(196, 533, 8,4);
                g.fillRect(196, 536, 4,20);
                g.fillRect(200, 540, 4,4);
                g.fillRect(200, 548, 4,12);
                g.fillRect(60, 556, 4,4);
                g.fillRect(60, 540, 4,4);
                g.fillRect(56, 544, 4,4);
                g.fillRect(44, 524, 8,24);
                g.fillRect(44, 548, 4,4);
                g.fillRect(44, 552, 8,12);
                g.fillRect(40, 564, 4,8);
                g.fillRect(36, 556, 4,16);
                g.fillRect(32, 540, 8,16);
                g.fillRect(24, 532, 4,4);
                g.fillRect(24, 540, 4,4);
            
               g2.setColor(new Color(99,152,185)); //ฟองอากาศ
               g2.translate(0, bubble);
               g2.fillRect(40, 504, 8,4);
               g2.fillRect(40, 508, 4,4);
               g2.fillRect(48, 508, 4,4);
               g2.fillRect(56, 520, 4,4);
               g2.fillRect(60, 516, 4,4);
               g2.fillRect(56, 508, 4,8);
               g2.fillRect(60, 504, 4,4);
               g2.fillRect(52, 500, 4,4);
               g2.fillRect(72, 500, 4,4);
               g2.fillRect(64, 496, 8,4);
               g2.fillRect(64, 492, 4,4);
               g2.fillRect(68, 488, 4,4);
               g2.fillRect(72, 492, 4,4);
               g2.fillRect(56, 480, 4,4);
               g2.fillRect(184, 500, 8,4);
               g2.fillRect(168, 492, 8,4);
               g2.fillRect(172, 484, 4,4);
               g2.fillRect(180, 484, 4,4);
               g2.fillRect(184, 480, 4,4);
               g2.fillRect(188, 484, 4,4);
               g2.fillRect(192, 488, 4,4);
               g2.fillRect(188, 472, 4,8);
               g2.fillRect(196, 476, 4,4);
               g2.fillRect(180, 464, 8,4);

               g.setColor(new Color(84,132,172));
               g.fillRect(52, 496, 8,4);
               g.fillRect(44, 500, 4,4);
               g.fillRect(48, 504, 4,4);
               g.fillRect(60, 508, 8,4);
               g.fillRect(68, 504, 4,4);
               g.fillRect(76, 500, 4,4);
               g.fillRect(56, 484, 4,4);
               g.fillRect(176, 480, 4,4);
               g.fillRect(184, 488, 4,4);
               g.fillRect(188, 492, 4,4);
               g.fillRect(192, 468, 4,8);
               g.fillRect(192, 484, 4,4);
               g.fillRect(200, 484, 4,4);
               g.fillRect(184, 508, 4,8);
               g.fillRect(180, 512, 4,4);

               g2.translate(0, bubble+100);
               g.setColor(new Color(119,171,192));
                g.fillRect(64, 488, 4,4);
                g.fillRect(168, 484, 4,4);
                g.fillRect(196, 472, 4,4);

               g2.translate(0, -bubble);
    }
}
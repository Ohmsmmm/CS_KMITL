// 61050150, 61050193
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class CG_1_2 extends JPanel{
    static int[][] arrayPic = new int [10000][10000];
    public static void getImg() throws IOException {
      final BufferedImage img = ImageIO.read(new File("./87424515_624640561429876_8166247668956266496_n.jpg"));
      final BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);
      for (int i = 0; i < img.getHeight(); i++) {
        for (int j = 0; j < img.getWidth(); j++) {
          final Color c = new Color(img.getRGB(j, i));
          arrayPic[i][j * 3] = c.getRed();
          arrayPic[i][(j * 3) + 1] = c.getGreen();
          arrayPic[i][(j * 3) + 2] = c.getBlue();
        }
      }
    }
    public void paintComponent(Graphics g) {
      for (int i = 0; i < 1000; i++) {
        for (int j = 0; j < 1000; j++) {
          g.setColor(new Color(arrayPic[i][j * 3], arrayPic[i][(j * 3) + 1], arrayPic[i][(j * 3) + 2]));
          g.fillRect(j, i, 1, 1);
        }
      }
    }
    public static void main(String[] args) throws IOException {
      CG_1_2 m = new CG_1_2();
      JFrame f = new JFrame();
      f.add(m);
      f.setSize(640, 960);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
      getImg();
    }
}

package dendy_tanks.probes;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class ProbePaintTanks {
  public static void main(String[] args) throws Exception {


    BufferedImage tanks = ImageIO.read(ProbePaintTanks.class.getResourceAsStream("/tanks.jpeg"));
    System.out.println("tanks = " + tanks);


    BufferedImage holst = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);

    {
      Graphics2D g = (Graphics2D) holst.getGraphics();

      g.setColor(Color.WHITE);
      g.fillRect(0, 0, holst.getWidth(), holst.getHeight());

      g.drawImage(tanks.getSubimage(81, 48, 14, 15), 100, 30, null);
      g.drawImage(tanks.getSubimage(81, 48, 14, 15), 100, 80, null);

      g.dispose();
    }

    ImageIO.write(holst, "png", new File("build/holst.png"));

  }
}

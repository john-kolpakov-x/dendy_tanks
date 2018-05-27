package dendy_tanks.probes;

import dendy_tanks.image_manager.Dir;
import dendy_tanks.image_manager.ImageManager;
import dendy_tanks.image_manager.Power;
import dendy_tanks.image_manager.TankColor;
import dendy_tanks.image_manager.Velocity;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class ProbePaintTanks {
  public static void main(String[] args) throws Exception {

    ImageManager im = new ImageManager();

    BufferedImage holst = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);

    TankColor tankColor = TankColor.GREEN;

    {
      Graphics2D g = (Graphics2D) holst.getGraphics();

      g.setColor(Color.WHITE);
      g.fillRect(0, 0, holst.getWidth(), holst.getHeight());

      int w = 18, x0 = 10, y = 10;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P1, Velocity.NORMAL, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P1, Velocity.NORMAL, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P1, Velocity.NORMAL, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P1, Velocity.NORMAL, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P1, Velocity.NORMAL, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P1, Velocity.NORMAL, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P1, Velocity.NORMAL, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P1, Velocity.NORMAL, true), x0 + w * 7, y, null);

      y += 20;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P2, Velocity.NORMAL, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P2, Velocity.NORMAL, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P2, Velocity.NORMAL, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P2, Velocity.NORMAL, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P2, Velocity.NORMAL, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P2, Velocity.NORMAL, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P2, Velocity.NORMAL, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P2, Velocity.NORMAL, true), x0 + w * 7, y, null);

      y += 20;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P3, Velocity.NORMAL, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P3, Velocity.NORMAL, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P3, Velocity.NORMAL, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P3, Velocity.NORMAL, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P3, Velocity.NORMAL, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P3, Velocity.NORMAL, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P3, Velocity.NORMAL, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P3, Velocity.NORMAL, true), x0 + w * 7, y, null);


      y += 20;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P4, Velocity.NORMAL, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P4, Velocity.NORMAL, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P4, Velocity.NORMAL, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P4, Velocity.NORMAL, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P4, Velocity.NORMAL, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P4, Velocity.NORMAL, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P4, Velocity.NORMAL, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P4, Velocity.NORMAL, true), x0 + w * 7, y, null);

      ///////////////////
      y += 30;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P1, Velocity.FAST, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P1, Velocity.FAST, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P1, Velocity.FAST, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P1, Velocity.FAST, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P1, Velocity.FAST, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P1, Velocity.FAST, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P1, Velocity.FAST, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P1, Velocity.FAST, true), x0 + w * 7, y, null);

      y += 20;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P2, Velocity.FAST, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P2, Velocity.FAST, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P2, Velocity.FAST, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P2, Velocity.FAST, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P2, Velocity.FAST, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P2, Velocity.FAST, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P2, Velocity.FAST, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P2, Velocity.FAST, true), x0 + w * 7, y, null);

      y += 20;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P3, Velocity.FAST, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P3, Velocity.FAST, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P3, Velocity.FAST, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P3, Velocity.FAST, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P3, Velocity.FAST, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P3, Velocity.FAST, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P3, Velocity.FAST, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P3, Velocity.FAST, true), x0 + w * 7, y, null);


      y += 20;

      g.drawImage(im.tank(tankColor, Dir.UP, Power.P4, Velocity.FAST, false), x0, y, null);
      g.drawImage(im.tank(tankColor, Dir.UP, Power.P4, Velocity.FAST, true), x0 + w * 1, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P4, Velocity.FAST, false), x0 + w * 2, y, null);
      g.drawImage(im.tank(tankColor, Dir.LEFT, Power.P4, Velocity.FAST, true), x0 + w * 3, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P4, Velocity.FAST, false), x0 + w * 4, y, null);
      g.drawImage(im.tank(tankColor, Dir.DOWN, Power.P4, Velocity.FAST, true), x0 + w * 5, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P4, Velocity.FAST, false), x0 + w * 6, y, null);
      g.drawImage(im.tank(tankColor, Dir.RIGHT, Power.P4, Velocity.FAST, true), x0 + w * 7, y, null);

      ///////////////////
      g.dispose();
    }

    ImageIO.write(holst, "png", new File("build/holst.png"));

  }
}

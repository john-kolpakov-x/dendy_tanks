package dendy_tanks.image_manager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageManager {

  private final BufferedImage allImages;

  public ImageManager() throws Exception {
    allImages = ImageIO.read(getClass().getResourceAsStream("/tanks.jpeg"));
  }

  public BufferedImage tank(TankColor tankColor, Dir dir, Power power, Velocity velocity, boolean state) {

    int x = 0;
    if (state) x += 16;
    x += (16 * 2) * dir.ordinal();

    int y = 0;

    y += power.ordinal() * 16;

    y += velocity.ordinal() * (16 * 4);

    switch (tankColor) {
      case WHITE:
        x += 16 * 8;
        break;
      case GREEN:
        y += 16 * 8;
        break;
      case RED:
        x += 16 * 8;
        y += 16 * 8;
        break;
    }

    return allImages.getSubimage(x, y, 16, 16);
  }
}

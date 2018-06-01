package dendy_tanks.entity;

import dendy_tanks.image_manager.Dir;
import dendy_tanks.image_manager.ImageManager;
import dendy_tanks.image_manager.Power;
import dendy_tanks.image_manager.TankColor;
import dendy_tanks.image_manager.Velocity;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Tank extends Entity {

  private final ImageManager imageManager;

  public Tank(ImageManager imageManager) {
    this.imageManager = imageManager;
  }

  public TankColor tankColor = TankColor.YELLOW;
  public Dir dir = Dir.UP;
  public Power power = Power.P1;
  public Velocity velocityLevel = Velocity.NORMAL;
  public boolean state = false;
  public boolean stopped = false;

  @Override
  public Point velocity() {
    if (stopped) return new Point(0, 0);
    int value = velocityLevel == Velocity.NORMAL ? 1 : 2;

    switch (dir) {
      case UP:
        return new Point(0, -value);
      case DOWN:
        return new Point(0, +value);
      case LEFT:
        return new Point(-value, 0);
      case RIGHT:
        return new Point(+value, 0);
      default:
        throw new IllegalArgumentException("dir = " + dir);
    }
  }

  @Override
  public void changeState() {
    state = !stopped && !state;
  }

  @Override
  public void paint(Graphics2D g) {
    BufferedImage tank = imageManager.tank(tankColor, dir, power, velocityLevel, state);
    g.drawImage(tank, location.x, location.y, width, height, null);
  }
}

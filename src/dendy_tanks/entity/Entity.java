package dendy_tanks.entity;

import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Entity {
  public Point location = new Point(0, 0);
  public int width, height;

  public Point velocity() {
    return new Point(0, 0);
  }

  public abstract void paint(Graphics2D g);

  public void changeState() {}
}

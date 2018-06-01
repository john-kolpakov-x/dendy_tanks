package dendy_tanks;

import dendy_tanks.entity.Entity;
import dendy_tanks.entity.EntityCollection;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.concurrent.atomic.AtomicBoolean;

public class GamePanel extends JPanel implements AutoCloseable {

  private final EntityCollection entityCollection;

  private final Thread paintThread;
  private final Thread moveThread;
  private final AtomicBoolean threadsRunning = new AtomicBoolean(true);

  public GamePanel(EntityCollection entityCollection) {
    this.entityCollection = entityCollection;

    paintThread = new Thread(() -> {

      while (threadsRunning.get()) {
        try {
          Thread.sleep(1000 / 24);
          SwingUtilities.invokeLater(this::repaint);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }

      }

    });

    paintThread.start();

    moveThread = new Thread(() -> {
      while (threadsRunning.get()) {
        try {

          Thread.sleep(30);

          moveStep();


        } catch (Exception e) {
          throw new RuntimeException(e);
        }

      }
    });

    moveThread.start();
  }

  private void moveStep() {

    //x.set(x.get() + 2);

    for (Entity entity : entityCollection.entityList) {
      Point v = entity.velocity();

      Point location = entity.location;

      Point newLocation = new Point(location.x + v.x, location.y + v.y);

      entity.location = newLocation;

      entity.changeState();
    }

  }

  @Override
  protected void paintComponent(Graphics g1) {
    super.paintComponent(g1);

    Graphics2D g = (Graphics2D) g1.create();
    try {
      paintItAll(g);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      g.dispose();
    }


  }

  private void paintItAll(Graphics2D g) throws Exception {

    for (Entity entity : entityCollection.entityList) {
      entity.paint(g);
    }

  }

  @Override
  public void close() {
    threadsRunning.set(false);
    try {
      paintThread.join();
      moveThread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

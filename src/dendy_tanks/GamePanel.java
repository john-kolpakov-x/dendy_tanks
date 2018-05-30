package dendy_tanks;

import dendy_tanks.image_manager.Dir;
import dendy_tanks.image_manager.ImageManager;
import dendy_tanks.image_manager.Power;
import dendy_tanks.image_manager.TankColor;
import dendy_tanks.image_manager.Velocity;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GamePanel extends JPanel implements AutoCloseable {

  private final ImageManager imageManager;

  private final Thread paintThread;
  private final Thread moveThread;
  private final AtomicBoolean threadsRunning = new AtomicBoolean(true);

  public GamePanel(ImageManager imageManager) {
    this.imageManager = imageManager;

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

          Thread.sleep(10);

          moveStep();


        } catch (Exception e) {
          throw new RuntimeException(e);
        }

      }
    });

    moveThread.start();
  }

  private void moveStep() {

    x.set(x.get() + 2);

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

  final AtomicInteger x = new AtomicInteger(100);

  private void paintItAll(Graphics2D g) throws Exception {

    BufferedImage tank = imageManager.tank(TankColor.YELLOW, Dir.DOWN, Power.P1, Velocity.FAST, false);

    g.drawImage(tank, x.get(), 100, 32, 32, null);

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

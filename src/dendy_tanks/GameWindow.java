package dendy_tanks;

import dendy_tanks.entity.EntityCollection;
import dendy_tanks.entity.Tank;
import dendy_tanks.image_manager.Dir;
import dendy_tanks.image_manager.ImageManager;
import dendy_tanks.image_manager.TankColor;
import dendy_tanks.image_manager.Velocity;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

public class GameWindow {
  public static void main(String[] args) throws Exception {
    GameSettings gameSettings = new GameSettings();
    ImageManager imageManager = new ImageManager();
    EntityCollection entityCollection = new EntityCollection(imageManager);

    Tank tank = entityCollection.createNewTank();
    tank.tankColor = TankColor.RED;
    tank.location = new Point(100, 100);
    tank.dir = Dir.RIGHT;
    tank.velocityLevel = Velocity.NORMAL;
    tank.stopped = false;

    JFrame window = new JFrame();
    window.setTitle("TANKS");
    window.setLocation(gameSettings.loadGameWindowLocation());
    window.setSize(1024, 600);
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    GamePanel gamePanel = new GamePanel(entityCollection);

    window.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentMoved(ComponentEvent e) {
        gameSettings.saveGameWindowLocation(e.getComponent().getLocation());
      }
    });

    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {


      @Override
      public boolean dispatchKeyEvent(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (e.getID() == KeyEvent.KEY_RELEASED) {

          if (keyCode == 38 || keyCode == 40 || keyCode == 39 || keyCode == 37) {
            tank.stopped = true;
            return true;
          }

          System.out.println("KEY_RELEASED keyCode = " + keyCode);
          return false;
        }

        if (e.getID() == KeyEvent.KEY_PRESSED) {

          if (keyCode == 38) {
            tank.dir = Dir.UP;
            tank.stopped = false;
            return true;
          }

          if (keyCode == 40) {
            tank.dir = Dir.DOWN;
            tank.stopped = false;
            return true;
          }

          if (keyCode == 39) {
            tank.dir = Dir.RIGHT;
            tank.stopped = false;
            return true;
          }

          if (keyCode == 37) {
            tank.dir = Dir.LEFT;
            tank.stopped = false;
            return true;
          }

          System.out.println("KEY_PRESSED keyCode = " + keyCode);
          return false;
        }


        System.out.println("keyCode = " + keyCode);

//        if (keyCode == )


        return false;
      }
    });


    window.setContentPane(gamePanel);

    SwingUtilities.invokeLater(() -> window.setVisible(true));
  }
}

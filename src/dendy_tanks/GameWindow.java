package dendy_tanks;

import dendy_tanks.image_manager.ImageManager;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameWindow {
  public static void main(String[] args) throws Exception {
    GameSettings gameSettings = new GameSettings();
    ImageManager imageManager = new ImageManager();

    JFrame window = new JFrame();
    window.setTitle("TANKS");
    window.setLocation(gameSettings.loadGameWindowLocation());
    window.setSize(1024, 600);
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    GamePanel gamePanel = new GamePanel(imageManager);

    window.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentMoved(ComponentEvent e) {
        gameSettings.saveGameWindowLocation(e.getComponent().getLocation());
      }
    });


    window.setContentPane(gamePanel);

    SwingUtilities.invokeLater(() -> window.setVisible(true));
  }
}

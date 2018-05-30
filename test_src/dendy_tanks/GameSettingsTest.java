package dendy_tanks;

import org.testng.annotations.Test;

import java.awt.Point;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class GameSettingsTest {

  @Test
  public void checkDefaultValueOfDir() {
    GameSettings gameSettings = new GameSettings();
    System.out.println(gameSettings.dir);
  }

  @Test
  public void saveLocation() throws Exception {
    GameSettings gameSettings = new GameSettings();
    gameSettings.dir = "build/.dendy_tanks";

    Random random = new Random();

    int x = random.nextInt();
    int y = random.nextInt();

    //
    //
    gameSettings.saveGameWindowLocation(new Point(x, y));
    //
    //

    File file = new File("build/.dendy_tanks/game_window_location");
    assertThat(file).exists();

    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
    assertThat(lines).hasSize(1);
    assertThat(lines.get(0)).isEqualTo(x + " " + y);
  }

  @Test
  public void loadGameWindowLocation_exists() throws Exception {
    GameSettings gameSettings = new GameSettings();
    gameSettings.dir = "build/loadGameWindowLocation";


    Random random = new Random();

    int x = random.nextInt();
    int y = random.nextInt();

    File file = new File(gameSettings.dir + "/game_window_location");
    file.getParentFile().mkdirs();

    Files.write(file.toPath(), singletonList(x + " " + y), StandardCharsets.UTF_8);

    //
    //
    Point point = gameSettings.loadGameWindowLocation();
    //
    //

    assertThat(point).isNotNull();
    assertThat(point.x).isEqualTo(x);
    assertThat(point.y).isEqualTo(y);
  }

  @Test
  public void loadGameWindowLocation_fileIsAbsent() throws Exception {
    GameSettings gameSettings = new GameSettings();
    gameSettings.dir = "build/dcs7ds8d7sa8d7sad";

    //
    //
    Point point = gameSettings.loadGameWindowLocation();
    //
    //

    assertThat(point).isNotNull();
    assertThat(point.x).isEqualTo(100);
    assertThat(point.y).isEqualTo(100);
  }

  @Test
  public void loadGameWindowLocation_existsButLeft1() throws Exception {
    GameSettings gameSettings = new GameSettings();
    gameSettings.dir = "build/loadGameWindowLocation";

    File file = new File(gameSettings.dir + "/game_window_location");
    file.getParentFile().mkdirs();

    Files.write(file.toPath(), singletonList("хрень"), StandardCharsets.UTF_8);

    //
    //
    Point point = gameSettings.loadGameWindowLocation();
    //
    //

    assertThat(point).isNotNull();
    assertThat(point.x).isEqualTo(100);
    assertThat(point.y).isEqualTo(100);
  }

  @Test
  public void loadGameWindowLocation_existsButLeft2() throws Exception {
    GameSettings gameSettings = new GameSettings();
    gameSettings.dir = "build/loadGameWindowLocation";

    File file = new File(gameSettings.dir + "/game_window_location");
    file.getParentFile().mkdirs();

    Files.write(file.toPath(), singletonList("123"), StandardCharsets.UTF_8);

    //
    //
    Point point = gameSettings.loadGameWindowLocation();
    //
    //

    assertThat(point).isNotNull();
    assertThat(point.x).isEqualTo(100);
    assertThat(point.y).isEqualTo(100);
  }

}
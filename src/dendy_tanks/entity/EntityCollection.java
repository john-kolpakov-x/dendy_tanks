package dendy_tanks.entity;

import dendy_tanks.image_manager.ImageManager;

import java.util.ArrayList;
import java.util.List;

public class EntityCollection {

  private final ImageManager imageManager;

  public final List<Entity> entityList = new ArrayList<>();

  public EntityCollection(ImageManager imageManager) {
    this.imageManager = imageManager;
  }

  public Tank createNewTank() {
    Tank tank = new Tank(imageManager);
    tank.width = 32;
    tank.height = 32;
    entityList.add(tank);
    return tank;
  }
}

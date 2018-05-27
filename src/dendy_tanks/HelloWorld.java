package dendy_tanks;

import java.io.InputStream;

public class HelloWorld {
  public static void main(String[] args) {
    InputStream resourceAsStream = HelloWorld.class.getResourceAsStream("asd.txt");
    System.out.println("resourceAsStream = " + resourceAsStream);
  }
}

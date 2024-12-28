package designPatterns.singleton;

public class Singleton {
  private static Singleton instance;

  Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  public void perform() {
    System.out.println("Perform some operation using singleton");
  }
}

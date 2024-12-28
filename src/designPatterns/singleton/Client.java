package designPatterns.singleton;

public class Client {

  public static void main(String[] args) {
    Singleton first = Singleton.getInstance();

    System.out.println(first.hashCode());

    Singleton second = Singleton.getInstance();

    System.out.println(second.hashCode());
    first.perform();
  }
}

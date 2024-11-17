public class AbstractionOOPs {
  public static void main(String[] args) {
    // Horse h1 = new Horse();
    // h1.eat();
    // h1.walk();
    // System.out.println(h1.color);

    // h1.changeColor();
    // System.out.println(h1.color);
    // Chicken c1 = new Chicken();
    // c1.eat();
    // c1.walk();
    // System.out.println(c1.color);
    Mustang myHorse = new Mustang();
    
  }
}

abstract class Animal {
  String color;

  Animal() {
    System.out.println("Animal constructor is called");
  }

  void eat() {
    System.out.println("Animal Eats");
  }

  abstract void walk();
}

class Horse extends Animal {

  Horse() {
    System.out.println("Horse constructor called");
  }

  void walk() {
    System.out.println("Walks on four legs");
  }
}

class Mustang extends Horse{
  Mustang(){
    System.out.println("Mustang constructor called");
  }
}


class Chicken extends Animal {
  void changeColor() {
    color = "yellow";
  }

  void walk() {
    System.out.println("Walks on 2 legs");
  }
}
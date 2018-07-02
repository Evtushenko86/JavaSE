package JavaSE02.t02;

import JavaSE02.t03.*;

public class Komus {
  public static void main(String[] args) {
    Worker ivanov = new Worker("Ivanov");
    ivanov.createSuite("Office1");
    ivanov.suite.addItem(new OfficeSupplies("Ручка",3,50));
    ivanov.suite.addItem(new OfficeSupplies("Карандаш",2,25));
    ivanov.suite.addItem(new OfficeSupplies("Резинка",1,15));
    ivanov.suite.printSuite();

    Beginner novichok = new Beginner("Новый работник");
    novichok.createBeginnersSuite();
    novichok.printSuite();
  }
}
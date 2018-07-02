package JavaSE02.t04;

import JavaSE02.t03.*;

public class SortedSuite {
  public static void main(String[] args) {
    Beginner novichok = new Beginner("Новый работник");
    novichok.createBeginnersSuite();
    novichok.printSuite();

    novichok.suite.sortSuiteByPrice();
    novichok.printSuite();

    novichok.suite.sortSuiteByName();
    novichok.printSuite();

    novichok.suite.sortSuiteByPriceAndName();
    novichok.printSuite();
  }
}

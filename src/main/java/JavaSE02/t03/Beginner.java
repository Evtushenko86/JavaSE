package JavaSE02.t03;

import JavaSE02.t02.*;
import JavaSE02.t01.*;

public class Beginner extends Worker {
  public Beginner(String surname) {
    super(surname);
  }

  public void createBeginnersSuite() {
    super.createSuite("BeginnersSuite");

    suite.addItem(new Pen(2, 50, 4, "Blue", 1));
//    suite.addItem(new Pen(1, 70, 4, "Red", 1));
//    suite.addItem(new Pen(1, 100, 4, "Black", 4));
    suite.addItem(new Pencil(1, 100, 4, "твердый"));
    suite.addItem(new Pencil(1, 100, 6, "мягкий"));
    suite.addItem(new Marker(2, 200, 10, "Yellow"));
    suite.addItem(new Notepad(2, 400, "NoColor", 200));
//    suite.addItem(new PostIt(3, 100, "Rose"));
    suite.addItem(new Scissors(1, 100, "Middle"));
    suite.addItem(new Knife(1, 100, "Small"));

  }
  public void printSuite(){
    suite.printSuite();
  }
}

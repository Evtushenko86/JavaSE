package JavaSE02.t03;

import JavaSE02.t02.*;

public class PaperSupplies extends OfficeSupplies{
  private String color;

  public PaperSupplies(String name, int count, int price, String color) {
    super(name, count, price);
    this.color = color;
  }

  @Override
  public String toString() {
    return super.toString() + ", цвет: " + color;
  }
}

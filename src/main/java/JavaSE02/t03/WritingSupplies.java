package JavaSE02.t03;

import JavaSE02.t02.*;

public class WritingSupplies extends OfficeSupplies{
    private int thickness;
  public WritingSupplies(String name, int count, int price, int thickness) {
    super(name, count, price);
    this.thickness = thickness;
  }

  @Override
  public String toString() {
    return super.toString() + ", толщина стержня (мм): " + thickness;
  }
}

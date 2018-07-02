package JavaSE02.t03;

import JavaSE02.t02.*;

public class CuttingSupplies extends OfficeSupplies{
    private String size;

  public CuttingSupplies(String name, int count, int price, String size) {
    super(name, count, price);
    this.size = size;
  }

  @Override
  public String toString() {
    return super.toString() + ", размер: " + size;
  }
}

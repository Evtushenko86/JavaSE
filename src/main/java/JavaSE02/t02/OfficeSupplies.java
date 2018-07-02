package JavaSE02.t02;

import java.util.Comparator;
import java.util.Objects;

public class OfficeSupplies {
  private String name;
  private int count;
  private int price;

  public OfficeSupplies(String name, int count, int price) {
    this.name = name;
    this.count = count;
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof OfficeSupplies)) return false;
    OfficeSupplies officeSupplies = (OfficeSupplies) o;
    return Objects.equals(name, officeSupplies.name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return name + ", количество = " + count +
            ", цена = " + price + " руб.";
  }
}
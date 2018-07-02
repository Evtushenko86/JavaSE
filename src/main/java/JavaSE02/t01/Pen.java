package JavaSE02.t01;

import JavaSE02.t03.WritingSupplies;

import java.util.Objects;

public class Pen extends WritingSupplies {
  private String color;
  private int countHandleStem;

  public Pen(int count, int price, int thickness, String color, int countHandleStem) {
    super("Ручка", count, price, thickness);
    this.color = color;
    this.countHandleStem = countHandleStem;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pen)) return false;
    if (!super.equals(o)) return false;
    Pen pen = (Pen) o;
    return countHandleStem == pen.countHandleStem &&
            Objects.equals(color, pen.color);
  }

  public int hashCode() {

    return Objects.hash(super.hashCode(), color, countHandleStem);
  }

  @Override
  public String toString() {
    return super.toString() + ", цвет: " + color + ", количество стержней: " + countHandleStem;
  }
}

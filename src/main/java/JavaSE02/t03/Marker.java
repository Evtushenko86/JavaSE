package JavaSE02.t03;

public class Marker extends WritingSupplies {
  private String color;

  public Marker(int count, int price, int thickness, String color) {
    super("Маркер", count, price, thickness);
    this.color = color;
  }

  @Override
  public String toString() {
    return super.toString() + ", цвет: " + color;
  }
}

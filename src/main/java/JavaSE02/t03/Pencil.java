package JavaSE02.t03;

public class Pencil extends WritingSupplies {
    private String softness;

  public Pencil(int count, int price, int thickness, String softness) {
    super("Карандаш", count, price, thickness);
    this.softness = softness;
  }

  @Override
  public String toString() {
    return super.toString() + ", мягкость: " + softness;
  }
}

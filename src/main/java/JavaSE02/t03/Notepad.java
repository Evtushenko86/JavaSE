package JavaSE02.t03;

public class Notepad extends PaperSupplies {
    private int countPage;

  public Notepad(int count, int price, String color, int countPage) {
    super("Блокнот", count, price, color);
    this.countPage = countPage;
  }

  @Override
  public String toString() {
    return super.toString() + ", количество страниц: " + countPage;
  }
}
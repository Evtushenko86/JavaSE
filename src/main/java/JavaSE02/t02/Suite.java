package JavaSE02.t02;

import java.util.ArrayList;
import java.util.Comparator;

public class Suite {
  private String name;
  private int totalValue;
  ArrayList <OfficeSupplies> list = new ArrayList<OfficeSupplies>();

  protected Suite(String name) {
    this.name = name;
  }

  public void addItem (OfficeSupplies officeSupplies){
    list.add(officeSupplies);
  }

  int getTotalValue(){
    totalValue = 0;
    for (OfficeSupplies i: list) {
      totalValue += (i.getCount() * i.getPrice());
    }
    return totalValue;
  }

  public void printSuite(){
    System.out.println("Рабочее место: " + name);
    for (OfficeSupplies i: list) {
      System.out.println(i);
    }
    System.out.println("Общая стоимость: " + getTotalValue() + " руб.");
  }

  public void sortSuiteByPrice(){
    Comparator<OfficeSupplies> pComp = new PriceComparator();
    list.sort(pComp);
  }

  public void sortSuiteByName(){
    Comparator<OfficeSupplies> nComp = new NameComparator();
    list.sort(nComp);
  }

  public void sortSuiteByPriceAndName() {
    Comparator<OfficeSupplies> pANComp = new PriceComparator().thenComparing(new NameComparator());
    list.sort(pANComp);
  }

  class PriceComparator implements Comparator<OfficeSupplies>{
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
      return Integer.compare(o1.getPrice(), o2.getPrice());
    }
  }

  class NameComparator implements Comparator<OfficeSupplies>{
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
      return o1.getName().compareTo(o2.getName());
    }
  }
}
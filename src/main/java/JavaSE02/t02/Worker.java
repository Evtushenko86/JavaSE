package JavaSE02.t02;

public class Worker {
  private String surname;
  public Suite suite;

  public Worker(String surname) {
    this.surname = surname;
  }

  protected void createSuite(String nameSuite){
    this.suite = new Suite(nameSuite);
  }
}
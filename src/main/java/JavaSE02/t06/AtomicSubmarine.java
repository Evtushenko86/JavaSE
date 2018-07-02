/**
 * @author Aleksei Evtushenko.
 * Declares an atomic submarine.
*/
package JavaSE02.t06;

  public class AtomicSubmarine {

    private String name;
    private int currentSpeed;
    private int noise;
    private int totalPowerful;
    private boolean holostoiHod = true;
    private int countWorkingEngine;

  public AtomicSubmarine() {
  }

  public AtomicSubmarine(String name) {
          this.name = name;
        }
  /**
  * Inner class for AtomicSubmarine. Declares the engine. The engine has parameters: name, start, powerful, noiseEngine and methods: startEngine, allPower, stopEngine.
  */
  class Engine{
      String name;
      boolean start;
      int powerful;
      int noiseEngine;

      public Engine(String name) {
        this.name = name;
      }
  /**
  * Turn on the engine on min powerful
  */
      void startEngine(){
        start = true;
        noiseEngine = 40;
        if (noise < noiseEngine)
          noise = noiseEngine;
        powerful = 1200;
        totalPowerful +=powerful;
        countWorkingEngine+=1;
        System.out.println("Двигатель " + name + " запущен!");
      }
  /**
  * Turn on the engine max powerful
  */
      void allPower(){
        noiseEngine = 120;
        if (noise < noiseEngine)
          noise = noiseEngine;
        powerful = 3600;
        totalPowerful += (powerful-1200);
        System.out.println("Двигатель " + name + ": полная мощность!");
      }
  /**
  * Turn off the engine
  */
      void stopEngine(){
        start = false;
        totalPowerful -=powerful;
        powerful = 0;
        countWorkingEngine-=1;
        System.out.println("Двигатель " + name + " остановлен!");
      }
  }
  /**
  * Turn on holostoiHod and allow submarine move
  */

  int getSpeedFromPowerful(int powerful){
    if (!holostoiHod)
        return powerful*2/1000;
    else
        return 0;
  }
  /**
  * Turn on holostoiHod and allow submarine move
  */
  void move(){
      holostoiHod = false;
      currentSpeed = getSpeedFromPowerful(totalPowerful);
  }
  /**
  * Give the info about submarine on the console.
  */
    void printCurrentCondition(){
      System.out.println("Атомная подводная лодка " + name);
      System.out.println("Текущая скорость " + getSpeedFromPowerful(totalPowerful));
      System.out.println("Количество работающих двигателей " + countWorkingEngine);
      System.out.println("Шум двигателей " + noise);
      System.out.println("Суммарная мощность " + totalPowerful);
      }

  public static void main(String[] args) {

   /**
   * Create a new AtomicSubmarine with 4 engines.
   */
    AtomicSubmarine typhoon = new AtomicSubmarine("Typhoon");
    AtomicSubmarine.Engine engine1 = typhoon.new Engine("Engine1");
    AtomicSubmarine.Engine engine2 = typhoon.new Engine("Engine2");
    AtomicSubmarine.Engine engine3 = typhoon.new Engine("Engine3");
    AtomicSubmarine.Engine engine4 = typhoon.new Engine("Engine4");

    engine1.startEngine();
    engine2.startEngine();
    engine3.startEngine();
    engine4.startEngine();
    typhoon.printCurrentCondition();
    typhoon.move();
    engine1.allPower();
    engine2.allPower();
    typhoon.printCurrentCondition();
    engine3.stopEngine();
    engine4.stopEngine();
    typhoon.printCurrentCondition();
  }
}
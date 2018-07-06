package JavaSE03.t01;

import JavaSE03.t01.CrazyLogger;
import org.junit.Test;

public class CrazyLoggerTest {

  @Test
  public void crazyLoggerTest() {
    CrazyLogger crazyLogger = new CrazyLogger();
    String s = "Message three in the CrazyLogger";

    crazyLogger.addMessage("Message one in the CrazyLogger");
    crazyLogger.addMessage("Message two in the CrazyLogger");
    crazyLogger.addMessage(s);

    crazyLogger.showLog();
    crazyLogger.searchInLog("three");
  }
}
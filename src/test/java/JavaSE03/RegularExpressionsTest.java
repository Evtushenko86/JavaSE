package JavaSE03;

import JavaSE03.t03.RegularExpressions;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RegularExpressionsTest {

  @Test
  public void isWork() throws IOException {
    final String filename = "C:\\EpamHomeWork\\src\\main\\resources\\fizika.html";
    final String codetype = "cp1251";

    RegularExpressions regularExpressions = new RegularExpressions();
    String text = regularExpressions.read(filename,codetype);

    regularExpressions.sentWithPic(text);
    System.out.println(regularExpressions.isPicsInRightOrder());
  }
}
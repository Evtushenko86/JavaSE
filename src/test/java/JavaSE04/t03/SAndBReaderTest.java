package JavaSE04.t03;

import org.junit.Test;

import static org.junit.Assert.*;

public class SAndBReaderTest {

  @Test
  public void sAndBReaderTest() {
    SAndBReader sAndBReader = new SAndBReader();
    sAndBReader.readAndWrite(sAndBReader.from, sAndBReader.to);
  }
}
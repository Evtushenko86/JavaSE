package JavaSE04.t01;

import org.junit.Test;

public class ByteCodeReaderTest {

  @Test
  public void byteCodeReaderTest() {
    ByteCodeReader byteCodeReader = new ByteCodeReader();
    byteCodeReader.readFromFile();
    byteCodeReader.searchForKeyWords();
    byteCodeReader.writeFile();
  }
}
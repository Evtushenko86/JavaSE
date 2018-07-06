package JavaSE04.t02;

import org.junit.Test;

public class SymbolCodeReaderTest {

  @Test
  public void symbolCodeReaderTest() {
    SymbolCodeReader symbolCodeReader = new SymbolCodeReader();
    symbolCodeReader.readFromFile();
    symbolCodeReader.searchForKeyWords();
    symbolCodeReader.writeFile();
  }
}
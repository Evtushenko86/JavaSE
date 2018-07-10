package JavaSE05.t02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.out;

public class PropertiesReader {
  String fileName = ""; //C:\EpamHomeWork\src\main\resources\prop.properties
  Properties properties = new Properties();

  public void loadProperties() throws FileIsNotProperties, IOException {
    out.println("Please, enter the path and name of the properties-file you would like to read:");
    Scanner scanner = new Scanner(System.in);
    fileName = scanner.next();
    getProperties(fileName);
  }
  public void getProperties(String fileName) throws FileIsNotProperties, IOException {
    if (!fileName.endsWith(".properties"))
      throw new FileIsNotProperties("Sorry, but this is not a *.properties file.");
    try (FileInputStream pair = new FileInputStream(fileName)) {
      properties.load(pair);
    }
  }

  public String getValueByKey(String key) throws KeyNotFound {
    String value = properties.getProperty(key);
    if (value == null) {
      throw new KeyNotFound("Could not find such key in the file...");
    }
    else return value;
  }

  class KeyNotFound extends Exception {

    public KeyNotFound(String text) {
      out.println(text);
    }
  }

  class FileIsNotProperties extends Exception {

    public FileIsNotProperties(String text) {
      out.println(text);
    }
  }

  public static void main (String [] args) throws KeyNotFound{
    PropertiesReader propertiesReader = new PropertiesReader();
    try {
      propertiesReader.loadProperties();
      while (true) {
        System.out.println("Please, enter the key if you want to know a value or Q for quit:");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        if (!(key.equals("Q")))
          System.out.println("The value is " + propertiesReader.getValueByKey(key) + ".");
        else
          break;
      }
    }
    catch (FileIsNotProperties | IOException e){
      e.printStackTrace();
    };
  }
}

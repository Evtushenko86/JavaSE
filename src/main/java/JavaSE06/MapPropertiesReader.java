package JavaSE06;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MapPropertiesReader {
  String delemiters = "=: ";
  String fileName; //C:\EpamHomeWork\src\main\resources\prop.properties
  Map<String, String> properties = new HashMap<>();
  String tmp;
  String key;
  String value;


  public void loadProperties() throws IOException {
    System.out.println("Please, enter the path and name of the properties file you would like to read:");
    Scanner scanner = new Scanner(System.in);
    fileName = scanner.next();
    try {
      getProperties(fileName);
    }
    catch (FileNotFoundException e){
      System.out.println("Error: file not found.");
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void getProperties(String fileName) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      while((tmp = br.readLine())!=null){
        StringTokenizer tokenizer = new StringTokenizer(tmp, delemiters);
        if (tokenizer.countTokens() == 2){
          properties.put(tokenizer.nextToken(), tokenizer.nextToken());
        }
        if (tokenizer.countTokens() > 2){
          key = tokenizer.nextToken();
          while(tokenizer.hasMoreElements())
            value+=tokenizer.nextToken();
          properties.put(key, value);
        }
      }
    }
  }

  public String getValueByKey(String key) throws KeyNotFound {
    String value = properties.get(key);
    if (value == null) {
      throw new KeyNotFound("Could not find such key in the file...");
    }
    else return value;
  }

  class KeyNotFound extends Exception {

    public KeyNotFound(String text) {
      System.out.println(text);
    }
  }

  public static void main (String [] args) throws KeyNotFound{
    MapPropertiesReader propertiesReader = new MapPropertiesReader();
    try {
      propertiesReader.loadProperties();
      while (true) {
        System.out.println("Please enter the key if you want to know a value or Q for quit:");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        if (!(key.equalsIgnoreCase("Q")))
          System.out.println("The value is " + propertiesReader.getValueByKey(key) + ".");
        else
          break;
      }
    }
    catch (IOException e){
      e.printStackTrace();
    }
//    Map <String, String> map = new HashMap<>();
//    map.put("1","One");
//    map.put("2","Two");
//    map.put("3","Three");
//    map.put("4","Four");
//    for (Map.Entry <String, String> entry: map.entrySet()) {
//      System.out.println("№ " + entry.getKey() + " Name " + entry.getValue());
//    }
//    System.out.println("");
//    map.put("2","Five");
//    for (Map.Entry <String, String> entry: map.entrySet()) {
//      System.out.println("№ " + entry.getKey() + " Name " + entry.getValue());
//    }
  }
}

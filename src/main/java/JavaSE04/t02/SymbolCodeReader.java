package JavaSE04.t02;

import JavaSE04.t01.KeyWords;

import java.io.*;

public class SymbolCodeReader {

  KeyWords k = new KeyWords();
  StringBuilder stringBuilder = new StringBuilder();
  String fileName = "C:\\EpamHomeWork\\src\\main\\java\\JavaSE03\\t01\\CrazyLogger.java";
  String fileToWrite = "C:\\EpamHomeWork\\src\\main\\resources\\SCROutput.txt";

  public String readFromFile(){
    StringBuilder result = new StringBuilder();
    try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
      String s;
      while((s = bf.readLine())!=null){
        result.append(s);
        result.append(System.lineSeparator());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  //  System.out.println(result.toString());
    return result.toString();
    }

  public void searchForKeyWords(){
    String [] wordsFromFile = readFromFile().split("\\s+");
    for (String s: wordsFromFile) {
      if(k.javaKW.containsKey(s)){
        Integer count = (Integer) k.javaKW.get(s);
        k.javaKW.put(s,++count);
      }
    }
  }

  public void writeFile(){
      for(String s: k.keywords){
        if((Integer)k.javaKW.get(s)>0) {
          stringBuilder.append(s);
          stringBuilder.append(" - ");
          stringBuilder.append(k.javaKW.get(s));
          stringBuilder.append("; ");
          stringBuilder.append(System.lineSeparator());
        }
      }
      try(FileWriter writer = new FileWriter(fileToWrite,false)){
        writer.write(stringBuilder.toString());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}

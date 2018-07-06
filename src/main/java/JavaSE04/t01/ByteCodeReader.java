package JavaSE04.t01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteCodeReader {
    KeyWords k = new KeyWords();
    StringBuilder stringBuilder = new StringBuilder();
    String fileName = "C:\\EpamHomeWork\\src\\main\\java\\JavaSE03\\t01\\CrazyLogger.java";
    String fileToWrite = "C:\\EpamHomeWork\\src\\main\\resources\\BCROutput.txt";

    public String readFromFile(){
      StringBuilder readFromFile = new StringBuilder();
      try(FileInputStream inFile = new FileInputStream(fileName)){
        int b = 0;
        while ((b = inFile.read())!=-1){
          readFromFile.append((char)b);
        }
      } catch (
              FileNotFoundException e)
      {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    //  System.out.println(readFromFile);
      return readFromFile.toString();
    }

    public void searchForKeyWords(){
      String [] wordsFromFile = readFromFile().toString().split("\\s+");
      for (String s: wordsFromFile)
    //  System.out.println(s);
    //  for (String s: wordsFromFile) {
        if(k.javaKW.containsKey(s)){
          Integer count = (Integer) k.javaKW.get(s);
          k.javaKW.put(s,++count);
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
      byte[] bytes = stringBuilder.toString().getBytes();
      try(FileOutputStream out = new FileOutputStream(fileToWrite,false)) {
        out.write(bytes);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}

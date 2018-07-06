package JavaSE04.t03;

import java.io.*;
import java.nio.charset.Charset;

public class SAndBReader {
  static StringBuilder text = new StringBuilder();
  String from = "C:\\EpamHomeWork\\src\\main\\resources\\SAndBReaderOutput_utf8";
  String to = "C:\\EpamHomeWork\\src\\main\\resources\\SAndBReaderOutput_utf16";
/*
  public static void readAndWrite(String from, String to){
    try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(from), Charset.forName("UTF-8")))){
      String nextLine;
      while((nextLine=bf.readLine())!=null){
        text.append(nextLine);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    */

  public static void readAndWrite(String from, String to){
    try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(from), Charset.forName("UTF-8")))){
      String nextLine;
      while((nextLine=bf.readLine())!=null){
        text.append(nextLine);
        text.append(System.lineSeparator());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(to),Charset.forName("UTF-16")))){
      bw.write(text.toString());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

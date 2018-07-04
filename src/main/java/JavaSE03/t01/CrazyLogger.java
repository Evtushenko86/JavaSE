package JavaSE03.t01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CrazyLogger {

  StringBuilder log;
  SimpleDateFormat dateFormat;

  public CrazyLogger() {
    log = new StringBuilder();
    dateFormat = new SimpleDateFormat("dd-MM-yyyy : hh-mm");
  }

  public void addMessage(String s){
    Date date = new Date();
    log.append(dateFormat.format(date)+" - " + s + "; ");
  }

  public void showLog(){
    System.out.println(log);
  }

  public void searchInLog(String textToFind){
    String [] logToSeek = log.toString().split("; ");
    for (String s: logToSeek){
      if(s.contains(textToFind))
        System.out.println(s);
    }
  }
}

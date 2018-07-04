package JavaSE03.t03;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
  ArrayList<String> allSentence = new ArrayList<>();
  ArrayList <String> allPicsNumbers = new ArrayList<>();

  public String read(String filename, String codetype) throws IOException {
    File html = new File(filename);
    Document document = Jsoup.parse(html,codetype);
    return document.text();
  }

  public void sentWithPic(String text) {
    Pattern p = Pattern.compile("(^|(?<=[.!?]\\s\\t?))(\\d+\\.\\s\\t?)*[А-ЯA-Z][^!?]*?[.!?](?=\\s*(\\d+\\.\\s\\t?)*[А-ЯA-Z]|$)", Pattern.MULTILINE);
    Matcher m = p.matcher(text);
    while (m.find()) {
      if (m.group().matches("(.*[Р|р]ис\\..*)")) {
        allSentence.add(m.group());
        System.out.println(m.group());
      }
    }
  }

  //find if pic one by one
  public boolean isPicsInRightOrder(){
    Pattern p = Pattern.compile("\\([Р|р]ис\\.\\s+\\d+\\)", Pattern.MULTILINE);
    Matcher m;
    for (String s: allSentence) {
      m = p.matcher(s);
      while (m.find()) {
        allPicsNumbers.add(s.substring(m.start(),m.end()));
      }
    }
    int temp = 0;
    int next = 0;
    p = Pattern.compile("\\d+");
    for (String s: allPicsNumbers) {
      m = p.matcher(s);
      while (m.find()){
        next = Integer.parseInt(s.substring(m.start(),m.end()));
        System.out.println(next);
        if(next<temp){
          return false;
        }
        temp = next;
        System.out.println(s.substring(m.start(),m.end()));
      }
    }
    return true;
  }
}
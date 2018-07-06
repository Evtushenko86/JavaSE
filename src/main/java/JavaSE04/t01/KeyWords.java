package JavaSE04.t01;

import java.util.HashMap;
import java.util.Map;

public class KeyWords {
  public final String kw = "abstract, assert, boolean, break, byte, case, catch, char, class, const, continue, default, double, do, else, enum, extends, final, finally, float, for, goto, if, implements, import, instanceof, int, interface, long, native, new, package, private, protected, public, return, short, static, strictfp, super, switch, synchronized, this, throw, throws, transient, try, void, volatile, while";
  public final String [] keywords;
  public Map javaKW = new HashMap();

  public Map getJavaKW() {
    return javaKW;
  }

  public KeyWords(){
    keywords = kw.split(", ");
    for (String s:keywords) {
      javaKW.put(s,0);
    }
  }

  public void show(){
    for (String s: keywords) {
      System.out.println(s);
    }
  }
}

package JavaSE02.t05;

import java.util.*;

public class Student {

  private String Lastname;
  Map <Discipline, Mark> discAndMarks = new HashMap<Discipline, Mark>();

  public Student(String lastname) {
    Lastname = lastname;
  }

  public String getLastname() {
    return Lastname;
  }

  @Override
  public String toString() {
    return Lastname;
  }

  void printAllDiscWithMarks() {
    System.out.println(String.format("Студент %s имеет следующую успеваемость:",Lastname));
    for (Map.Entry<Discipline,Mark> entry : discAndMarks.entrySet())
      System.out.println(entry.getKey().toString() + ": " + entry.getValue().toString());
  }


  public void compareMarks(Discipline dis1, Discipline dis2){
    String result = "";
    double markOfDis1 = 0.0;
    double markOfDis2 = 0.0;

    if(discAndMarks.get(dis1).getMark() instanceof Double){
      markOfDis1 = (double)discAndMarks.get(dis1).getMark();
    }else if(discAndMarks.get(dis1).getMark() instanceof Integer){
      markOfDis1 = (double)(Integer)discAndMarks.get(dis1).getMark();
    }
    if(discAndMarks.get(dis2).getMark() instanceof Double){
      markOfDis2 = (double)discAndMarks.get(dis2).getMark();
    }else if(discAndMarks.get(dis2).getMark() instanceof Integer){
      markOfDis2 = (double)(Integer)discAndMarks.get(dis2).getMark();
    }

    if(markOfDis1 < markOfDis2){
      result = String.format("%s mark is higher than %s mark",dis2,dis1);
    }else if(markOfDis1 > markOfDis2){
      result = String.format("%s mark is higher than %s mark",dis1,dis2);
    }else {
      result = String.format("same marks in %s and %s",dis2,dis1);;
    }

    System.out.println(String.format("Student %s has a %s",Lastname,result));
  }
}

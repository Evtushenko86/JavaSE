package JavaSE03.t02;

import java.util.Locale;
import java.util.Scanner;

public class Oscar2018 {
  ResourceProperty myBundle;
  String locale = "en";

    public void chooseLocale(){
      Scanner in = new Scanner(System.in);
      System.out.println("Please, choose language: English (E), Russian (R)");
      String input = in.next();
      if(input.equalsIgnoreCase("e")){
        myBundle = new ResourceProperty(new Locale("en", "EN"));
        System.out.println("English");
      }
      else if(input.equalsIgnoreCase("r")){
        myBundle = new ResourceProperty(new Locale("ru", "RU"));
        System.out.println("Русский");
        locale = "ru";
      }
    }

    public void showQuestions(){
      System.out.println("1. " + myBundle.getQuestion("questions.key1"));
      System.out.println("2. " + myBundle.getQuestion("questions.key2"));
      System.out.println("3. " + myBundle.getQuestion("questions.key3"));
      System.out.println("4. " + myBundle.getQuestion("questions.key4"));
    }

    public void chooseQuestionAndGetAnswer() {
      String question = "";
      if (locale == "ru")
         System.out.println("Выберите номер вопроса:");
      else
         System.out.println("Choose the number of the question:");
      Scanner in = new Scanner(System.in);
      String input = in.next();
      System.out.println(myBundle.getAnswer("answers.value"+input));
    }

    public static void main(String [] args){
      Oscar2018 oscar2018 = new Oscar2018();
      oscar2018.chooseLocale();
      oscar2018.showQuestions();
      oscar2018.chooseQuestionAndGetAnswer();
    }
}

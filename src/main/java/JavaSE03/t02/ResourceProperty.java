package JavaSE03.t02;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceProperty {
  private ResourceBundle bundle_questions;
  private ResourceBundle bundle_answers;

  public ResourceProperty(Locale locale) {
    bundle_questions = ResourceBundle.getBundle("questions", locale);
    bundle_answers = ResourceBundle.getBundle("answers", locale);
  }

  public String getQuestion(String key){
    return bundle_questions.getString(key);
  }

  public String getAnswer(String key){
    return bundle_answers.getString(key);
  }
}
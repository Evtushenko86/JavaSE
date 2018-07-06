package JavaSE04.t04;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
  String title;
  ArrayList<Actor> mainActors = new ArrayList<>();

  public Movie(String title, ArrayList<Actor> mainActors) {
    this.title = title;
    this.mainActors = mainActors;
  }

  public Movie(String title) {
    this.title = title;

  }

  public void addActors(Actor... actors){
    if(actors.length!=0){
      for(Actor actor: actors){
        if (!mainActors.contains(actor)){
          mainActors.add(actor);
        }
      }
    }
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public ArrayList<Actor> getMainActors() {
    return mainActors;
  }
}

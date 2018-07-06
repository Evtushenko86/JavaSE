package JavaSE04.t04;

import java.io.*;
import java.util.ArrayList;

public class Kinopoisk implements Serializable {
  ArrayList<Movie> kinopoiskDB = new ArrayList<>();
  String fileName = "C:\\EpamHomeWork\\src\\main\\resources\\Kinopoisk.txt";

  public Kinopoisk(){
    getKinopoiskDB(fileName);
  }

  public void getKinopoiskDB(String fileName){
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
      kinopoiskDB = (ArrayList<Movie>)ois.readObject();
    } catch (FileNotFoundException e) {

    } catch (IOException e) {
       e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void saveKinopoiskDB(){
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
      oos.writeObject(kinopoiskDB);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addMovie(Movie movie){
    kinopoiskDB.add(movie);
  }

  public void removeMovie(String movieTitle){
    for (Movie movie: kinopoiskDB) {
      if(movie.getTitle().equalsIgnoreCase(movieTitle)){
        kinopoiskDB.remove(movie);
      }
    }
  }

  public void changeMovieTitle(String wrongTitle, String correctMovieTitle){
    for (Movie movie: kinopoiskDB) {
      if(movie.getTitle().equalsIgnoreCase(wrongTitle)){
        movie.setTitle(correctMovieTitle);
      }
    }
  }
}

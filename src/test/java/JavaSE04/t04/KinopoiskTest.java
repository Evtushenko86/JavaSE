package JavaSE04.t04;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class KinopoiskTest {

  @Test
  public void kinopoiskTest() {
    ArrayList<Movie> newListOfMovie = new ArrayList<>();

    Movie newMovie = new Movie("Семь");
    newMovie.addActors(new Actor("Брэд","Питт"), new Actor("Морган","Фриман"));
    newListOfMovie.add(newMovie);

    newMovie = new Movie("Бойцовский клуб");
    newMovie.addActors(new Actor("Брэд","Питт"), new Actor("Эдвард","Нортон"));
    newListOfMovie.add(newMovie);

    try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\EpamHomeWork\\src\\main\\resources\\Kinopoisk.txt"))) {
      objectOutputStream.writeObject(newListOfMovie);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    Kinopoisk kinopoisk = new Kinopoisk();
    newMovie = new Movie("300 спартанцев");
    newMovie.addActors(new Actor("Джерард","Батлер"));
    kinopoisk.addMovie(newMovie);

    for (Movie m : kinopoisk.kinopoiskDB) {
      System.out.println(m.getTitle());
    }

    assertThat(kinopoisk.kinopoiskDB.size(), Is.is(3));


  }
}
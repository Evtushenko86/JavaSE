package JavaSE05.t01;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Explorer {

  Scanner scanner;
  static File dir;   // = new File("c:\\")
  static File file; //= new File("default.txt")

  Explorer() {
    scanner = new Scanner(System.in);
    dir = new File("c:\\");
    file = new File("default.txt");
  }

  //dialog

  public void dialog() {
    boolean b = true;
    while (b) {
      System.out.println("Please choose the key for command that you need:");
      scanner = new Scanner(System.in);
      System.out.println("1. Browse directory \n2. Create text file \n3. Delete text file \n4. Add data to text file \n5. Quit");
      String choice = (scanner.next()).toLowerCase();
      switch (choice) {
        case "1":
          browseDirectory();
          break;
        case "2":
          createTextFile();
          break;
        case "3":
          deleteFile();
          break;
        case "4":
          addDataToFile();
          break;
        case "5":
          b = false;
          break;
        default:
          System.out.println("Input error");
          b = false;
          break;
      }
    }
  }

  //Browse directory

  public void browseDirectory() {
    System.out.println("Please write the path directory you want to browse");
    String path = scanner.next();
    dir = new File(path);
    if (!dir.isDirectory()) {
      System.out.println("It's not a directory.");
    } else {
      String[] dirContent = dir.list();
      System.out.println("The current directory is " + dir.toString() + "contains the following folders and files:");
      for (String s : dirContent) {
        System.out.println(s);
      }
    }
  }

  //Create new file

  public void createTextFile() {
    System.out.println("Please write the name of the file you want to create in the current directory:");
    String fileName = scanner.next();
    if (!fileName.equals("")) {
      file = new File(dir + "\\" + fileName + ".txt");
      try {
          if (!file.exists()) {
            file.createNewFile();
            System.out.println("The file " + fileName + ".txt is created in the directory "+dir.toString()); }
          else{
            System.out.println("The file with the same name already exists in this directory.");}
      }
      catch (IOException e) {
          System.out.println("Couldn't create the file.");
          e.printStackTrace();
      }
    }
  }

  //Add data to the textFile

  private void addDataToFile() {
    System.out.println("Please write the name of the file in the current directory you want to read and add a new data:");
    String fileName = scanner.next();
    try {
      ArrayList<String> tmp = getFromFile(dir + "\\" + fileName);
      System.out.println("The current data of the file " + fileName + ":");
      for (String s : tmp)
        System.out.println(s);
      System.out.println("Please write your data and it will be added to the file:");
      String add;
      add = new Scanner(System.in).useDelimiter("\n").next();
      writeToFile(dir + "\\" + fileName, add);
      System.out.println("The file is updated.");
    }
    catch (FileNotFoundException e) {
      System.out.println("There is no such file in the directory.");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.out.println("Something goes wrong: input/output error");
      e.printStackTrace();
    }
  }

  //

  private void deleteFile() {
    System.out.println("Please write the name of the file in the current directory you want to delete:");
    String fileName = scanner.next();
    file = new File(dir + "\\" + fileName);
    if (file.exists()) {
      file.delete();
      System.out.println("The file " + fileName + " is deleted.");
    }else {
      System.out.println("There is no such file in the directory.");
    }
  }

  //read from file
  public ArrayList<String> getFromFile(String from) throws FileNotFoundException {
    ArrayList<String> textLines = new ArrayList<>();
    try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(from), Charset.forName("UTF-16")))) {
      String nextLine;
      while ((nextLine = bf.readLine()) != null) {
        textLines.add(nextLine);
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("There is no such file in the directory.");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.out.println("Something goes wrong: input/output error");
      e.printStackTrace();
    }
    return textLines;
  }

  //write to file
  public void writeToFile(String to, String add) throws FileNotFoundException {
    try (FileWriter writer = new FileWriter(to, true)) {
      writer.append(System.lineSeparator() + add);
    }
    catch (FileNotFoundException e) {
      System.out.println("There is no such file in the directory.");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.out.println("Something goes wrong: input/output error");
      e.printStackTrace();
    }
  }

  public static void main (String [] args){
      Explorer explorer = new Explorer();
      explorer.dialog();
    }
}
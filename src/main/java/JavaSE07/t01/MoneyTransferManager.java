package JavaSE07.t01;

import javax.naming.InsufficientResourcesException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoneyTransferManager {
  private final ArrayList<String> listOfFile = new ArrayList<>();
  Map<String, Account> accounts = new HashMap<>();

  private void readFromFile(File file) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String input;
      while ((input = reader.readLine()) != null) {
        listOfFile.add(input);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public MoneyTransferManager(File file) throws InsufficientResourcesException {

    readFromFile(file);

    for (String s : listOfFile) {
      if (s.contains("-")) {
        String accountArray[] = s.split("-");
        accounts.put(accountArray[0], new Account(accountArray[0], Integer.parseInt(accountArray[1])));
      }
    }

    for (String s : listOfFile) {
      if (s.contains(",")) {
        String[] transfer = s.split(",");
        Operations operations = new Operations();
        operations.start();
        operations.transfer(accounts.get(transfer[0]), accounts.get(transfer[1]), Integer.parseInt(transfer[2]));
      }
    }
  }

  public static void main(String[] args) throws InsufficientResourcesException {
    MoneyTransferManager moneyTransferManager = new MoneyTransferManager(new File("C:\\EpamHomeWork\\src\\main\\resources\\accounts.txt"));
    for (HashMap.Entry <String, Account> entry: moneyTransferManager.accounts.entrySet()) {
      System.out.println(entry.getValue());
    }
  }
}
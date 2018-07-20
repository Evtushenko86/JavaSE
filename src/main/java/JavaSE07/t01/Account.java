package JavaSE07.t01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
//  private final Lock lock = new ReentrantLock();
  private String name;
  private int balance;

  public Account(String name, int initialBalance) {
    this.name = name;
    this.balance = initialBalance;
  }

 // public void withdraw(int amount){
  public synchronized void withdraw(int amount){
    balance -= amount;
  }

//  public void deposit(int amount){
  public synchronized void deposit(int amount){
    balance += amount;
  }

  public int getBalance() {
    return balance;
  }

//  public Lock getLock() {
//    return lock;
//  }

  @Override
  public String toString() {
    return name + ' ' +
            ", balance=" + balance;
  }
}

package JavaSE07.t01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InsufficientResourcesException;

public class Operations extends Thread {
  private static final Logger log = LogManager.getLogger();

  public void transfer(Account account1, Account account2, int amount) throws InsufficientResourcesException {
    if (account1.getBalance() < amount) {
      throw new InsufficientResourcesException();
    }
    else {

//    try {
//      if (account1.getLock().tryLock(1, TimeUnit.SECONDS)) {
//        try {
//          if (account2.getLock().tryLock(1, TimeUnit.SECONDS)) {
//            try {
      account2.deposit(amount);
      account1.withdraw(amount);
    }
//            } finally {
//              account2.getLock().unlock();
//            }
//          }
//        } finally {
//          account1.getLock().unlock();
//        }
//
//        log.info("acc1:" + account1.getBalance() + " acc2:" + account2.getBalance());
//
//      }else{
//        throw new RuntimeException("Too much time for waiting");
//      }
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }
}

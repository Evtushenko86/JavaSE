package JavaSE07.t02;

import JavaSE06.MapPropertiesReader;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedPropertiesFileReader extends MapPropertiesReader {
  ReentrantLock loadFileLock = new ReentrantLock();

  {
    properties = new ConcurrentHashMap<>();
  }


  @Override
  public void getProperties(String filePath) throws IOException {
    loadFileLock.lock();
    try{
      super.getProperties(filePath);
    }
    finally {
      loadFileLock.unlock();
    }
  }
}
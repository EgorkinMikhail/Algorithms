package org.example.Interviews.Revolut.LoadBalancerTask;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoadBalancer {
  private final int maxLoadSize = 10;
  private final Map<String, BackendInstance> backendInstanceMap;
  private Lock lock;
  Random random;


  public LoadBalancer() {
    backendInstanceMap = new HashMap<>();
    lock = new ReentrantLock();
    random = new Random();
  }

  public boolean registerBackendInstance(BackendInstance backendInstance){
    boolean returnStatus = false;

    if (backendInstance == null ) {
      throw new LoadBalancerException();
    }

    if (backendInstance.getAddress().isBlank() ) {
      throw new LoadBalancerException();
    }

    lock.lock();
    try {
      if (backendInstanceMap.keySet().size() == maxLoadSize) {
        throw new LoadBalancerException();
      } else {
        if (backendInstanceMap.putIfAbsent(backendInstance.getAddress(), backendInstance) == null) {
          returnStatus = true;
        } else {
          System.out.println("duplicates are not allowed");
        }
      }
    } finally {
      lock.unlock();
    }
    return returnStatus;
  }

  public BackendInstance getInstance() {
    if (backendInstanceMap.isEmpty()) {
      throw new LoadBalancerException();
    }

    List<String> addressList = new ArrayList<>(backendInstanceMap.keySet());
    return backendInstanceMap.get(addressList.get(random.nextInt(backendInstanceMap.size()-1)));
  }


}

package org.example.Tasks.Network.LoadBalancerTask;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoadBalancer {
  private final int maxLoadSize = 10;
  private final Map<String, BackendInstance> backendInstanceMap;
  private Lock lock;
  private Random random;


  public LoadBalancer() {
    backendInstanceMap = new HashMap<>();
    lock = new ReentrantLock();
    random = new Random();
  }

  public int getCountOfRegisteredInstances() {
    return backendInstanceMap.size();
  }

  public Set<String> getSetOfAllInstances() {
    return backendInstanceMap.keySet();
  }

  public boolean registerBackendInstance(BackendInstance backendInstance){
    boolean returnStatus = false;

    if (backendInstance == null ) {
      throw new LoadBalancerException();
    }

    if (backendInstance.getAddress() == null ) {
      throw new LoadBalancerException();
    }

    if (backendInstance.getAddress().isBlank() ) {
      throw new LoadBalancerException();
    }

    try {
      lock.lock();
      if (backendInstanceMap.keySet().size() == maxLoadSize) {
        //throw new LoadBalancerException();
        System.out.println("Balancer is fully loaded");
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
    try {
      lock.lock();
      List<String> addressList = new ArrayList<>(backendInstanceMap.keySet());
      return backendInstanceMap.get(addressList.get(random.nextInt(backendInstanceMap.size()-1)));
    } finally {
      lock.unlock();
    }

  }

}

package org.example.Patterns.Observer.solution;

import java.util.ArrayList;
import java.util.List;

class Server {
  private List<ServerObserver> observers = new ArrayList<>();
  private String status;
  private double cpuLoad;
  private double memoryUsage;
  private String networkStatus;
  private long uptime;

  public void addObserver(ServerObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(ServerObserver observer) {
    observers.remove(observer);
  }

  public void setParameters(String status, double cpuLoad, double memoryUsage, String networkStatus, long uptime) {
    this.status = status;
    this.cpuLoad = cpuLoad;
    this.memoryUsage = memoryUsage;
    this.networkStatus = networkStatus;
    this.uptime = uptime;
    notifyObservers();
  }

  private void notifyObservers() {
    for (ServerObserver observer : observers) {
      observer.update(status, cpuLoad, memoryUsage, networkStatus, uptime);
    }
  }
}
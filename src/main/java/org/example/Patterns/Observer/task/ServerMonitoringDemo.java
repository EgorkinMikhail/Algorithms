package org.example.Patterns.Observer.task;

public class ServerMonitoringDemo {
  public static void main(String[] args) {
    Server server = new Server();

    server.setParameters("Running", 23.5, 5120.75, "Online", 100);
    server.setParameters("High Load", 85.3, 10240.25, "Online", 200);
    server.setParameters("Down", 0.0, 0.0, "Offline", 0);
  }
}
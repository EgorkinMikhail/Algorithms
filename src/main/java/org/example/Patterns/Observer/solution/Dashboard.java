package org.example.Patterns.Observer.solution;

class Dashboard implements ServerObserver {
  @Override
  public void update(String status, double cpuLoad, double memoryUsage, String networkStatus, long uptime) {
    System.out.println("Dashboard - Displaying server status: " + status +
        ", CPU Load: " + cpuLoad + "%, Memory Usage: " + memoryUsage +
        " MB, Network Status: " + networkStatus + ", Uptime: " + uptime +
        " hours");
  }
}
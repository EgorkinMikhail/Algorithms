package org.example.Patterns.Observer.solution;

class AdminNotifier implements ServerObserver {
  @Override
  public void update(String status, double cpuLoad, double memoryUsage, String networkStatus, long uptime) {
    System.out.println("AdminNotifier - Server status: " + status +
        ", CPU Load: " + cpuLoad + "%, Memory Usage: " + memoryUsage +
        " MB, Network Status: " + networkStatus + ", Uptime: " + uptime +
        " hours");
  }
}
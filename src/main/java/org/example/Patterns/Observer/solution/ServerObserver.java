package org.example.Patterns.Observer.solution;

interface ServerObserver {
  void update(String status, double cpuLoad, double memoryUsage, String networkStatus, long uptime);
}
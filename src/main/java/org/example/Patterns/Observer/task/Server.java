package org.example.Patterns.Observer.task;

class Server {
  private String status;
  private double cpuLoad;
  private double memoryUsage;
  private String networkStatus;
  private long uptime;
  private final AdminNotifier adminNotifier = new AdminNotifier();
  private final SystemMonitor systemMonitor = new SystemMonitor();
  private final Dashboard dashboard = new Dashboard();

  public Server() {
  }

  public Server(String status, double cpuLoad, double memoryUsage,
                String networkStatus, long uptime) {
    this.status = status;
    this.cpuLoad = cpuLoad;
    this.memoryUsage = memoryUsage;
    this.networkStatus = networkStatus;
    this.uptime = uptime;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setParameters(String status, double cpuLoad, double memoryUsage,
                            String networkStatus, long uptime) {
    this.status = status;
    this.cpuLoad = cpuLoad;
    this.memoryUsage = memoryUsage;
    this.networkStatus = networkStatus;
    this.uptime = uptime;
    adminNotifier.notify(status);
    systemMonitor.log(status, cpuLoad, memoryUsage, networkStatus, uptime);
    dashboard.display(status);
  }
}

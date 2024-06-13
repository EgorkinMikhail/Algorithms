package org.example.Patterns.Observer.solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemMonitor implements ServerObserver {
  private static final String LOG_FILE_PATH = "server_logs.txt";

  @Override
  public void update(String status, double cpuLoad, double memoryUsage, String networkStatus, long uptime) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String timestamp = now.format(formatter);

    String logEntry = String.format(
        "%s - Server status: %s, CPU Load: %.2f%%, Memory Usage: %.2f MB, Network Status: %s, Uptime: %d hours",
        timestamp, status, cpuLoad, memoryUsage, networkStatus, uptime
    );

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
      writer.write(logEntry);
      writer.newLine();
    } catch (IOException e) {
      System.err.println("Error writing to log file: " + e.getMessage());
    }

  }
}
package org.example.Patterns.Observer.task;

public class AdminNotifier {
  public void notify(String status) {
    System.out.println("AdminNotifier - Server status: " + status);
  }
}

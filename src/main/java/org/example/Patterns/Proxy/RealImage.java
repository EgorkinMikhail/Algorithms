package org.example.Patterns.Proxy;

public class RealImage implements Image {
  private String fileName;

  public RealImage(String fileName) {
    this.fileName = fileName;
    loadFromDisk(fileName);  // Expensive operation, loads the image from disk
  }

  private void loadFromDisk(String fileName) {
    System.out.println("Loading " + fileName);
  }

  @Override
  public void display() {
    System.out.println("Displaying " + fileName);
  }
}
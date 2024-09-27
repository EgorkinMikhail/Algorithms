package org.example.Patterns.Proxy.apply;

import org.example.Patterns.Proxy.RealImage;

public class ProxyImage implements Image {
  private RealImage realImage;
  private String fileName;

  public ProxyImage(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void display() {
    if (realImage == null) {  // Lazy loading: Load only when needed
      realImage = new RealImage(fileName);
    }
    realImage.display();
  }
}
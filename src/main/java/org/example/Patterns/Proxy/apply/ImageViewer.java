package org.example.Patterns.Proxy.apply;

public class ImageViewer {
  public static void main(String[] args) {
    Image image1 = new ProxyImage("photo1.jpg");  // Uses Proxy instead of RealImage
    Image image2 = new ProxyImage("photo2.jpg");

    // Display images
    image1.display();  // Image is loaded from disk and displayed
    image2.display();  // Image is loaded from disk and displayed
  }
}
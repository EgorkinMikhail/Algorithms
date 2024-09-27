package org.example.Patterns.Proxy;

public class ImageViewer {
  public static void main(String[] args) {
    Image image1 = new RealImage("photo1.jpg");
    Image image2 = new RealImage("photo2.jpg");

    // Display images
    image1.display();  // Both images are loaded and displayed immediately
    image2.display();
  }
}

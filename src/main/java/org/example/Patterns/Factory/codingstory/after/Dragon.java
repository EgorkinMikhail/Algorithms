package org.example.Patterns.Factory.codingstory.after;

public class Dragon implements Enemy {
  @Override
  public void attack() {
    System.out.println("Dragon breathes fire!");
  }

  @Override
  public void defend() {
    System.out.println("Dragon defends with its scales!");
  }
}

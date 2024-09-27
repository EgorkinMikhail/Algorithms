package org.example.Patterns.Factory.codingstory.after;

public class Goblin implements Enemy {
  @Override
  public void attack() {
    System.out.println("Goblin attacks with a club!");
  }

  @Override
  public void defend() {
    System.out.println("Goblin defends with a small shield!");
  }
}
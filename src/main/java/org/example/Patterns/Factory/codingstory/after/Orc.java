package org.example.Patterns.Factory.codingstory.after;

public class Orc implements Enemy {
  @Override
  public void attack() {
    System.out.println("Orc swings his axe furiously!");
  }

  @Override
  public void defend() {
    System.out.println("Orc raises a heavy shield!");
  }
}

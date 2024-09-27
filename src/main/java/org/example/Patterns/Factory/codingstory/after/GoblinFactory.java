package org.example.Patterns.Factory.codingstory.after;

public class GoblinFactory implements EnemyFactory {
  @Override
  public Enemy createEnemy() {
    return new Goblin();
  }
}
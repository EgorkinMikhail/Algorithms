package org.example.Patterns.Factory.codingstory.after;

public class DragonFactory implements EnemyFactory {
  @Override
  public Enemy createEnemy() {
    return new Dragon();
  }
}
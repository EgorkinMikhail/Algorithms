package org.example.Patterns.Factory.codingstory.after;

public class OrcFactory implements EnemyFactory {
  @Override
  public Enemy createEnemy() {
    return new Orc();
  }
}

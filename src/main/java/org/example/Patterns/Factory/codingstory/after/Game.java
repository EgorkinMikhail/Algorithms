package org.example.Patterns.Factory.codingstory.after;

public class Game {
  private EnemyFactory enemyFactory;

  public Game(EnemyFactory factory) {
    this.enemyFactory = factory;
  }

  public void spawnEnemy() {
    Enemy enemy = enemyFactory.createEnemy();
    enemy.attack();
    enemy.defend();
  }

  public static void main(String[] args) {
    // Spawn Goblin
    Game goblinGame = new Game(new GoblinFactory());
    goblinGame.spawnEnemy();

    // Spawn Orc
    Game orcGame = new Game(new OrcFactory());
    orcGame.spawnEnemy();

    // Spawn Dragon
    Game dragonGame = new Game(new DragonFactory());
    dragonGame.spawnEnemy();
  }
}
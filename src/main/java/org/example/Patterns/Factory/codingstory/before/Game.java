package org.example.Patterns.Factory.codingstory.before;

public class Game {
  public void spawnEnemy(String enemyType) {
    if (enemyType.equals("goblin")) {
      Goblin goblin = new Goblin();
      goblin.attack();
      goblin.defend();
    } else if (enemyType.equals("orc")) {
      Orc orc = new Orc();
      orc.attack();
      orc.defend();
    } else if (enemyType.equals("dragon")) {
      Dragon dragon = new Dragon();
      dragon.attack();
      dragon.defend();
    } else {
      System.out.println("Unknown enemy type!");
    }
  }

  public static void main(String[] args) {
    Game game = new Game();
    game.spawnEnemy("goblin");
    game.spawnEnemy("orc");
    game.spawnEnemy("dragon");
  }
}
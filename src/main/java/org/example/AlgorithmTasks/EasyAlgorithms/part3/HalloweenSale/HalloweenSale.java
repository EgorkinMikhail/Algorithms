package org.example.AlgorithmTasks.EasyAlgorithms.part3.HalloweenSale;

public class HalloweenSale {

  public static int howManyGames(int p, int d, int m, int s) {
    // Return the number of games you can buy
    int currentGamePrice = p;
    int gamesCount = 0;
    while (s >= currentGamePrice) {
      s = s - currentGamePrice;
      gamesCount++;
      if ((currentGamePrice - d) < m) {
        currentGamePrice = m;
      } else {
        currentGamePrice = currentGamePrice - d;
      }
    }
    return gamesCount;
  }
}

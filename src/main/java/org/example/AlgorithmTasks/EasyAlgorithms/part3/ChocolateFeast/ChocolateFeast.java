package org.example.AlgorithmTasks.EasyAlgorithms.part3.ChocolateFeast;

public class ChocolateFeast {

  public static int chocolateFeast(int n, int c, int m) {
    int wrappers = n / c;
    int chocolates = wrappers;
    while (wrappers >= m) {
      wrappers = wrappers - m;
      chocolates++;
      wrappers++;
    }
    return chocolates;
  }
}

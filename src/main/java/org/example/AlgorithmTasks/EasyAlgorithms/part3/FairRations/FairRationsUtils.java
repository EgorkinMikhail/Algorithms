package org.example.AlgorithmTasks.EasyAlgorithms.part3.FairRations;

import java.util.List;

public class FairRationsUtils {

  public static String fairRations(List<Integer> B) {
    // Write your code here
    int counter = 0;
    for (int i = 0; i < B.size() - 1; i++) {
      if (B.get(i) % 2 == 1) {
        B.set(i, B.get(i) + 1);
        B.set(i + 1, B.get(i + 1) + 1);
        counter += 2;
      }
    }
    return B.get(B.size() - 1) % 2 == 0 ? "" + counter : "NO";
  }
}

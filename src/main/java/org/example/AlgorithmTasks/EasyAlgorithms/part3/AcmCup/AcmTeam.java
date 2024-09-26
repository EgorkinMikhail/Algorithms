package org.example.AlgorithmTasks.EasyAlgorithms.part3.AcmCup;

import java.util.List;

public class AcmTeam {

  public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
    // 0 1 0 1 1
    // 1 0 0 1 0
    // 1 1 1 0 0
    int teamMaxProfi = 0;
    int teamMaxProfiCount = 0;
    for (int i = 0; i < topic.size() - 1; i++) {
      for (int j = i; j < topic.size(); j++) {
        if (i == j) continue;
        int currentProfi = 0;
        for (int k = 0; k < topic.get(i).length(); k++) {
          int firstI = Character.getNumericValue(topic.get(i).charAt(k));
          int firstJ = Character.getNumericValue(topic.get(j).charAt(k));
          if ((firstJ + firstI) > 0) {
            currentProfi++;
          }
        }
        if (currentProfi == teamMaxProfi) {
          teamMaxProfiCount++;
        }
        if (currentProfi > teamMaxProfi) {
          teamMaxProfiCount = 1;
          teamMaxProfi = currentProfi;
        }
      }
    }
    return List.of(teamMaxProfi, teamMaxProfiCount);
  }


  public static int downPrice(List<Integer> prices) {
    // Write your code here
    // [3, 4, 3, 2, 3, 2, 1, 3, 2, 5, 4]
    int currentMin = prices.get(0);
    int currentMax = prices.get(0);
    int down = 0;

    for (int i = 0; i < prices.size() - 1; i++) {
      if (prices.get(i + 1) < currentMin) {
        currentMin = prices.get(i + 1);
        if (down < (currentMax - currentMin)) {
          down = currentMax - currentMin;
        }
      } else {
        if (currentMax < prices.get(i + 1)) {
          currentMax = prices.get(i + 1);
          currentMin = currentMax;
        }
      }
    }
    return down;
  }
}

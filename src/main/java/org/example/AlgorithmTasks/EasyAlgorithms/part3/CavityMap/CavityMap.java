package org.example.AlgorithmTasks.EasyAlgorithms.part3.CavityMap;

import java.util.List;

public class CavityMap {

  public static List<String> cavityMap(List<String> grid) {
    // Write your code here
    if (grid.size() < 3) return grid;

    for (int i = 1; i < grid.size() - 1; i++) {
      for (int j = 1; j < grid.size() - 1; j++) {
        int element = Integer.parseInt(grid.get(i).substring(j, j + 1));
        int up = (grid.get(i - 1).charAt(j) != 'X') ? Integer.parseInt(grid.get(i - 1).substring(j, j + 1)) : 9;
        int down = (grid.get(i + 1).charAt(j) != 'X') ? Integer.parseInt(grid.get(i + 1).substring(j, j + 1)) : 9;
        int left = (grid.get(i).charAt(j - 1) != 'X') ? Integer.parseInt(grid.get(i).substring(j - 1, j)) : 9;
        int right = (grid.get(i).charAt(j + 1) != 'X') ? Integer.parseInt(grid.get(i).substring(j + 1, j + 2)) : 9;
        if ((element > up) && (element > down)
            && (element > left) && (element > right)) {
          grid.set(i, grid.get(i).substring(0, j) + "X" + grid.get(i).substring(j + 1));
        }
      }
    }
    return grid;
  }
}

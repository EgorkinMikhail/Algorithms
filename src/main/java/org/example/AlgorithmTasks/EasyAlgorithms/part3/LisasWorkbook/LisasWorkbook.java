package org.example.AlgorithmTasks.EasyAlgorithms.part3.LisasWorkbook;
 // Lisa's Workbook Hackerrank

import java.util.List;

public class LisasWorkbook {

  public static int workbook(int n, int k, List<Integer> arr) {
    // Write your code here
    int result = 0;
    int pageNumber = 1;
    for (int i = 0; i < n; i++) {
      int val = k;
      for (int j = 1; j <= arr.get(i); j++) {
        if (j == pageNumber) result++;
        val = val - 1;
        if (val == 0) {
          pageNumber++;
          val = k;
        }
      }
      if (val != k)
        pageNumber++;
    }
    return result;
  }

}

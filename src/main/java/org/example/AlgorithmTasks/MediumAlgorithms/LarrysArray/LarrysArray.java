package org.example.AlgorithmTasks.MediumAlgorithms.LarrysArray;

import java.util.List;

public class LarrysArray {

  public static String larrysArray(List<Integer> A) {
    // Write your code here
    for (int i = 0; i < A.size() - 1; i++) {
      int element = i + 1;
      while (A.indexOf(element) != i) {
        if (A.indexOf(element) + 1 == A.size()) {
          int a = A.get(A.indexOf(element) - 1);
          int b = A.get(A.indexOf(element) - 2);
          if ((a > element) && (b < element)) {
            return "NO";
          }
        }
        doRotate(A, i);
      }
    }
    return "YES";
  }

  private static List<Integer> doRotate(List<Integer> A, int index) {
    int realPosition = A.indexOf(index + 1);
    if ((realPosition - index) == 1) {
      int a = A.get(realPosition - 1);
      int b = A.get(realPosition);
      int c = A.get(realPosition + 1);

      A.set(realPosition - 1, b);
      A.set(realPosition, c);
      A.set(realPosition + 1, a);
    } else {
      int a = A.get(realPosition - 2);
      int b = A.get(realPosition - 1);
      int c = A.get(realPosition);

      A.set(realPosition - 2, c);
      A.set(realPosition - 1, a);
      A.set(realPosition, b);
    }
    return A;
  }

}

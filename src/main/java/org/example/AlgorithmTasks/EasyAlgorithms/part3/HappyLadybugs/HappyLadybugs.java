package org.example.AlgorithmTasks.EasyAlgorithms.part3.HappyLadybugs;

import java.util.HashMap;
import java.util.Map;

public class HappyLadybugs {

  public static String happyLadybugs(String b) {
    // Write your code here
    Map<Character, Integer> boardMap = new HashMap<>();

    for (int i = 0; i < b.length(); i++) {
      if (!boardMap.containsKey(b.charAt(i))) {
        boardMap.put(b.charAt(i), 1);
      } else {
        boardMap.put(b.charAt(i), (boardMap.get(b.charAt(i)) + 1));
      }
    }
    if (!boardMap.containsKey('_') && boardMap.containsValue(1)) {
      return "NO";
    }

    if (!boardMap.containsKey('_')) {
      char[] chars = b.toCharArray();
      boolean sorted = true;
      int countOfDuplicates = 0;
      for (int i = 0; i < b.length() - 1; i++) {
        if (chars[i] == chars[i + 1]) {
          countOfDuplicates++;
        } else {
          if (countOfDuplicates == 0) break;
          countOfDuplicates = 0;
        }
      }
      return countOfDuplicates > 0 ? "YES" : "NO";
    }

    boardMap.remove('_');

    if (boardMap.containsValue(1)) {
      return "NO";
    }

    return "YES";
  }
}

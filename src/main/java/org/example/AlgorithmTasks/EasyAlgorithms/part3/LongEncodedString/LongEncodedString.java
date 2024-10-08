package org.example.AlgorithmTasks.EasyAlgorithms.part3.LongEncodedString;

import java.util.ArrayList;
import java.util.List;

public class LongEncodedString {
// Hackerrank Long Encoded String
  public static List<Integer> decoder(String s) {
    List<Integer> values = new ArrayList<>();

    for (int i = 0; i < 26; i++) {
      values.add(0);
    }
    for (int i = 0; i < s.length(); i++) {
      if ((i + 1 < s.length()) && s.charAt(i + 1) == '(') {
        values.set(Integer.parseInt(String.valueOf(s.charAt(i))) - 1, Integer.parseInt(s.substring(i + 2, s.indexOf(')', i + 2))));
        i = i + s.substring(i, s.indexOf(')', i)).length();
        continue;
      }
      if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
        if (i + 3 < s.length() && s.charAt(i + 3) == '(') {
          values.set(Integer.parseInt(s.substring(i, i  + 2)) - 1, Integer.parseInt(s.substring(i + 4, s.indexOf(')', i + 4))));
          i = i + s.substring(i, s.indexOf(')', i)).length();
        } else {
          values.set(Integer.parseInt(s.substring(i, i  + 2)) - 1, 1);
          i = i + 2;
        }
        continue;
      }
      int value = Integer.parseInt(String.valueOf(s.charAt(i)));
      values.set(value - 1, 1);
    }

    return values;
  }

}

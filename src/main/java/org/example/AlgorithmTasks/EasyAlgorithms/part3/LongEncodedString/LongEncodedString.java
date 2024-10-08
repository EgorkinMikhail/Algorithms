package org.example.AlgorithmTasks.EasyAlgorithms.part3.LongEncodedString;

import java.util.ArrayList;
import java.util.List;
// Hackerrank Long Encoded String
public class LongEncodedString {

  public static List<Integer> decoder(String s) {
    List<Integer> values = new ArrayList<>(26);

    for (int i = 0; i < 26; i++) {
      values.add(0);
    }

    int i = 0;
    while (i < s.length()) {
      //
      if (i + 1 < s.length() && s.charAt(i + 1) == '(') {
        int index = Character.getNumericValue(s.charAt(i)) - 1;
        int endParenIndex = s.indexOf(')', i + 2);
        int frequency = Integer.parseInt(s.substring(i + 2, endParenIndex));
        values.set(index, frequency);
        i = endParenIndex + 1;
      }
      //
      else if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
        int index = Integer.parseInt(s.substring(i, i + 2)) - 1;
        if (i + 3 < s.length() && s.charAt(i + 3) == '(') {
          int endParenIndex = s.indexOf(')', i + 4);
          int frequency = Integer.parseInt(s.substring(i + 4, endParenIndex));
          values.set(index, frequency);
          i = endParenIndex + 1;
        } else {
          values.set(index, 1);
          i += 3;
        }
      }
      // Обработка одиночных чисел без скобок
      else {
        int index = Character.getNumericValue(s.charAt(i)) - 1;
        values.set(index, 1);
        i++;
      }
    }

    return values;
  }
}
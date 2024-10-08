package org.example.AlgorithmTasks.MediumAlgorithms.TheTimeInWords;

import java.util.HashMap;
import java.util.Map;

public class TheTimeInWords {

  private static Map<Integer, String> timeMap = new HashMap<>();

  public static String timeInWords(int h, int m) {
    // Write your code here
    String prefix;
    fillHoursHashMap();

    switch (m) {
      case (1) -> {prefix = " minute ";}
      case (15), (30) , (45) -> {prefix = " ";}
      default -> {prefix = " minutes ";}
    }
    if (m == 0) {
      return timeMap.get(h).concat(" o' clock");
    }
    if (m <= 30) {
      return timeMap.get(m).concat(prefix).concat("past ").concat(timeMap.get(h));
    } else {
      m = 60 - m;
      h = h + 1;
      return timeMap.get(m).concat(prefix).concat("to ").concat(timeMap.get(h));
    }
  }

  private static void fillHoursHashMap() {
    timeMap.put(0, "zero");
    timeMap.put(1, "one");
    timeMap.put(2, "two");
    timeMap.put(3, "three");
    timeMap.put(4, "four");
    timeMap.put(5, "five");
    timeMap.put(6, "six");
    timeMap.put(7, "seven");
    timeMap.put(8, "eight");
    timeMap.put(9, "nine");
    timeMap.put(10, "ten");
    timeMap.put(11, "eleven");
    timeMap.put(12, "twelve");

    timeMap.put(13, "thirteen");
    timeMap.put(14, "fourteen");
    timeMap.put(15, "quarter");
    timeMap.put(16, "sixteen");
    timeMap.put(17, "seventeen");
    timeMap.put(18, "eighteen");
    timeMap.put(19, "nineteen");
    timeMap.put(20, "twenty");
    timeMap.put(21, "twenty one");
    timeMap.put(22, "twenty two");
    timeMap.put(23, "twenty three");
    timeMap.put(24, "twenty four");
    timeMap.put(25, "twenty five");
    timeMap.put(26, "twenty six");
    timeMap.put(27, "twenty seven");
    timeMap.put(28, "twenty eight");
    timeMap.put(29, "twenty nine");
    timeMap.put(30, "half");
  }
}

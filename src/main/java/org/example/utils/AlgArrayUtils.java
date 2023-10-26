package org.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgArrayUtils {

  public static List<Integer> createIntegerArrayList(String arrayString) {

    return Arrays.stream(arrayString.split(" "))
        .map(Integer::parseInt)
        .toList();
  }

  public static List<String> createStringArrayList(String arrayString) {

    return new ArrayList<>(List.of(arrayString.split(" ")));
  }
}

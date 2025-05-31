package org.example.leetcode;

import org.example.AlgorithmTasks.EasyAlgorithms.leetcode.NumArray;
import org.junit.Test;

import java.util.Arrays;

public class TestClass {

  @Test
  public void NumArrayTest() {

    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    System.out.println(numArray.sumRange(0, 2));
    System.out.println(numArray.sumRange(2, 5));
    System.out.println(numArray.sumRange(0, 5));
  }

  @Test
  public void name() {

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    String listString = Arrays.toString(numbers).replaceAll("\\[", "").replaceAll("]", "");
    System.out.println(listString.replaceAll("\\[", "").replaceAll("]", ""));
  }
}

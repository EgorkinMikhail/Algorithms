package org.example.leetcode;

import org.example.AlgorithmTasks.EasyAlgorithms.leetcode.NumArray;
import org.junit.Test;

public class TestClass {

  @Test
  public void NumArrayTest() {

    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    System.out.println(numArray.sumRange(0, 2));
    System.out.println(numArray.sumRange(2, 5));
    System.out.println(numArray.sumRange(0, 5));
  }
}

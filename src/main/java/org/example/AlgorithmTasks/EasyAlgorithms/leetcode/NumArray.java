package org.example.AlgorithmTasks.EasyAlgorithms.leetcode;

// Range Some Query

public class NumArray {

  private final int[] array;

  public NumArray(int[] nums) {
    this.array = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      this.array[i] = sum;
    }
  }

  public int sumRange(int left, int right) {
    if (left == 0) {
      return array[right];
    }
    return array[right] - array[left - 1];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
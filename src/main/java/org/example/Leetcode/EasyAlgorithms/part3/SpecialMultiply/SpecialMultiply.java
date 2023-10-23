package org.example.Leetcode.EasyAlgorithms.part3.SpecialMultiply;

public class SpecialMultiply {

  public static int mul(int a, int b)
  {
    if (a == 0 || b == 0) {
      return 0;
    }

    if (b == 1) {
      return a;
    }

    if (a == 1) {
      return b;
    }

    return a + mul(a, b - 1);
  }

  public static int multiply(int a, int b)
  {
    int m = mul(a, Math.abs(b));
    return (b < 0) ? -m : m;
  }
}

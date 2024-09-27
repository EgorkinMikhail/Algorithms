package org.example.Patterns.Strategy.apply;

public class ClearanceDiscount implements DiscountStrategy {
  @Override
  public double applyDiscount(double price) {
    return price * 0.5;  // 50% off
  }
}

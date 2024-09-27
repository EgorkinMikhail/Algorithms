package org.example.Patterns.Strategy.apply;

public class NoDiscount implements DiscountStrategy {
  @Override
  public double applyDiscount(double price) {
    return price;
  }
}

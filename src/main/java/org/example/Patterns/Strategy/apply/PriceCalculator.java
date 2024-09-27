package org.example.Patterns.Strategy.apply;

public class PriceCalculator {
  private DiscountStrategy discountStrategy;

  public PriceCalculator(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;
  }

  public double calculatePrice(double price) {
    return discountStrategy.applyDiscount(price);
  }
}
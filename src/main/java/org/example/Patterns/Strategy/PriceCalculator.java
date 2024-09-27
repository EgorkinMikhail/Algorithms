package org.example.Patterns.Strategy;

public class PriceCalculator {
  public double calculatePrice(double price, String discountType) {
    if (discountType.equals("NO_DISCOUNT")) {
      return price;
    } else if (discountType.equals("SEASONAL_DISCOUNT")) {
      return price * 0.9;  // 10% off
    } else if (discountType.equals("CLEARANCE_DISCOUNT")) {
      return price * 0.5;  // 50% off
    } else {
      throw new IllegalArgumentException("Invalid discount type");
    }
  }
}

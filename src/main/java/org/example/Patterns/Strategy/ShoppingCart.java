package org.example.Patterns.Strategy;

public class ShoppingCart {
  public static void main(String[] args) {
    PriceCalculator calculator = new PriceCalculator();
    double price = 100.0;

    // Calculate price with different discounts
    double noDiscountPrice = calculator.calculatePrice(price, "NO_DISCOUNT");
    double seasonalDiscountPrice = calculator.calculatePrice(price, "SEASONAL_DISCOUNT");
    double clearanceDiscountPrice = calculator.calculatePrice(price, "CLEARANCE_DISCOUNT");

    System.out.println("Price without discount: " + noDiscountPrice);
    System.out.println("Price with seasonal discount: " + seasonalDiscountPrice);
    System.out.println("Price with clearance discount: " + clearanceDiscountPrice);
  }
}

package org.example.Patterns.Strategy.apply;

public class ShoppingCart {
  public static void main(String[] args) {
    double price = 100.0;

    PriceCalculator noDiscountCalculator = new PriceCalculator(new NoDiscount());
    PriceCalculator seasonalDiscountCalculator = new PriceCalculator(new SeasonalDiscount());
    PriceCalculator clearanceDiscountCalculator = new PriceCalculator(new ClearanceDiscount());

    System.out.println("Price without discount: " + noDiscountCalculator.calculatePrice(price));
    System.out.println("Price with seasonal discount: " + seasonalDiscountCalculator.calculatePrice(price));
    System.out.println("Price with clearance discount: " + clearanceDiscountCalculator.calculatePrice(price));
  }
}

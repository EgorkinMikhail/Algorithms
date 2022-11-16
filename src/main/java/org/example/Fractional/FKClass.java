package Fractional;

import java.util.Arrays;
import java.util.Comparator;

public class FKClass {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);
        final Item item4 = new Item(5, 28);

        final Item[] items = {item1, item2, item3, item4};

        Arrays.sort(items, Comparator.comparing(Item::valuePerUnitOfWeight).reversed());

        System.out.println(Arrays.toString(items));

        final int W = 8;

        double valueSoFar = 0;
        int weightSoFar = 0;
        int currentItem = 0;

        while (currentItem < items.length && weightSoFar != W) {
            if ((weightSoFar + items[currentItem].getWeight()) < W) {

                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) * items[currentItem].getValue();

                weightSoFar = W;
            }

            currentItem++;
        }

        System.out.println("Best values: " + valueSoFar);
    }

}

class Item {
    private final int weight;
    private final int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    @Override
    public String toString() {
        return "{W: " + weight + ", V: " + value + ", V/W: " + valuePerUnitOfWeight() +"}";
    }
}
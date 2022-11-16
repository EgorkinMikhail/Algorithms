package org.example.Patterns;

import java.util.*;

public class BridgePattern {

    public static void main(String[] args) {

        Figure redSquare = new Square(new Red());
        redSquare.print();
        Figure blueSquare = new Square(new Blue());
        blueSquare.print();

        int[] ints = {1,2,4,5,6,7,3,4,2,5,6,1,2,6,7,8,4,5,9,0};

        String str = String.join("",Arrays.stream(ints).boxed()
        .sorted()
        .map(String::valueOf)
        .toArray(String[] ::new));

        System.out.println(str);
    }
}
    abstract class Figure {
        Color color;

        public Figure(Color color) {
            this.color = color;
        }

        abstract void print();
    }

    interface Color {
        void print(String figureName);
    }

    class Square extends Figure {
        public Square(Color color) {
            super(color);
        }

        @Override
        void print() {
            color.print("Square is ");
        }
    }

    class Red implements Color {
        @Override
        public void print(String figureName) {
            System.out.println(figureName + "Red");
        }
    }

    class Blue implements Color {
        @Override
        public void print(String figureName) {
            System.out.println(figureName + "Blue");
        }
    }

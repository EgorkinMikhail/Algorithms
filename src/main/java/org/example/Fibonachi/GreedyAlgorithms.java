package org.example.Fibonachi;

import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithms {
    public static void main(String[] args) {
        int[] digits = {1, 3, 7, 9, 9, 5};
        System.out.println("Max volume: " + maxMNumberFromDigits(digits));

        int[] stations = {0, 200 ,375, 550, 750, 950};

        System.out.println("Minimum stops: "+ minStops(stations, 400));


    }

    public static String maxMNumberFromDigits(int[] digits) {

        return String.join("", Arrays.stream(digits).boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[] ::new));

//        Arrays.sort(digits);
//        String result = "";
//        for (int i = digits.length-1 ; i >= 0 ; i--) {
//            result = result + digits[i];
//        }
//        return result;
    }


    public static int minStops(int[] stations, int capacity) {
        int result = 0; // count of stops
        int currentStop = 0;
        int nextStop = 0;

        while (currentStop < stations.length - 1) {
            nextStop = currentStop;
            while (nextStop < stations.length - 1 // ищем следующую остановку по capacity
                    && stations[nextStop + 1] - stations[currentStop] <= capacity) {
                nextStop++;
            } // вышли из capacity по заправке

            if (currentStop == nextStop) {  // если следующая заправка слишком далеко, то никак не доедем из А в Б
                return -1;                  //  поэтому возвращаем -1
            }

            if (nextStop < stations.length - 1) { // проверяем финальную точку, если не финал - увеличиваем result
                result++;
            }
                // приравниваем currentStop и Next stop
            currentStop = nextStop;
        }

        return result;
    }
}

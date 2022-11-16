package org.example.Leetcode.HardAlgorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikeRacers {

    /*
     * Complete the bikeRacers function below.
     */
    static long bikeRacers(int[][] bikers, int[][] bikes, int k) {
        /*
         * Write your code here.
         */

        //    AB = √(xb - xa)2 + (yb - ya)2
        long[][] distanceMatrix = new long[bikers.length][bikes.length];
        long distance = 0;
        RouteMatrix minValue;
        List<RouteMatrix> matrixList = new ArrayList<>();
        List<Long> distanceOut = new ArrayList<>();

        for (int n = 0; n < bikes.length ; n++) {
            for (int i = 0; i < bikers.length; i++) {
                for (int j = 0; j < bikers[i].length; j++) {
                    distance = distance + Long.parseLong(String.valueOf(Math.round(Math.pow(bikes[i][j] - bikers[n][j], 2))));
                }
                distanceMatrix[n][i] = distance;
                matrixList.add(new RouteMatrix(n, i, distance));
                distance = 0;
            }
        }

        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix[i].length; j++) {
                System.out.print(distanceMatrix[i][j]+ "  ");
            }
            System.out.println();
        }

        matrixList.forEach(System.out::println);
        System.out.println("\n");

        for (int i = 0; i < matrixList.size(); i++) {
            minValue = matrixList.get(i);
            System.out.println("biker "+matrixList.get(i).getBiker());

            for (int j = 0; j < matrixList.size(); j++) {
                if ((matrixList.get(j).getDistance()<minValue.getDistance())&(matrixList.get(j).getBiker()==i)) {
                    minValue = matrixList.get(j);
                }
            }
            System.out.println("min value for biker i="+i+" "+minValue.getBiker()+" = "+minValue.getDistance() + " bike "+ minValue.getBike());

            distanceOut.add(minValue.getDistance());

            System.out.println("min value = "+minValue.getDistance() + " bike = " +minValue.getBike()+ " biker = " +  minValue.getBiker() +"\n") ;

//            for (int j = 0; j < matrixList.size(); j++) {
//                if (matrixList.get(j).getBike() == minValue.getBike()) {
//                    matrixList.remove(j);
//                    if (j>0) j--;
//                }
//                if (matrixList.get(j).getBiker() == minValue.getBiker()) {
//                    matrixList.remove(j);
//                    if (j>0) j--;
//                }
//            }

            matrixList.forEach(System.out::println);
            System.out.println("\n");
        }

        distanceOut.stream().sorted().forEach(System.out::println);

        return distanceOut.get(k-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int[][] bikers = new int[][] {{286, 686},{439, 775},{34, 471},{116, 512},{206, 632},{549, 365}, {961, 702},{999, 514},{81, 249},{538, 268}};


        int[][] bikes = new int[][] {{261, 789},{929, 217},{909, 187},{729, 411},{309, 147},{185, 184},{960, 947},{770, 624},{136, 346}, {979, 238}};

        long result = bikeRacers(bikers, bikes, 5);

        System.out.println("\n"+result);
    }
}

class RouteMatrix {
    private final int biker;
    private final int bike;
    private final long distance;

    public RouteMatrix(int biker, int bike, long distance) {
        this.biker = biker;
        this.bike = bike;
        this.distance = distance;
    }

    public int getBiker() {
        return biker;
    }

    public int getBike() {
        return bike;
    }

    public long getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "RouteMatrix{" +
                "biker=" + biker +
                ", bike=" + bike +
                ", distance=" + distance +
                '}';
    }
}

/*
        int[][] bikers = new int[][] {{824, 780},{212, 199},{525, 81},{493, 95},{48, 835},{915, 933}, {980, 182},{437, 548},{471, 766},{923, 236},
                {650, 905},{657, 69},{671, 660},{726, 410},{630, 222},{3, 182},{733, 454},{535, 567},{662, 610},{446, 29}
        };


        int[][] bikes = new int[][] {{314, 63},{597, 713},{261, 294},{60, 386},{622, 84},{989, 335},{404, 624},{284, 999},
                {761, 428},{650, 363},{897, 391},{845, 5},{924, 630},{240, 380},{761, 587},{2, 38},{751, 76},{370, 599},{985, 365},
                {449, 783}};
 */

package org.example.AlgorithmTasks.MediumAlgorithms.Skyline;

public class Skyline {

    public Skyline() {
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxTopBottomArray = new int[grid[0].length];
        int[] maxLeftRightArray = new int[grid.length];
        int maxValue;

        for (int i = 0; i < grid.length; i++) {
            maxValue = grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                }
            }
            maxLeftRightArray[i] = maxValue;
        }

        for (int i = 0; i < grid[0].length; i++) {
            maxValue = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                if (grid[j][i] > maxValue) {
                    maxValue = grid[j][i];
                }
            }
            maxTopBottomArray[i] = maxValue;
        }

        maxValue = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
//                System.out.println("maxTopBottomArray = " + maxTopBottomArray[j]);
//                System.out.println("maxLeftRightArray = " + maxLeftRightArray[i]);

                if (maxLeftRightArray[i] >= maxTopBottomArray[j]) {
                    maxValue = maxValue + maxTopBottomArray[j] - grid[i][j];
                } else {
                    maxValue = maxValue + maxLeftRightArray[i] - grid[i][j];
                }
            }
        }

//        System.out.println("maxTopBottomArray");
//        Arrays.stream(maxTopBottomArray).forEach(System.out::println);
//        System.out.println("maxLeftRightArray");
//        Arrays.stream(maxLeftRightArray).forEach(System.out::println);

        return maxValue;
    }
}

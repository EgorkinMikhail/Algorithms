package org.example.AlgorithmTasks.EasyAlgorithms.part3.JumpingOnClouds;

import java.util.List;

public class CloudsUtils {

    // Complete the jumpingOnClouds function below.
    public static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int elements = 0;
        boolean cycleEnd = true;

        while (cycleEnd) {

            energy = energy - (c[elements] * 2) - 1;

            if (energy <= 0) return 0;

            elements = elements + k;
            if (elements >= c.length) {
                elements = elements % c.length;
            }
            if (elements == 0) {
                cycleEnd = false;
            }
        }

        return energy;
    }


    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int minJumpCounts = 0;
        for (int i = 0; i < c.size(); i++) {
            if (i == (c.size() - 1)) return minJumpCounts;
            if (i == (c.size() - 2)) return ++minJumpCounts;
            if (c.get(i + 2).equals(0)) {
                i++;
                minJumpCounts = minJumpCounts + 1;
            } else {
                minJumpCounts = minJumpCounts + 1;
            }
        }
        return minJumpCounts;
    }
}

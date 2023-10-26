package org.example.AlgorithmTasks.EasyAlgorithms.part3.JumpingOnClouds;

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
}

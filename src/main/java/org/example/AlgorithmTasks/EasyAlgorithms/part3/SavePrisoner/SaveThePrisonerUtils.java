package org.example.AlgorithmTasks.EasyAlgorithms.part3.SavePrisoner;

public class SaveThePrisonerUtils {

    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */

    public static int saveThePrisoner(int prisoner, int candy, int start) {
        // Write your code here
        int currentPrisoner;

        if (candy >= prisoner) {
            candy = candy % prisoner;
        }

        if (candy == 0){
            if (start == 1) {
                return prisoner;
            } else {
                return start - 1;
            }
        } else {
            currentPrisoner = start + candy - 1;
        }

        return (currentPrisoner > prisoner) ? (currentPrisoner - prisoner) : currentPrisoner;
    }
}
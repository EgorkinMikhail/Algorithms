package org.example.AlgorithmTasks.EasyAlgorithms.part3.ArrayRotation;

import java.util.ArrayList;
import java.util.List;

public class Result {

    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> answerList = new ArrayList<>();
        rotateArray(a, k);

        for (Integer q: queries) {
            answerList.add(a.get(q));
        }

        return answerList;
    }
    private static List<Integer> rotateArray(List<Integer> a, int k) {
        if (k >= a.size()) {
            k = k % a.size();
        }

        if (k == 0) return a;

        for (int i = 0; i < k; i++) {
            a.add(0, a.remove(a.size() - 1));
        }

        return a;
    }

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
        // find any integer y such that p(p(y)) === x and keep a history of the values
        List<Integer> returnList = new ArrayList<>();

        for (int i = 1; i <= p.size(); i++) {
            returnList.add((p.indexOf(p.indexOf(i) + 1) + 1));
        }

        return returnList;
    }
}
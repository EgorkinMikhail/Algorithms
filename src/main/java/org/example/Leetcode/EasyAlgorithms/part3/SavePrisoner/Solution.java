package org.example.Leetcode.EasyAlgorithms.part3.SavePrisoner;

import java.io.*;
import java.util.stream.IntStream;

class Result {

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

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.saveThePrisoner(n, m, s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

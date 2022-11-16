package org.example.Leetcode.EasyAlgorithms.part3.GradingStudents;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> outGradesList = new LinkedList<>();
        // Write your code here
        for (Integer element: grades) {
            if (element < 38) {
                outGradesList.add(element);
                continue;
            }
            if (element%5==0) {
                outGradesList.add(element);
                continue;
            }

            if ((((element/5+1)*5) - element) < 3) {
                outGradesList.add((element/5+1)*5);
            } else outGradesList.add(element);
        }
        return outGradesList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        result.forEach(System.out::println);

        bufferedReader.close();
    }
}

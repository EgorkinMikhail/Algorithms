package org.example.Leetcode.MediumAlgorithms.NonDivisibleSubset;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        List<Integer> returnIntList = new ArrayList<>();
        int max = 0;
        s = s.stream().distinct().sorted().collect(Collectors.toList());

        for (int i = 0; i < s.size() - 1; i++) { // from 0 to N - 1
            returnIntList.add(s.get(i));
            for (int j = i + 1; j < s.size(); j++) { // from 1 to N

                boolean correctValue = true;
                for (Integer intElement: returnIntList) {

                    int sum = (intElement + s.get(j));
                    if ((sum % k) == 0) {
                        correctValue = false;
                    }
                }
                if (correctValue) {
                    returnIntList.add(s.get(j));
                }
            }

            if (max < returnIntList.size()) {
                max = returnIntList.size();
            }
            System.out.println(returnIntList);
            returnIntList.clear();
        }

        return max;
    }
}

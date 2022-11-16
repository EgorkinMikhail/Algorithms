package org.example.EucledianAlg;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EucledianAlgClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;

        if (in.hasNext()) {
            a = Integer.parseInt(in.nextLine());
        }
        if (in.hasNext()) {
            b = Integer.parseInt(in.nextLine());
        }

        System.out.println(calcNOD(a, b));

        if (in.hasNext()) {
            System.out.println(solution(in.nextLine()));
        }

        in.close();

    }

    public static Integer calcNOD(Integer a, Integer b) {

        while (!a.equals(0) && !b.equals(0)) {
            if (a > b) {
               a = a % b;
            } else {
                b = b % a;
            }
        }

        return a + b;
    }

    public static String solution(String S) {
        // write your code in Java SE 11
        String[] words = S.replaceAll("[^\\da-zA-Z]", " ").split(" ");

        Map<String, Integer> wordsMap = new TreeMap<>();

        // collect words to HashMap
        for (String word : words) {
            if (word.trim().length() > 0) {
                if (wordsMap.containsKey(word.toLowerCase().trim())) {
                    wordsMap.put(word, wordsMap.get(word) + 1);

                } else {
                    wordsMap.put(word, 1);
                }
            }
        }

        StringBuilder returnStringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry: wordsMap.entrySet()) {
            returnStringBuilder.append("[".concat(entry.getKey()).concat(":").concat(entry.getValue().toString()).concat("]"));
        }

        return returnStringBuilder.toString();
    }
}

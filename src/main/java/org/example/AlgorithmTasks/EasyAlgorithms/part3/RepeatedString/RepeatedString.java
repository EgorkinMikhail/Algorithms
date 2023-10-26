package org.example.AlgorithmTasks.EasyAlgorithms.part3.RepeatedString;

public class RepeatedString {
    public static long repeatedString(String s, long n) {
        // Write your code here
        if (!s.contains("a")) return 0;
        if (s.length() == 1) return n;
        int rest = (int) (n % s.length());
        long returnValue = 0;

        if (n <= s.length()) {
            return s.substring(0, (int) n).replaceAll("[^a]", "").length();
        } else {
            returnValue = s.replaceAll("[^a]", "").length();
        }

        long size = Math.floorDiv(n, s.length());

        returnValue = returnValue * size;
        returnValue += s.substring(0, rest).replaceAll("[^a]", "").length();

        return returnValue;
    }
}

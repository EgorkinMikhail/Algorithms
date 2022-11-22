package org.example.Leetcode.EasyAlgorithms.part3.UtopianTree;

import java.util.List;

public class Part3Utils {

    /*
     * Complete the 'utopianTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int utopianTree(int n) {
        // Write your code here
        int returnIntValue = 0; // 4
        if (n == 0) return 1;
        if (n > 60) return -1;
        for (int i = 0; i <= n; i++) {
            if (i%2 == 0) {
                returnIntValue = returnIntValue + 1;
            } else {
                returnIntValue = returnIntValue * 2;
            }
        }

        return returnIntValue;
    }

    public static String angryProfessor(int k, List<Integer> a) {
        // Write your code here
        for (Integer element: a) {
            if (element <= 0) {
                k--;
            }
            if (k == 0) return "NO";
        }
        return "YES";
    }

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int retValBeautifulDays = 0;
        for (int l = i; l <= j; l++) {
            if ((( l - getReverseInt(l) ) % k ) == 0) {
                retValBeautifulDays++;
            }
        }
        return retValBeautifulDays;
    }

    private static int getReverseInt(int n) {
        int digit;
        int reverseInt = 0;
        // 32809
        while (n > 0) {
            digit = n % 10; // digit = 9 // 0 // 8 // 2 // 3
            n = n / 10; // n = 3280 // 328 // 32 // 3
            reverseInt = reverseInt * 10; // 0 // 90 // 900 // 9080
            reverseInt = reverseInt + digit; // 9 // 90 // 908 // 9083
        }
        return reverseInt;
        // 90823
    }

}



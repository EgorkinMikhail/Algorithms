package org.example.SimpleArraySum;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.*;

public class SimpleArraySumClass {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
        int s = 0;
        for (int i = 0; i < ar.length; i++) {
            s = s + ar[i];
        }
        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arCount = Integer.parseInt(scanner.nextLine().trim());
//
//        int[] ar = new int[arCount];
//
//        String[] arItems = scanner.nextLine().split(" ");
//
//        for (int arItr = 0; arItr < arCount; arItr++) {
//            int arItem = Integer.parseInt(arItems[arItr].trim());
//            ar[arItr] = arItem;
//        }
        int[] ar = new int[] {1,2,3,4,10,11};
        int result = simpleArraySum(ar);
        //ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}

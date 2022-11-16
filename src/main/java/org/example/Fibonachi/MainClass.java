package org.example.Fibonachi;

import java.time.LocalDateTime;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        int n = 41;

        System.out.println(LocalDateTime.now());

        System.out.println(fiboNaive(n));

        System.out.println(LocalDateTime.now());

        System.out.println(fiboEffective(n));

        System.out.println(LocalDateTime.now());

        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        System.out.println(fiboMiddle(n, mem));

        System.out.println(LocalDateTime.now());

    }

    private static long fiboNaive(int n) {
        // bad algorithm

        if (n == 0) {return 0;}
        if (n == 1) {return 1;}
        return fiboNaive(n-1) + fiboNaive(n-2);
    }

    private static long fiboEffective(int n) {
        // fast method with array

        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    private static long fiboMiddle(int n, long[] mem) {
        // memoization method

        if (mem[n] != -1) {
            return mem[n];
        }
        if (n == 0) {return 0;}
        if (n == 1) {return 1;}

        long result =  fiboMiddle(n - 1, mem) + fiboMiddle(n - 2, mem);
        mem[n] = result;
        return result;
    }
}

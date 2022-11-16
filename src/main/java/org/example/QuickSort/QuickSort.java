package org.example.QuickSort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSortAlg(int[] A, int low, int high) {
        if (low < high) {
            int p = partition(A, low, high);
            quickSortAlg(A, low, p - 1);
            quickSortAlg(A, p + 1, high);
        }
    }
    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private static boolean less(int v, int w) {
        if (v == w) return false;
        return v<w;
    }
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int[] A = {5,4,9,1,4,0,90,11,3,2,56,12,7,6,9,44,10};
        quickSortAlg(A, 0 , A.length-1);
        System.out.println(Arrays.toString(A));
    }
}

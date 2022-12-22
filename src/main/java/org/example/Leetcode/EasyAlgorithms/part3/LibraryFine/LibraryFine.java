package org.example.Leetcode.EasyAlgorithms.part3.LibraryFine;

public class LibraryFine {
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here
        if (y1 < y2) return 0;
        if (y1 == y2) {
            if (m1 == m2) {
                if (d1 > d2) {
                    return Math.multiplyExact(15, d1 - d2);
                } else {
                    return 0;
                }
            } else {
                return (m1 > m2) ? Math.multiplyExact(500, m1 - m2) : 0;
            }
        } else {
            return 10000;
        }
    }
}

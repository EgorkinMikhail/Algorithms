package org.example.AlgorithmTasks.MediumAlgorithms.TwoStacks;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int q = 0;
        if (in.hasNext()) {
            q = Integer.parseInt(in.nextLine());
        }

        if (q > 0) {
            TwoStacksClass twoStacksClass1 = new TwoStacksClass();
            for (int i = 0; i < q; i++) {
                twoStacksClass1.start(in.nextLine());
            }

        }
        in.close();

    }
}
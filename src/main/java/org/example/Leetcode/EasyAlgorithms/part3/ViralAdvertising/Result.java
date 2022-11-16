package org.example.Leetcode.EasyAlgorithms.part3.ViralAdvertising;

class Result {

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    static int SHARES = 3;

    public static int viralAdvertising(int n) {
        int shared = 5;
        int liked = Math.floorDiv(shared, 2);
        if (n==1) return liked;

        for (int i = 2; i <= n; i++) {
            shared = Math.floorDiv(shared, 2) * SHARES;

            liked += Math.floorDiv(shared, 2);
        }

        return liked;
    }

}

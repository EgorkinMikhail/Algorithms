package org.example.AlgorithmTasks.MediumAlgorithms.MagicSquare;
import java.io.*;
import java.util.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int res;
        int temp=0;
        int maxI = 0;
        int maxJ = 0;
        int[] ninePos = new int[2];
        int[] onePos = new int[2];

        if (checkSquare(s)) return 0;

        res = checkCentre(s);
        s[1][1] = 5;

        // findNine
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (i==j) continue;
                if (((i==2)&(j==0))||((i==0)&(j==2))) continue;
                if ((i+j) % 2 > 0) {
                    if (s[i][j] > temp) {
                        if (temp<9) {
                            temp = s[i][j];
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }
        }
        if (temp<9) {
            res = res + Math.abs(9 - s[maxI][maxJ]);
            s[maxI][maxJ] = 9;
        }
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if ((i+j) % 2 > 0) {
                    if (s[i][j]==9) {
                        ninePos[0] = i;
                        ninePos[1] = j;
                        if (j==1) {
                            if (i==0) {
                                res = res + Math.abs(1 - s[i+2][j]);
                                s[i+2][j] = 1;
                                onePos[0] = i+2;
                                onePos[1] = j;
                            } else {
                                res = res + Math.abs(1 - s[i-2][j]);
                                s[i-2][j] = 1;
                                onePos[0] = i-2;
                                onePos[1] = j;
                            }

                        } else
                        if (i==1) {
                            if (j==0) {
                                res = res + Math.abs(1 - s[i][j+2]);
                                s[i][j+2] = 1;
                                onePos[0] = i;
                                onePos[1] = j+2;
                            } else {
                                res = res + Math.abs(1 - s[i][j-2]);
                                s[i][j-2] = 1;
                                onePos[0] = i;
                                onePos[1] = j-2;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
        // 1 -> 8-6
        // 9 -> 4-2
        // 1
        if ((onePos[0]==0)&(onePos[1]==1)) {
            temp = Math.abs(6-s[0][0]+6-s[0][2]);
            if (temp<Math.abs(6-s[0][0]+8-s[0][2])) {
                res = res + Math.abs(8-s[0][0]);
                s[0][0] = 8;
                res = res + Math.abs(6-s[0][2]);
                s[0][2] = 6;
            } else {
                res = res + Math.abs(8-s[0][2]);
                s[0][2] = 8;
                res = res + Math.abs(6-s[0][0]);
                s[0][0] = 6;
            }
        }
        if ((onePos[0]==1)&(onePos[1]==0)) {
            temp = Math.abs(8-s[0][0]+6-s[2][0]);
            if (temp<Math.abs(6-s[0][0]+8-s[2][0])) {
                res = res + Math.abs(8-s[0][0]);
                s[0][0] = 8;
                res = res + Math.abs(6-s[2][0]);
                s[2][0] = 6;
            } else {
                res = res + Math.abs(8-s[2][0]);
                s[2][0] = 8;
                res = res + Math.abs(6-s[0][0]);
                s[0][0] = 6;
            }
        }
        if ((onePos[0]==1)&(onePos[1]==2)) {
            temp = Math.abs(8-s[0][2]+6-s[2][2]);
            if (temp<Math.abs(6-s[0][2]+8-s[2][2])) {
                res = res + Math.abs(8-s[0][2]);
                s[0][2] = 8;
                res = res + Math.abs(6-s[2][2]);
                s[2][2] = 6;
            } else {
                res = res + Math.abs(8-s[2][2]);
                s[2][2] = 8;
                res = res + Math.abs(6-s[0][2]);
                s[0][2] = 6;
            }
        }
        if ((onePos[0]==2)&(onePos[1]==1)) {
            temp = Math.abs(8-s[2][0]+2-s[2][2]);
            if (temp<Math.abs(6-s[2][0]+8-s[2][2])) {
                res = res + Math.abs(8-s[2][0]);
                s[2][0] = 8;
                res = res + Math.abs(6-s[2][2]);
                s[2][2] = 6;
            } else {
                res = res + Math.abs(8-s[2][2]);
                s[2][2] = 8;
                res = res + Math.abs(6-s[2][0]);
                s[2][0] = 6;
            }
        }
        //9
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (s[i][j] == 8) {
                    if (i==j) {
                        if (i==0) {
                            res = res + Math.abs(2-s[2][2]);
                            s[2][2] = 2;
                        } else {
                            res = res + Math.abs(2-s[0][0]);
                            s[0][0] = 2;
                        }
                    } else {
                        if (i==0) {
                            res = res + Math.abs(2-s[2][0]);
                            s[2][0] = 2;
                        } else {
                            res = res + Math.abs(2-s[0][2]);
                            s[0][2] = 2;
                        }
                    }
                }
                if (s[i][j] == 6) {
                    if (i==j) {
                        if (i==0) {
                            res = res + Math.abs(4-s[2][2]);
                            s[2][2] = 4;
                        } else {
                            res = res + Math.abs(4-s[0][0]);
                            s[0][0] = 4;
                        }
                    } else {
                        if (i==0) {
                            res = res + Math.abs(4-s[2][0]);
                            s[2][0] = 4;
                        } else {
                            res = res + Math.abs(4-s[0][2]);
                            s[0][2] = 4;
                        }
                    }
                }
            }
        }
        // 3-7
        if ((ninePos[0]==0)&(ninePos[1]==1)) {
            if (s[0][0] == 2) {
                res = res + Math.abs(7 - s[1][0]);
                s[1][0] = 7;
                res = res + Math.abs(3 - s[1][2]);
                s[1][2] = 3;
            } else {
                res = res + Math.abs(3 - s[1][0]);
                s[1][0] = 3;
                res = res + Math.abs(7 - s[1][2]);
                s[1][2] = 7;
            }
        }

        if ((ninePos[0]==1)&(ninePos[1]==0)) {
            if (s[0][0]==2) {
                res = res + Math.abs(7 - s[0][1]);
                s[0][1] = 7;
                res = res + Math.abs(3 - s[2][1]);
                s[2][1] = 3;
            } else {
                res = res + Math.abs(3 - s[0][1]);
                s[0][1] = 3;
                res = res + Math.abs(7 - s[2][1]);
                s[2][1] = 7;
            }
        }
        if ((ninePos[0]==1)&(ninePos[1]==2)) {
            if (s[0][2]==2) {
                res = res + Math.abs(7 - s[2][1]);
                s[2][1] = 7;
                res = res + Math.abs(3 - s[0][1]);
                s[0][1] = 3;
            } else {
                res = res + Math.abs(3 - s[2][1]);
                s[2][1] = 3;
                res = res + Math.abs(7 - s[0][1]);
                s[0][1] = 7;
            }
        }
        if ((ninePos[0]==2)&(ninePos[1]==1)) {
            if (s[2][0]==2) {
                res = res + Math.abs(7-s[1][0]);
                s[1][0] = 7;
                res = res + Math.abs(3-s[1][2]);
                s[1][2] = 3;

            } else {
                res = res + Math.abs(3-s[1][0]);
                s[1][0] = 3;
                res = res + Math.abs(7-s[1][2]);
                s[1][2] = 7;
            }
        }

        if (checkSquare(s)) return res;
        return 0;
    }

    static int checkCentre(int[][] s) {
        if (s[1][1]!=5) {
            return Math.abs(s[1][1] - 5);
        }
        return 0;
    }

    static boolean checkSquare(int[][] s) {
        int d = 0;
        int v = 0;
        int h = 0;

        for (int i = 0; i < s.length; i++) {
            d = d + s[i][i];
            for (int j = 0; j < s[i].length; j++) {
                h = h + s[i][j];
                v = v + s[j][i];
            }
            if (h!=15) return false;
            if (v!=15) return false;
            h=0;
            v=0;
        }

        return d == 15;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


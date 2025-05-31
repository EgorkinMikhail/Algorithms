package org.example.AlgorithmTasks.MediumAlgorithms.MagicSquare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSquare {

  // Complete the formingMagicSquare function below.
  static int formingMagicSquare(List<List<Integer>> st) {
    int[][] s = new int[3][3];
    int[][] resultMatrix = new int[3][3];

    int a = 0;
    int b = 0;
    for (List<Integer> list : st) {
      for (Integer integer : list) {
        s[a][b] = integer;
        b++;
      }
      a++;
      b = 0;
    }
    int res;
    int temp = 0;
    int maxI = 0;
    int maxJ = 0;
    int[] ninePos = new int[2];
    int[] onePos = new int[2];

    if (checkSquare(s)) return 0;

    res = checkCentre(s);
    resultMatrix[1][1] = 5;



    System.out.println("final: ");
    printSquare(s);

    if (checkSquare(s)) return res;
    return 0;
  }

  static void printSquare(int[][] s) {
    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < s[i].length; j++) {
        System.out.print(s[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  static int checkCentre(int[][] s) {
    if (s[1][1] != 5) {
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
      if (h != 15) return false;
      if (v != 15) return false;
      h = 0;
      v = 0;
    }

    return d == 15;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<List<Integer>> s = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      String[] sRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      List<Integer> sublist = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        int sItem = Integer.parseInt(sRowItems[j]);
        sublist.add(sItem);
      }
      s.add(sublist);
    }

    int result = formingMagicSquare(s);

    System.out.print("result = ");
    System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

    scanner.close();
  }
}

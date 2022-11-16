package org.example.Leetcode.EasyAlgorithms.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.example.Leetcode.EasyAlgorithms.part2.Solution.*;

public class Start {

    public static void main(String[] args) {
//        testSubtractProductAndSum();
//        testDecompressRLElist();
//        testCreateTargetArray();
//        testPlusMinus();
//        testStaircase();
//        testBirthdayCakeCandles();
//        testTimeConversion();
//        testCompareTriplets();
//        testXorOperation();
//        testhourglassSum();
//        testGroupThePeople();
//        testDynamicArray();
//        testBalancedStringSplit();
//        testRotateLeft();
//        testAppendAndDelete();
//        testSquares();
//        testCutTheSticks();
        testStringStream();
    }
    private static void testSubtractProductAndSum() {
        System.out.println("\nstart testSubtractProductAndSum");
        System.out.println(Solution.subtractProductAndSum(234));
        System.out.println(Solution.subtractProductAndSum(4421));

    }

    private static void testDecompressRLElist() {
        System.out.println("\nstart testDecompressRLElist");
        int[] nums = new int[] { 2, 4, 2, 3, 1, 2}; //[55,11,70,26,62,64]
        nums = Solution.decompressRLElist(nums);
        Arrays.stream(nums).forEach(s->System.out.print(s + " "));
    }

    private static void testCreateTargetArray() {
        System.out.println("\nstart testDecompressRLElist");
        int[] nums = new int[] { 0,1,2,3,4};
        int[] index = new int[] { 0,1,2,2,1};
        nums = Solution.createTargetArray(nums, index);
        Arrays.stream(nums).forEach(s->System.out.print(s + " "));
    }

    private static void testPlusMinus() {
        System.out.println("\nstart testPlusMinus");
        int[] nums = new int[] { -4, 3, -9, 0, 4, 1};
        Solution.plusMinus(nums);
    }

    private static void testStaircase() {
        Solution.staircase(6);
    }

    private static void testBirthdayCakeCandles() {
        System.out.println("\nstart testBirthdayCakeCandles");
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < 99999; i++) {
            candles.add(i, 1000);
        }
        candles.add(99999, 999);

        System.out.println(Solution.birthdayCakeCandles(candles));
    }

    private static void testTimeConversion() {
        System.out.println("\nstart testTimeConversion");
        System.out.println(Solution.timeConversion("07:12:00AM"));
        System.out.println(Solution.timeConversion("07:12:30PM"));
        System.out.println(Solution.timeConversion("01:00:08PM"));
        System.out.println(Solution.timeConversion("12:40:22AM"));
        System.out.println(Solution.timeConversion("12:45:54PM"));

    }

    private static void testCompareTriplets() {
        System.out.println("\nstart testCompareTriplets");

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(5);a.add(6);a.add(7);
        b.add(3);b.add(6);b.add(10);
        a = Solution.compareTriplets(a, b);
        a.forEach(System.out::println);
    }

    private static void testXorOperation() {
        System.out.println("\nstart testXorOperation");

        System.out.println(Solution.xorOperation(5, 0));
    }

    private static void testhourglassSum() {
        System.out.println("\nstart testhourglassSum");
        int[][] nums = new int[][]
                {{-9, -9, -9,  1, 1, 1},
                 {0, -9,  0,  4, 3, 2},
                 {-9, -9, -9,  1, 2, 3},
                 {0,  0,  8,  6, 6, 0},
                 {0,  0,  0, -2, 0, 0},
                 {0,  0,  1,  2, 4, 0}};

        System.out.println(Solution.hourglassSum(nums));

        int[][] nums2 = new int[][]
        {{-1, -1, 0, -9, -2, -2},
        {-2, -1, -6, -8, -2, -5},
        {-1, -1, -1, -2, -3, -4},
        {-1, -9, -2, -4, -4, -5},
        {-7, -3, -3, -2, -9, -9},
        {-1, -3, -1, -2, -4, -5}};

        System.out.println(Solution.hourglassSum(nums2));

    }

    private static void testGroupThePeople() {
        System.out.println("\nstart testGroupThePeople");
        List<List<Integer>> resultArray = new LinkedList<>();
        int[] nums = new int[] { 3,3,3,3,3,1,3};
        resultArray = Solution.groupThePeople(nums);
        resultArray.forEach(System.out::println);
        int[] nums2 = new int[] { 2,1,3,3,3,2};
        resultArray = Solution.groupThePeople(nums2);
        resultArray.forEach(System.out::println);

    }

    private static void testDynamicArray() {
        System.out.println("\nstart testDynamicArray");

        List<List<Integer>> queries = new LinkedList<>();
        queries.add(new LinkedList<>());
        queries.add(new LinkedList<>());
        queries.add(new LinkedList<>());
        queries.add(new LinkedList<>());
        queries.add(new LinkedList<>());
        queries.get(0).add(1);
        queries.get(0).add(0);
        queries.get(0).add(5);

        queries.get(1).add(1);
        queries.get(1).add(1);
        queries.get(1).add(7);

        queries.get(2).add(1);
        queries.get(2).add(0);
        queries.get(2).add(3);

        queries.get(3).add(2);
        queries.get(3).add(1);
        queries.get(3).add(0);

        queries.get(4).add(2);
        queries.get(4).add(1);
        queries.get(4).add(1);

        List<Integer> outList = Solution.dynamicArray(2, queries);
        outList.forEach(System.out::println);

    }
    private static void testBalancedStringSplit() {
        System.out.println("\nstart testBalancedStringSplit");

        System.out.println(Solution.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(Solution.balancedStringSplit("RLRRRLLRLL"));
    }

    private static void testRotateLeft() {
        System.out.println("\nstart testRotateLeft");

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr = Solution.rotateLeft(2, arr);

    }

    private static void testAppendAndDelete() {
        System.out.println("\nStart testAppendAndDelete");

        System.out.println(appendAndDelete("qwerasdf", "qwerbsdf", 6));
        System.out.println(appendAndDelete("y", "yu", 2));
        System.out.println(appendAndDelete("aaaaaaaaaa", "aaaaa", 7));
        System.out.println(appendAndDelete("zzzzz", "zzzzzzz", 4));
        System.out.println("--");
        System.out.println(appendAndDelete("abcd", "abcdert", 10));

    }

    private static void testSquares() {
        System.out.println("\nStart testSquares");

        System.out.println(squares(3, 4));
        System.out.println(squares(17, 24));
        System.out.println(squares(2, 24));

    }

    private static void testCutTheSticks() {
        System.out.println("\nStart testCutTheSticks");
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(3);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        System.out.println(cutTheSticks(arr));
    }

    private static void testTaumBday() {
//        3 3
//        1 9 2

    }

    private static void testStringStream() {
        System.out.println(stringStream("S asdasd, 67:77 mm ASA ASD -    asd asd ss Ss fdggofdg ss sdsd SS"));
    }
}


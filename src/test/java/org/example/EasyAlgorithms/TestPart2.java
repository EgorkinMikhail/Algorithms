package org.example.EasyAlgorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.example.Leetcode.EasyAlgorithms.part2.Solution.*;

public class TestPart2 {

    @Test
    public void testSubtractProductAndSum() {
        System.out.println("test testSubtractProductAndSum");
        System.out.println(subtractProductAndSum(234));
        assert subtractProductAndSum(234) == 15;
        System.out.println(subtractProductAndSum(4421));
        assert subtractProductAndSum(4421) == 21;
    }

    @Test
    public void testDecompressRLElist() {
        System.out.println("test testDecompressRLElist");
        int[] nums = new int[]{2, 4, 2, 3, 1, 2}; //[55,11,70,26,62,64]
        nums = decompressRLElist(nums);
        Arrays.stream(nums).forEach(s -> System.out.print(s + " "));
        assert Arrays.equals(nums, new int[]{4, 4, 3, 3, 2});
    }

    @Test
    public void testCreateTargetArray() {
        System.out.println("test testDecompressRLElist");
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};
        nums = createTargetArray(nums, index);
        Arrays.stream(nums).forEach(s -> System.out.print(s + " "));
        assert Arrays.equals(nums, new int[] {0, 4, 1, 3, 2});
    }

    @Test
    public void testPlusMinus() {
        System.out.println("test testPlusMinus");
        int[] nums = new int[]{-4, 3, -9, 0, 4, 1};
        List<String> resultPlusMinusList = plusMinus(nums);
        resultPlusMinusList.forEach(System.out::println);
        assert resultPlusMinusList.get(0).equals("0.500000");
        assert resultPlusMinusList.get(1).equals("0.333333");
        assert resultPlusMinusList.get(2).equals("0.166667");
    }

    @Test
    public void testStaircase() {
        staircase(6);
    }

    @Test
    public void testBirthdayCakeCandles() {
        System.out.println("test testBirthdayCakeCandles");
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < 99999; i++) {
            candles.add(i, 1000);
        }
        candles.add(99999, 999);

        System.out.println(birthdayCakeCandles(candles));
    }

    @Test
    public void testTimeConversion() {
        System.out.println("test testTimeConversion");
        System.out.println(timeConversion("07:12:00AM"));
        System.out.println(timeConversion("07:12:30PM"));
        System.out.println(timeConversion("01:00:08PM"));
        System.out.println(timeConversion("12:40:22AM"));
        System.out.println(timeConversion("12:45:54PM"));

    }

    @Test
    public void testCompareTriplets() {
        System.out.println("test testCompareTriplets");

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(5);
        a.add(6);
        a.add(7);
        b.add(3);
        b.add(6);
        b.add(10);
        a = compareTriplets(a, b);
        a.forEach(System.out::println);
    }

    @Test
    public void testXorOperation() {
        System.out.println("test testXorOperation");

        System.out.println(xorOperation(5, 0));
    }

    @Test
    public void testhourglassSum() {
        System.out.println("test testhourglassSum");
        int[][] nums = new int[][]
                {{-9, -9, -9, 1, 1, 1},
                        {0, -9, 0, 4, 3, 2},
                        {-9, -9, -9, 1, 2, 3},
                        {0, 0, 8, 6, 6, 0},
                        {0, 0, 0, -2, 0, 0},
                        {0, 0, 1, 2, 4, 0}};

        System.out.println(hourglassSum(nums));

        int[][] nums2 = new int[][]
                {{-1, -1, 0, -9, -2, -2},
                        {-2, -1, -6, -8, -2, -5},
                        {-1, -1, -1, -2, -3, -4},
                        {-1, -9, -2, -4, -4, -5},
                        {-7, -3, -3, -2, -9, -9},
                        {-1, -3, -1, -2, -4, -5}};

        System.out.println(hourglassSum(nums2));

    }

    @Test
    public void testGroupThePeople() {
        System.out.println("test testGroupThePeople");
        List<List<Integer>> resultArray = new LinkedList<>();
        int[] nums = new int[]{3, 3, 3, 3, 3, 1, 3};
        resultArray = groupThePeople(nums);
        resultArray.forEach(System.out::println);
        int[] nums2 = new int[]{2, 1, 3, 3, 3, 2};
        resultArray = groupThePeople(nums2);
        resultArray.forEach(System.out::println);

    }

    @Test
    public void testDynamicArray() {
        System.out.println("test testDynamicArray");

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

        List<Integer> outList = dynamicArray(2, queries);
        outList.forEach(System.out::println);

    }

    @Test
    public void testBalancedStringSplit() {
        System.out.println("test testBalancedStringSplit");

        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    @Test
    public void testRotateLeft() {
        System.out.println("test testRotateLeft");

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr = rotateLeft(2, arr);

    }

    @Test
    public void testAppendAndDelete() {
        System.out.println("test testAppendAndDelete");

        System.out.println(appendAndDelete("qwerasdf", "qwerbsdf", 6));
        System.out.println(appendAndDelete("y", "yu", 2));
        System.out.println(appendAndDelete("aaaaaaaaaa", "aaaaa", 7));
        System.out.println(appendAndDelete("zzzzz", "zzzzzzz", 4));
        System.out.println("--");
        System.out.println(appendAndDelete("abcd", "abcdert", 10));

    }

    @Test
    public void testSquares() {
        System.out.println("test testSquares");

        System.out.println(squares(3, 4));
        System.out.println(squares(17, 24));
        System.out.println(squares(2, 24));

    }

    @Test
    public void testCutTheSticks() {
        System.out.println("test testCutTheSticks");
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

    @Test
    public void testStringStream() {
        System.out.println(stringStream("S asdasd, 67:77 mm ASA ASD -    asd asd ss Ss fdggofdg ss sdsd SS"));
    }
}

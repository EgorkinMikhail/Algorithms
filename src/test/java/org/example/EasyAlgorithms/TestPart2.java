package org.example.EasyAlgorithms;

import org.junit.Test;

import java.util.*;

import static org.example.Leetcode.EasyAlgorithms.part2.Solution.*;
import static org.junit.Assert.assertEquals;

public class TestPart2 {

    @Test
    public void testSubtractProductAndSum() {
        System.out.println("test testSubtractProductAndSum");
        assertEquals(15, subtractProductAndSum(234));
        assertEquals(21, subtractProductAndSum(4421));
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
        assert Arrays.equals(nums, new int[]{0, 4, 1, 3, 2});
    }

    @Test
    public void testPlusMinus() {
        System.out.println("test testPlusMinus");
        int[] nums = new int[]{-4, 3, -9, 0, 4, 1};
        List<String> resultPlusMinusList = plusMinus(nums);
        resultPlusMinusList.forEach(System.out::println);
        assertEquals("0.500000", resultPlusMinusList.get(0));
        assertEquals("0.333333", resultPlusMinusList.get(1));
        assertEquals("0.166667", resultPlusMinusList.get(2));
    }

    @Test
    public void testStairCase() {
        System.out.println("test Staircase");
        assert stairCase(6).equals(new ArrayList<>(List.of(new String[]{"     #", "    ##", "   ###", "  ####", " #####", "######"})
        ));
    }

    @Test
    public void testBirthdayCakeCandles() {
        System.out.println("test BirthdayCakeCandles");
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < 99999; i++) {
            candles.add(i, 1000);
        }

        candles.add(999);
        assertEquals(99999, birthdayCakeCandles(candles));
        candles.add(1111);
        assertEquals(1, birthdayCakeCandles(candles));
        candles.add(1111);
        assertEquals(2, birthdayCakeCandles(candles));
        candles.add(1234);
        assertEquals(1, birthdayCakeCandles(candles));

    }

    @Test
    public void testTimeConversion() {
        System.out.println("test TimeConversion");

        assertEquals("07:12:00", timeConversion("07:12:00AM"));
        assertEquals("19:12:30", timeConversion("07:12:30PM"));
        assertEquals("13:00:08", timeConversion("01:00:08PM"));
        assertEquals("00:40:22", timeConversion("12:40:22AM"));
        assertEquals("12:45:54", timeConversion("12:45:54PM"));

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
        assert a.stream().allMatch(e -> e == 1);
    }

    @Test
    public void testXorOperation() {
        System.out.println("test testXorOperation");

        assertEquals(8, xorOperation(5, 0));
    }

    @Test
    public void testHourGlassSum() {
        System.out.println("test testhourglassSum");
        int[][] nums = new int[][]
                {{-9, -9, -9, 1, 1, 1},
                        {0, -9, 0, 4, 3, 2},
                        {-9, -9, -9, 1, 2, 3},
                        {0, 0, 8, 6, 6, 0},
                        {0, 0, 0, -2, 0, 0},
                        {0, 0, 1, 2, 4, 0}};

        assertEquals(28, hourGlassSum(nums));

        int[][] nums2 = new int[][]
                {{-1, -1, 0, -9, -2, -2},
                        {-2, -1, -6, -8, -2, -5},
                        {-1, -1, -1, -2, -3, -4},
                        {-1, -9, -2, -4, -4, -5},
                        {-7, -3, -3, -2, -9, -9},
                        {-1, -3, -1, -2, -4, -5}};

        assertEquals(-6, hourGlassSum(nums2));

    }

    @Test
    public void testGroupThePeople() {
        System.out.println("test testGroupThePeople");
        int[] nums = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> resultArray = groupThePeople(nums);
        resultArray.forEach(System.out::println);
        assertEquals(3, resultArray.size());
        assertEquals(1, resultArray.get(0).size());
        assertEquals(3, resultArray.get(1).size());
        assertEquals(3, resultArray.get(2).size());

        int[] nums2 = new int[]{2, 1, 3, 3, 3, 2};
        resultArray = groupThePeople(nums2);
        resultArray.forEach(System.out::println);
        assertEquals(3, resultArray.size());
        assertEquals(1, resultArray.get(0).size());
        assertEquals(2, resultArray.get(1).size());
        assertEquals(3, resultArray.get(2).size());

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
        assert outList.equals(new ArrayList<>(List.of(7, 3)));

    }

    @Test
    public void testBalancedStringSplit() {
        System.out.println("test testBalancedStringSplit");
        int outInt = balancedStringSplit("RLRRLLRLRL");
        System.out.println(outInt);
        assertEquals(4, outInt);
        outInt = balancedStringSplit("RLRRRLLRLL");
        System.out.println(outInt);
        assertEquals(2, outInt);
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
        arr.forEach(System.out::println);
        assert arr.equals(new ArrayList<>(List.of(3, 4, 5, 1, 2)));
    }

    @Test
    public void testAppendAndDelete() {
        System.out.println("test testAppendAndDelete");
        String YES = "Yes";
        String NO = "No";
        assertEquals(NO, appendAndDelete("qwerasdf", "qwerbsdf", 6));
        assertEquals(NO, appendAndDelete("y", "yu", 2));
        assertEquals(YES, appendAndDelete("aaaaaaaaaa", "aaaaa", 7));
        assertEquals(YES, appendAndDelete("zzzzz", "zzzzzzz", 4));
        assertEquals(NO, appendAndDelete("abcd", "abcdert", 10));

    }

    @Test
    public void testSquares() {
        System.out.println("test testSquares");

        assertEquals(1, squares(3, 4));
        assertEquals(0, squares(17, 24));
        assertEquals(3, squares(2, 24));

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
        assert cutTheSticks(arr).equals(new ArrayList<>(List.of(9, 6, 4, 1)));

    }

    @Test
    public void testStringStream() {
        String retString = "[ASA:1][ASD:3][asdasd:1][fdggofdg:1][mm:1][S:1][sdsd:1][ss:4]";
        assertEquals(retString, stringStream("S asdasd, 67:77 mm ASA ASD -    asd asd ss Ss fdggofdg ss sdsd SS"));
    }
}

package org.example.EasyAlgorithms;

import org.example.Leetcode.EasyAlgorithms.part1.Solution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPart1 {
    Solution solution = new Solution();

    @Test
    public void testRunningSum() {
        System.out.println("start runningSumStart");
        int[] nums = new int[]{1, 1, 1, 1};
        int[] numsOut = solution.runningSum(nums);
        Arrays.stream(numsOut).forEach(s -> System.out.print(s + " "));
        assert Arrays.equals(numsOut, new int[]{1, 2, 3, 4});
    }

    @Test
    public void testSuffleStart() {
        System.out.println("test suffleStart");
        int[] nums = new int[]{2, 6, 1, 3, 8, 3, 5, 7, 1, 4};
        int[] numsOut = solution.shuffle(nums, nums.length / 2);
        Arrays.stream(numsOut).forEach(s -> System.out.print(s + " "));
        assert Arrays.equals(numsOut, new int[]{2, 3, 6, 5, 1, 7, 3, 1, 8, 4});

    }

    @Test
    public void testKidsWithCandies() {
        System.out.println("test startKidsWithCandies");
        int[] nums = new int[]{2, 3, 5, 1, 3};
        List<Boolean> result = solution.kidsWithCandies(nums, 3);
        result.forEach(System.out::println);
        List<Boolean> rightAnswers = new ArrayList<>();
        rightAnswers.add(true);
        rightAnswers.add(true);
        rightAnswers.add(true);
        rightAnswers.add(false);
        rightAnswers.add(true);
        assert result.equals(rightAnswers);
    }

    @Test
    public void testDefangIPaddr() {
        System.out.println("test startDefangIPaddr");
        System.out.println(solution.defangIPaddr("1.1.1.1"));
        assert solution.defangIPaddr("1.1.1.1").equals("1[.]1[.]1[.]1");
    }

    @Test
    public void testRestoreString() {
        System.out.println("test startRestoreString");
        int[] nums = {3, 1, 4, 2, 0};
        System.out.println(solution.restoreString("aiohn", nums));
        assert solution.restoreString("aiohn", nums).equals("nihao");
        System.out.println(solution.restoreString2("aiohn", nums));
        assert solution.restoreString2("aiohn", nums).equals("nihao");
    }

    @Test
    public void testNumJewelsInStones() {
        System.out.println("test startNumJewelsInStones");
        System.out.println(solution.numJewelsInStones("aA", "aAAbbb"));
        assert solution.numJewelsInStones("aA", "aAAbbb") == 3;
        System.out.println(solution.numJewelsInStones("Z", "zzzzz"));
        assert solution.numJewelsInStones("Z", "zzzzz") == 0;
    }

    @Test
    public void testNNumberOfSteps() {
        System.out.println("test startnNumberOfSteps");
        System.out.println(solution.numberOfSteps(14));
        assert solution.numberOfSteps(14) == 6;
        System.out.println(solution.numberOfSteps(8));
        assert solution.numberOfSteps(8) == 4;
        System.out.println(solution.numberOfSteps(123));
        assert solution.numberOfSteps(123) == 12;
    }

    @Test
    public void startSmallerNumbersThanCurrent() {
        System.out.println("test startSmallerNumbersThanCurrent");
        int[] nums = new int[]{8, 1, 2, 2, 3};
        int[] numsOut = solution.smallerNumbersThanCurrent(nums);
        Arrays.stream(numsOut).forEach(s -> System.out.print(s + " "));
        assert Arrays.equals(numsOut, new int[]{4, 0, 1, 1, 3});
    }
}

package org.example.Leetcode.EasyAlgorithms.part1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        addTwoNumbersStart();
        runningSumStart();
        suffleStart();
        startKidsWithCandies();
        startDefangIPaddr();
        startRestoreString();
        startNumJewelsInStones();
        startnNumberOfSteps();
        startSmallerNumbersThanCurrent();
    }

    protected static void addTwoNumbersStart() {
        System.out.println("\nstart addTwoNumbersStart");
    }

    protected static void runningSumStart() {
        System.out.println("\nstart runningSumStart");
        int[] nums = new int[] { 1, 1, 1, 1};
        Solution solution = new Solution();
        int[] numsOut = solution.runningSum(nums);
        Arrays.stream(numsOut).forEach(s->System.out.print(s + " "));
    }

    protected static void suffleStart() {
        System.out.println("\nstart suffleStart");
        int[] nums = new int[] { 2, 6, 1, 3, 8, 3, 5, 7, 1, 4};
        Solution solution = new Solution();
        int[] numsOut = solution.shuffle(nums, nums.length/2);
        Arrays.stream(numsOut).forEach(s->System.out.print(s + " "));
        // 2 3 6 5 1 7 3 1 8 4
    }

    protected static void startKidsWithCandies() {
        System.out.println("\nstart startKidsWithCandies");
        int[] nums = new int[] { 2, 3, 5, 1, 3};
        Solution solution = new Solution();
        List<Boolean> result = solution.kidsWithCandies(nums, 3);
        result.stream().forEach(System.out::println);
    }

    private static void startDefangIPaddr() {
        System.out.println("\nstart startDefangIPaddr");
        Solution solution = new Solution();
        System.out.println(solution.defangIPaddr("1.1.1.1"));
    }

    private static void startRestoreString() {
        System.out.println("\nstart startRestoreString");
        int[] nums = {3, 1, 4, 2, 0};
        Solution solution = new Solution();
        System.out.println(solution.restoreString("aiohn", nums));
        System.out.println(solution.restoreString2("aiohn", nums));
    }

    private static void startNumJewelsInStones() {
        System.out.println("\nstart startNumJewelsInStones");
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones("aA", "aAAbbb"));
        System.out.println(solution.numJewelsInStones("Z", "zzzzz"));
    }

    private static void startnNumberOfSteps() {
        System.out.println("\nstart startnNumberOfSteps");
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(14));
        System.out.println(solution.numberOfSteps(8));
        System.out.println(solution.numberOfSteps(123));
    }

    private static void startSmallerNumbersThanCurrent() {
        System.out.println("\nstart startSmallerNumbersThanCurrent");
        int[] nums = new int[] {8,1,2,2,3};
        Solution solution = new Solution();
        int[] numsOut = solution.smallerNumbersThanCurrent(nums);
        Arrays.stream(numsOut).forEach(s->System.out.print(s + " "));
    }
 }

package org.example.Leetcode.EasyAlgorithms.part1;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return l1;
    }

    public int[] runningSum(int[] nums) {
        int[] numsOut = new int[nums.length];
        numsOut[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            numsOut[i] = numsOut[i - 1] + nums[i];
        }
        return numsOut;
    }

    public int[] shuffle(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                nums[j] = nums[j] + nums[j+n-i];
                nums[j+n-i] =  nums[j] - nums[j+n-i];
                nums[j] = nums[j] - nums[j+n-i];
            }
        }
        return nums;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candyCount: candies
             ) {
            if (maxCandies < candyCount) {
                maxCandies = candyCount;
            }
        }
        List<Boolean> resultList = new ArrayList<>();
        for (int candyCount: candies
        ) {
            resultList.add((candyCount+extraCandies)>=maxCandies);
        }
        return resultList;
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public String restoreString(String s, int[] indices) {
        char[] charArrayOfS = s.toCharArray();
        Map<Integer, Character> map = new LinkedHashMap<>();
        List<String> sOutList = new ArrayList<>();

        for (int i = 0; i <= indices.length-1; i++) {
            map.put(indices[i], charArrayOfS[i]);
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(s1->sOutList.add(s1.getValue().toString()));

        String sOutString = "";
        for (String str: sOutList) {
            sOutString = sOutString.concat(str);
        }
        return sOutString;
    }

    public String restoreString2(String s, int[] indices) {
        char[] charArrayOfS = s.toCharArray();
        String outString = "";
        for (int i = 0; i < indices.length; i++) {
            outString = outString.concat(String.valueOf(charArrayOfS[findIndex(indices, i)]));
        }
        return outString;
    }
    private int findIndex(int[] numbers, int find) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == find) {
                return i;
            }
        }
        return -1;
    }

    public int numJewelsInStones(String J, String S) {
        int countOfJewelsInStones = 0;
        char[] jewelsChars = J.toCharArray();
        char[] stonesChars = S.toCharArray();
        for (char stone: stonesChars) {
            for (char jewel: jewelsChars) {
                if (stone == jewel) {
                    countOfJewelsInStones++;
                }
            }
        }
        return countOfJewelsInStones;
    }

    public int numberOfSteps (int num) {
        if (num <= 0) return 0;
        int stepsCount = 0;
        while (num>0) {
            if (num%2==0) {
                num = num/2;
            } else {
                num--;
            }
            stepsCount++;
        }
        return stepsCount;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsOut = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if (i==j) continue;
                if (nums[i]>nums[j]) {
                    numsOut[i] = numsOut[i]+1;
                }
            }
        }
        return numsOut;
    }
}
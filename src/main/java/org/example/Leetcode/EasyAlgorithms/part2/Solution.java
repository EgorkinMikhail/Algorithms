package org.example.Leetcode.EasyAlgorithms.part2;

import java.util.*;
import java.util.List;

public class Solution {

    public static int subtractProductAndSum(int n) {
        String stringNumber = String.valueOf(n);
        String stringNumberSymbol = "";
        if (n<=0) return 0;

        int out = 1;
        for (int i = 0; i < stringNumber.length(); i++) {
            stringNumberSymbol = stringNumber.substring(i, i+1);
            out = out * Integer.parseInt(stringNumberSymbol);
        }
        for (int i = 0; i < stringNumber.length(); i++) {
            stringNumberSymbol = stringNumber.substring(i, i+1);
            out = out - Integer.parseInt(stringNumberSymbol);
        }
        return out;
    }

    public static int[] decompressRLElist(int[] nums) {
        int[] numsOut = new int[calcNumsOutSize(nums)];
        int countOfAllElements = 0;
        int countOfCurrentElement;
        for (int i = 0; i < nums.length; i=i+2) {
            countOfCurrentElement = 0;
            for (int j = countOfAllElements; j < nums[i]+countOfAllElements ; j++) {
                numsOut[j] = nums[i+1];
                countOfCurrentElement++;
            }
            countOfAllElements = countOfAllElements + countOfCurrentElement;
        }
        return numsOut;
    }

    private static int calcNumsOutSize(int[] nums) {
        int sizeForOutNums = 0;

        for (int i = 0; i < nums.length; i=i+2) {
            sizeForOutNums = sizeForOutNums + nums[i];
        }
        return sizeForOutNums;
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] outNums = new int[nums.length];
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < index.length; i++) {
            outNums[i] = list.get(i);
        }
        return outNums;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sumOfFirstDiagonal = 0;
        int sumOfSecondDiagonal = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i==j) {
                    sumOfFirstDiagonal = sumOfFirstDiagonal + arr.get(i).get(j);
                }
                if ((arr.get(i).size()-1-j)==i)
                {
                    sumOfSecondDiagonal = sumOfSecondDiagonal + arr.get(i).get(j);
                }
            }
        }
        return Math.abs(sumOfFirstDiagonal - sumOfSecondDiagonal);
    }

    // Complete the plusMinus function below.
    public static List<String> plusMinus(int[] arr) {
        double countOfPositiveElements = 0;
        double countOfNegativeElements = 0;
        double countOfZeroElements = 0;
        List<String> returnList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0){
                countOfPositiveElements++;
            }
            if (arr[i] < 0){
                countOfNegativeElements++;
            }
            if (arr[i] == 0){
                countOfZeroElements++;
            }
        }
        returnList.add(String.format("%.6f",countOfPositiveElements/arr.length));
        returnList.add(String.format("%.6f",countOfNegativeElements/arr.length));
        returnList.add(String.format("%.6f",countOfZeroElements/arr.length));

        return returnList;
    }

    // Complete the staircase function below.
    public static void staircase(int n) {
        char CASE_ELEMENT = '#';

        char[] spacesChar = new char[n];
        for (int i = 0; i < n; i++) {
            spacesChar[i] = ' ';
        }

        for(int i = 0; i < n; i++) {
            spacesChar[n-i-1] = CASE_ELEMENT;
            System.out.println(String.valueOf(spacesChar));
        }
    }

    static void miniMaxSum(int[] arr) {
        long minSumOfArray = 0;
        long maxSumOfArray = 0;
        long sumOfArray;

        for (int i = 1; i < arr.length; i++) {
            minSumOfArray = minSumOfArray + arr[i];
            maxSumOfArray = maxSumOfArray + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            sumOfArray = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                sumOfArray = sumOfArray + arr[j];
            }
            if (sumOfArray > maxSumOfArray) {
                maxSumOfArray = sumOfArray;
            }
            if (sumOfArray < minSumOfArray) {
                minSumOfArray = sumOfArray;
            }
        }
        System.out.println(minSumOfArray+" "+maxSumOfArray);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Optional<Integer> i = candles.stream().max(Integer::compareTo);
        return Integer.parseInt(String.valueOf(candles.stream().filter(element -> element.equals(i.get())).count()));
    }

    public static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int timeMilitaryDiff;
        timeMilitaryDiff = Integer.parseInt(s.substring(0, 2));
        timeMilitaryDiff = timeMilitaryDiff + 12;

        if (s.contains("AM")) {
            if (s.startsWith("12")) {
                return "00".concat(s.substring(2, s.indexOf("A")));
            }
            return s.substring(0, s.indexOf("A"));
        }
        if (s.contains("PM")) {
            if (!s.startsWith("12")) {
                return String.valueOf(timeMilitaryDiff).concat(s.substring(2, s.indexOf("P")));
            }
            return s.substring(0, s.indexOf("P"));
        }
        return s;
    }

    // Complete the compareTriplets function below.
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> outList = new ArrayList<>();
        outList.add(0);
        outList.add(0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                outList.set(0, outList.get(0)+1);
            }
            if (a.get(i) < b.get(i)) {
                outList.set(1, outList.get(1)+1);
            }
        }
        return outList;
    }

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int nOut;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2*i;
        }

        nOut = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nOut = nOut^nums[i];
        }
        return nOut;
    }

    // Complete the hourglassSum function below.
    public static int hourglassSum(int[][] arr) {
        int[][] pattern = new int[][] {{1, 1, 1},
                                       {0, 1, 0},
                                       {1, 1, 1}};
        int sum = 0;
        int patternRowIndex = 0;
        int patternColumnIndex;
        int maxValue = 0;



        for (int i = 0; i < arr.length-2; i++) {
            for (int j = 0; j < arr.length-2; j++) {
                for (int k = i; k <= 2 + i; k++) {
                    patternColumnIndex = 0;
                    for (int m = j; m <= 2 + j; m++) {
                        if (pattern[patternRowIndex][patternColumnIndex] == 1) {
                            sum = sum + arr[k][m];
                        }
                        patternColumnIndex++;
                    }
                    patternRowIndex++;
                }
                if ((i==0)&(j==0)) maxValue = sum;
                //System.out.println("sum = "+sum);
                if (sum > maxValue) maxValue = sum;
                sum = 0;
                patternRowIndex = 0;
            }

        }

        return maxValue;
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Set<Integer> distinctArrayGroupSet = new HashSet<>();
        int groupIndex = 0;
        List<List<Integer>> resultArray = new LinkedList<>();

        for (int groupSize : groupSizes) {
            distinctArrayGroupSet.add(groupSize);
        }

        resultArray.add(new LinkedList<>());

        for (int group: distinctArrayGroupSet) {
            for (int j = 0; j < groupSizes.length; j++) {
                if (groupSizes[j]==group) {
                    resultArray.get(groupIndex).add(j);
                    if (resultArray.get(groupIndex).size()==group) {
                        resultArray.add(new LinkedList<>());
                        groupIndex++;
                    }
                }
            }
        }

        resultArray.remove(resultArray.size()-1);

        return resultArray;
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> seqList = new ArrayList<>();
        int lastAnswer = 0;
        List<Integer> lastAnswerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).get(0)==1) {
                seqList.get((queries.get(i).get(1)^lastAnswer) % n).add(queries.get(i).get(2));
            } else {
                lastAnswer = seqList.get((queries.get(i).get(1) ^ lastAnswer) % n).get(queries.get(i).get(2) % seqList.get((queries.get(i).get(1) ^ lastAnswer) % n).size());
                lastAnswerList.add(lastAnswer);
            }
        }
        return lastAnswerList;
    }

    public static int balancedStringSplit(String s) {
        char[] sChars = s.toCharArray();

        int result = 0;
        int balanceCount = 0;

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == 'L') {
                balanceCount++;
            } else {
                balanceCount--;
            }
            if (balanceCount==0) {
                result++;
            }
        }

        return result;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> rotatedArr = new ArrayList<>();

        for (int i = d; i < arr.size(); i++) {
            rotatedArr.add(arr.get(i));
        }
        for (int i = 0; i < d; i++) {
            rotatedArr.add(arr.get(i));
        }

        rotatedArr.forEach(System.out::println);

        return rotatedArr;
    }

    public static int[] matchingStrings(String[] strings, String[] queries) {
        int[] resultArr = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])) {
                    resultArr[i] = resultArr[i] + 1;
                }
            }
        }
        return resultArr;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        Integer maxA;
        Integer minB;
        int totalX = 0;
        maxA = a.stream().max(Integer::compareTo).get();
        minB = b.stream().min(Integer::compareTo).get();
        for (int i = maxA; i < minB; i++) {
            if (getFactor(i, a, b)) totalX++;
        }

        return totalX;
    }
    private static boolean getFactor(Integer i, List<Integer> a, List<Integer> b) {
        for (Integer element: a) {
            if (i%element!=0) return false;
        }
        for (Integer element: b) {
            if (element%i!=0) return false;
        }

        return true;
    }

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birdTreeMap = new TreeMap<>();

        for (Integer element: arr) {
            if (birdTreeMap.containsKey(element)) {
                birdTreeMap.put(element, birdTreeMap.get(element)+1);
            } else {
                birdTreeMap.put(element, 1);
            }
        }


//        List<Integer> countAr = new LinkedList<>();
//        int sum = 0;
//        birdTreeMap.entrySet().stream().filter(o1->o1.getValue()>1).forEach(o1-> countAr.add(o1.getValue()/2));
//        for (Integer element: countAr) {
//            sum = sum + element;
//        }

        Map.Entry<Integer, Integer> mapOutList = birdTreeMap.entrySet().stream().max((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            }
            if (o1.getValue() < o2.getValue()) return 1;
            else {
                return 0;
            }
        }).get();

        System.out.println(mapOutList);

        return mapOutList.getKey();
    }

    public int findUniqueChar(String s) {
        char[] chars = s.toCharArray();
        boolean uniqueChar = false;

        for (int i = 0; i < chars.length-1; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    uniqueChar = false;
                    break;
                } else {
                    uniqueChar = true;
                }
            }
            if (uniqueChar) return i;
        }

        return -1;
    }

    public static int findDigits(int n) {
        // Write your code here
        String[] charArray = String.valueOf(n).replaceAll("0", "").split("");
        int returnInt = 0;

        for (String s : charArray) {
            if ((n % Integer.parseInt(s)) == 0) {
                returnInt++;
            }
        }
        return returnInt;
    }

    public static String appendAndDelete(String initialString, String desiredString, int k) {
        // Write your code here
        final String YES = "Yes";
        final String NO = "No";
        if (initialString.equals(desiredString)) return YES;
        boolean inclusive = true;
        for (int i = 1; i <= (Math.min(initialString.length(), desiredString.length())); i++) {
            if (!initialString.startsWith(desiredString.substring(0, i))) {
                k = k - initialString.substring(i - 1).length() - desiredString.substring(i - 1).length();
                inclusive = false;
                break;
            }
        }

        if (inclusive) {
            if (initialString.length() > desiredString.length()) {
                k = k - initialString.substring(desiredString.length()).length();
                return (k < 0) ? NO : YES;
            }
            else {
                int l = desiredString.length() - initialString.length();
                if (k < l) return NO;
                if ((k % 2 == 0) && (l % 2 == 0)) return YES; else return NO;
            }
        } else {
            return (k < 0) ? NO : YES;
        }
    }

    public static int squares(int a, int b) {
        // Write your code here
        double x = Math.floor(Math.sqrt(a));
        int returnVal = 0;

        if (Math.pow(x, 2) < a) { x++;}

        while (Math.pow(x, 2) <= b)  {
            x++;
            returnVal++;
        }

        return returnVal;
    }

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> returnList = new ArrayList<>();
        long distinctCount = arr.stream().distinct().count();

        for (int i = 0; i < distinctCount; i++) {
            returnList.add(arr.size());
            arr.removeAll(arr.stream().min(Integer::compareTo).stream().toList());
        }

        return returnList;
    }

    public static long taumBday(int bc, int wc, int b, int w, int z) {

        long minSum = 0;
        if (b == w) {
            minSum = ((long) b * bc);
            minSum = minSum + ((long) w * wc);
        }
        if (b < w) {
            minSum = ((long) b * bc);
            if ((b + z) < w) {
                minSum = minSum + ((long) (b + z) * wc);
            } else {
                minSum = minSum + ((long) w * wc);
            }
        }
        if (w < b) {
            minSum = ((long) w * wc);
            if ((w + z) < b) {
                minSum = minSum + ((long) (w + z) * bc);
            } else {
                minSum = minSum + ((long) b * bc);
            }
        }
        return minSum;
    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        final String IMPOSSIBLE = "Impossible";
        final String POSSIBLE = "Possible";

        for (Integer line: container.get(1)) {
//
        }

        return "null";
    }

    public static String stringStream(String S) {
        String[] words = S.replaceAll("[^a-zA-Z]", " ").split(" ");

        Map<String, Integer> wordsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for (String word : words) {
            if (word.trim().length() > 0) {
                wordsMap.compute(word, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        StringBuilder returnString = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            returnString.append("[");
            returnString.append(entry.getKey());
            returnString.append(":");
            returnString.append(entry.getValue().toString());
            returnString.append("]");
        }

        return returnString.toString();
    }


}

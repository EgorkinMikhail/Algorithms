package org.example.Leetcode.EasyAlgorithms.part3.Stackparcer;

import java.util.*;
import java.util.Scanner;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser {
    public boolean isBalanced(String s) {
        char[] sCharArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Character tempStr;

        for (char c : sCharArray) {

            if (isOpen(c)) {
                stack.push(c);
            }

            if (isClose(c)) {
                if (!stack.empty()) {
                    tempStr = stack.pop();
                    if (c == '}') {
                        if (!tempStr.equals('{')) {
                            return false;
                        }
                    }
                    if (c == ')') {
                        if (!tempStr.equals('(')) {
                            return false;
                        }
                    }
                } else return false;
            }
        }
        return stack.empty();
    }

    private boolean isOpen(char charElement) {
        return charElement == '{' || charElement == '(';
    }

    private boolean isClose(char charElement) {
        return charElement == '}' || charElement == ')';
    }
}
class Solution {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();

    }
}

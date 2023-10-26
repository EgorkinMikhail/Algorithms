package org.example.AlgorithmTasks.EasyAlgorithms.part3.Stackparcer;

import java.util.Stack;

// Write your code here. DO NOT use an access modifier in your class declaration.
public class ParserUtils {
    public static boolean isBalanced(String s) {
        // empty
        // null
        // doesn't contain brackets

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

    private static boolean isOpen(char charElement) {
        return charElement == '{' || charElement == '(';
    }

    private static boolean isClose(char charElement) {
        return charElement == '}' || charElement == ')';
    }
}
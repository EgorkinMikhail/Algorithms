package org.example.AlgorithmTasks.EasyAlgorithms.part3.DesignerPdfViewer;

import java.util.HashMap;
import java.util.List;

public class DesignerPdfViewer {
    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */
    static HashMap<Character, Integer> alphabetHeightMap = new HashMap<>();
    public static int designerPdfViewer(List<Integer> h, String word) {
        alphabetHeightMap.clear();
        fillAlphabetHeightMap(h);
        word = word.replaceAll("[^a-z]", "");

        char[] charList = word.toCharArray();
        int maxH = 0;

        for (int i = 0; i < charList.length; i++) {
            if (maxH < alphabetHeightMap.get(charList[i])) {
                maxH = alphabetHeightMap.get(charList[i]);
            }
        }
        return maxH * word.length();
    }

    private static void fillAlphabetHeightMap(List<Integer> h) {
        int hElement = 0;

        for(char i = 'a'; i <= 'z'; i++)
        {
            alphabetHeightMap.put(i, h.get(hElement));
            hElement++;
        }
    }
}


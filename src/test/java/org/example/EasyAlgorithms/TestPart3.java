package org.example.EasyAlgorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.Leetcode.EasyAlgorithms.part3.ArrayRotation.Result.circularArrayRotation;
import static org.example.Leetcode.EasyAlgorithms.part3.ArrayRotation.Result.permutationEquation;
import static org.example.Leetcode.EasyAlgorithms.part3.DesignerPdfViewer.DesignerPdfViewer.designerPdfViewer;
import static org.example.Leetcode.EasyAlgorithms.part3.GradingStudents.StudentsAndGradesUtil.gradingStudents;

public class TestPart3 {

    @Test
    public void testCircularArrayRotation() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        int k = 3;
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(3);
        queries.add(5);

        assert circularArrayRotation(a, k, queries).equals(new ArrayList<>(List.of(8, 1, 3)));
    }

    @Test
    public void testPermutationEquation() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(4);
        integerList.add(1);
        integerList.add(7);
        integerList.add(2);
        integerList.add(8);
        integerList.add(9);
        integerList.add(5);
        integerList.add(6);

        assert permutationEquation(integerList).equals(new ArrayList<>(List.of(1, 8, 3, 5, 6, 7, 2, 9, 4)));

    }

    @Test
    public void testDesignerPdfViewer() {
        List<Integer> highList = new ArrayList<>();
        highList.add(3);// a
        highList.add(5);// b
        highList.add(3);// c
        highList.add(5);// d
        highList.add(3);// e
        highList.add(5);// f
        highList.add(5);// g
        highList.add(5);// h
        highList.add(3);// i
        highList.add(5);// j
        highList.add(4);// k
        highList.add(5);// l
        highList.add(3);// m
        highList.add(3);// n
        highList.add(3);// o
        highList.add(5);// p
        highList.add(5);// q
        highList.add(3);// r
        highList.add(3);// s
        highList.add(6);// t
        highList.add(3);// u
        highList.add(3);// v
        highList.add(3);// w
        highList.add(3);// x
        highList.add(3);// y
        highList.add(3);// z

        assert designerPdfViewer(highList, "this words @@ with spaces and digits") == 168;
        assert designerPdfViewer(highList, "correct") == 42;
    }

    @Test
    public void testGradingStudents() {
        List<Integer> gradeList = new ArrayList<>();
        gradeList.add(38);
        gradeList.add(25);
        gradeList.add(7);
        gradeList.add(58);
        gradeList.add(45);
        gradeList.add(73);
        assert gradingStudents(gradeList).equals(new ArrayList<>(List.of(40, 25, 7, 60, 45, 75)));
    }
}

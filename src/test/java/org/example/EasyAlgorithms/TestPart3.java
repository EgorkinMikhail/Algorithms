package org.example.EasyAlgorithms;

import org.example.Leetcode.EasyAlgorithms.part3.LinkedListCycle.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.Leetcode.EasyAlgorithms.part3.ArrayRotation.Result.circularArrayRotation;
import static org.example.Leetcode.EasyAlgorithms.part3.ArrayRotation.Result.permutationEquation;
import static org.example.Leetcode.EasyAlgorithms.part3.DesignerPdfViewer.DesignerPdfViewer.designerPdfViewer;
import static org.example.Leetcode.EasyAlgorithms.part3.GradingStudents.StudentsAndGradesUtil.gradingStudents;
import static org.example.Leetcode.EasyAlgorithms.part3.JumpingOnClouds.CloudsUtils.jumpingOnClouds;
import static org.example.Leetcode.EasyAlgorithms.part3.LinkedListCycle.NodeCycleUtil.hasCycle;
import static org.example.Leetcode.EasyAlgorithms.part3.SavePrisoner.SaveThePrisonerUtils.saveThePrisoner;
import static org.example.Leetcode.EasyAlgorithms.part3.Stackparcer.ParserUtils.isBalanced;
import static org.example.Leetcode.EasyAlgorithms.part3.UtopianTree.Part3Utils.*;
import static org.example.Leetcode.EasyAlgorithms.part3.ViralAdvertising.ViralAdvertisingUtils.viralAdvertising;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


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

        assertEquals(168, designerPdfViewer(highList, "this words @@ with spaces and digits"));
        assertEquals(42, designerPdfViewer(highList, "correct"));
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

    @Test
    public void testJumpingOnClouds() {

        int returnCycles = jumpingOnClouds(new int[]{1, 3, 4, 6, 7, 8}, 3);
        System.out.println(returnCycles);
        assertEquals(84, returnCycles);

        returnCycles = jumpingOnClouds(new int[]{2, 4, 2, 3}, 2);
        System.out.println(returnCycles);
        assertEquals(90, returnCycles);

    }

    @Test
    public void testHasCycle() {
        ListNode headListNode = new ListNode(1);
        ListNode secondLevelListNode = new ListNode(2);
        headListNode.setNext(secondLevelListNode);
        ListNode thirdLevelListNode = new ListNode(3);
        secondLevelListNode.setNext(thirdLevelListNode);
        ListNode fourthLevelListNode = new ListNode(4);
        thirdLevelListNode.setNext(fourthLevelListNode);
        fourthLevelListNode.setNext(headListNode); // create cycle
        ListNode fifthLevelListNode = new ListNode(5); // unusable Node
        assertTrue(hasCycle(headListNode));

        fourthLevelListNode.setNext(fifthLevelListNode); // delete cycle
        assertFalse(hasCycle(headListNode));

    }

    @Test
    public void testSaveThePrisoner() {
        assertEquals(saveThePrisoner(10, 2, 3), 4);
        assertEquals(saveThePrisoner(11, 30, 7), 3);
        assertEquals(saveThePrisoner(12, 123, 10), 12);
        assertEquals(saveThePrisoner(13, 23, 5), 1);
        assertEquals(saveThePrisoner(13023, 2323231, 342), 5478);
    }

    @Test
    public void testIsBalanced() {
        assertTrue(isBalanced("{}{}{}{}{}{}"));
        assertTrue(isBalanced("(({{}}{({(({}))})}))"));
        assertTrue(isBalanced("{}()"));
        assertTrue(isBalanced("((()){}(){()}(()))"));

        assertFalse(isBalanced("(({}({}{(}{)}){}{}))"));
        assertFalse(isBalanced("{()({}{())}})}"));
    }

    @Test
    public void testUtopianTree() {
        assertEquals(utopianTree(60), 2147483647);
        assertEquals(utopianTree(0), 1);
        assertEquals(utopianTree(100), -1);
        assertEquals(utopianTree(34), 262143);

    }

    @Test
    public void testAngryProfessor() {
        final String YES = "YES";
        final String NO = "NO";
        List<Integer> minutesAfterStartList = new ArrayList<>();
        minutesAfterStartList.add(13);
        minutesAfterStartList.add(10);
        minutesAfterStartList.add(-20);
        minutesAfterStartList.add(1);
        minutesAfterStartList.add(34);
        minutesAfterStartList.add(50);
        minutesAfterStartList.add(-5);
        minutesAfterStartList.add(-3);
        minutesAfterStartList.add(8);
        assertEquals(YES, angryProfessor(30, minutesAfterStartList));
        assertEquals(NO, angryProfessor(0, minutesAfterStartList));
        assertEquals(YES, angryProfessor(5, minutesAfterStartList));
        assertEquals(NO, angryProfessor(3, minutesAfterStartList));
    }

    @Test
    public void testBeautifulDays() {
        assertEquals(beautifulDays(1, 30, 2), 19);
        assertEquals(beautifulDays(10, 30, 2), 10);
        assertEquals(beautifulDays(10, 30, 3), 21);
        assertEquals(beautifulDays(20, 29, 5), 2);
        assertEquals(beautifulDays(12, 12, 7), 0);
    }

    @Test
    public void testViralAdvertising() {
        assertEquals(viralAdvertising(1) , 2);
        assertEquals(viralAdvertising(10), 189);
        assertEquals(viralAdvertising(20), 10796);
        assertEquals(viralAdvertising(30), 622157);
        assertEquals(viralAdvertising(40), 35875988);
    }
}

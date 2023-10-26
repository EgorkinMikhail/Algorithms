package org.example.AlgorithmTasks.MediumAlgorithms;

import org.example.AlgorithmTasks.MediumAlgorithms.BinaryTree.Solution;
import org.example.AlgorithmTasks.MediumAlgorithms.BinaryTree.TreeNode;
import org.example.AlgorithmTasks.MediumAlgorithms.Skyline.Skyline;
import org.example.AlgorithmTasks.MediumAlgorithms.SubrectangleQueries.SubrectangleQueries;

public class Start {

    public static void main(String[] args) {
        startSubrectangleQueries();
        startSkyline();
        testGetTargetCopy();
    }

    private static void startSubrectangleQueries() {
        int[][] rectangle = new int[][] {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries obj = new SubrectangleQueries(rectangle);
        int param_2 = obj.getValue(0, 2);
        System.out.println(param_2);
        obj.updateSubrectangle(0,0,3,2,5);
        System.out.println(obj.getValue(0, 2));
        System.out.println(obj.getValue(3, 1));
        obj.updateSubrectangle(3,0,3,2,10);
        System.out.println(obj.getValue(3, 1));
        System.out.println(obj.getValue(0, 2));
    }

    private static void startSkyline() {
        Skyline skyline = new Skyline();
        int[][] buildingsGrid = new int[][] {{3,0,8,4}, {2,4,5,7},{9,2,6,3}, {0,3,1,0}};
        System.out.println(skyline.maxIncreaseKeepingSkyline(buildingsGrid));

    }

    private static void testGetTargetCopy () {
        System.out.println("\n testGetTargetCopy");
        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);
        Solution solution = new Solution();
        TreeNode result = solution.getTargetCopy(original, original, new TreeNode(3));
        System.out.println(result.getVal());

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println("same tree " + Solution.isSameTree(p, q));
    }
}

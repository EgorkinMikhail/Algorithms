package org.example.Leetcode.MediumAlgorithms.BinaryTree;

public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        TreeNode tempTreeNode;
        if (target.val == original.val) {
            return cloned;
        } else {
            if (original.left!=null) {
                tempTreeNode = getTargetCopy(original.left, cloned.left, target);
                if (tempTreeNode!=null) {
                    return tempTreeNode;
                }
            }
            if (original.right!=null) {
                tempTreeNode = getTargetCopy(original.right, cloned.right, target);
                return tempTreeNode;
            }
        }
        return null;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return p==q;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root==null) return 0;

        if (!(isLastTreeNodeLevel(root.left)&isLastTreeNodeLevel(root.right)))
            return deepestLeavesSum(root.left) + deepestLeavesSum(root.right);

        if (!isLastTreeNodeLevel(root.left)) return deepestLeavesSum(root.left);
        if (!isLastTreeNodeLevel(root.right)) return deepestLeavesSum(root.right);

        if (isLastTreeNodeLevel(root)) return root.val;

        return 0;
    }

    int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public boolean isLastTreeNodeLevel(TreeNode root) {
        if (root==null) return false;
        return (root.left==null)&(root.right==null);
    }
}
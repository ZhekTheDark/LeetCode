package com.easy;

import com.easy._94_BinaryTreeInorderTraversal.TreeNode;

public class _543_DiameterOfBinaryTree {

    int diameter = 0;

    /**
     * Runtime: 0 ms Beats 100%
     * Memory: 41.2 MB Beats 93.47%
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if (node.left != null) {
            leftDepth = depth(node.left);
        }
        if (node.right != null) {
            rightDepth = depth(node.right);
        }
        diameter = Math.max(diameter, leftDepth + rightDepth + 1);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

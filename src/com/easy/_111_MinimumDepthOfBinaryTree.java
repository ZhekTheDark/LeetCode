package com.easy;

import static com.easy._94_BinaryTreeInorderTraversal.*;

public class _111_MinimumDepthOfBinaryTree {

    int max = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            go(1, root.left);
        }
        if (root.right != null) {
            go(1, root.right);
        }

        return max + 1;
    }

    private void go(int depth, TreeNode node) {
        if (depth > max) {
            return;
        }
        if (node.left == null && node.right == null) {
            max = depth;
            return;
        }
        if (node.left != null) {
            go(depth + 1, node.left);
        }
        if (node.right != null) {
            go(depth + 1, node.right);
        }
    }
}

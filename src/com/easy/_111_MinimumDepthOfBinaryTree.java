package com.easy;

import static com.easy._94_BinaryTreeInorderTraversal.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.aa
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 */
public class _111_MinimumDepthOfBinaryTree {

    int max = Integer.MAX_VALUE;

    /**
     * Runtime: 1ms Beats 99.56% of users with Java
     * Memory: 61.39MB Beats 83.64% of users with Java
     */
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

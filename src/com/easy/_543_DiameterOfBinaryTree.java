package com.easy;

import com.easy._94_BinaryTreeInorderTraversal.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Example 2:
 * Input: root = [1,2]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */
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

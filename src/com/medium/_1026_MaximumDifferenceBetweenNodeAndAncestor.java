package com.medium;

import static com.easy._94_BinaryTreeInorderTraversal.TreeNode;

public class _1026_MaximumDifferenceBetweenNodeAndAncestor {

    int max = 0;

    /**
     * Runtime: 0ms Beats 100.00% of users with Java
     * Memory: 40.42MB Beats 91.51% of users with Java
     */
    public int maxAncestorDiff(TreeNode root) {
        getDiff(root, root.val, root.val);
        return max;
    }

    public void getDiff(TreeNode node, int minAncestorValue, int maxAncestorValue) {
        if (node == null) {
            return;
        }
        int minDiff = Math.abs(minAncestorValue - node.val);
        int maxDiff = Math.abs(maxAncestorValue - node.val);
        max = Math.max(minDiff, max);
        max = Math.max(maxDiff, max);

        int minValue = Math.min(minAncestorValue, node.val);
        int maxValue = Math.max(maxAncestorValue, node.val);
        getDiff(node.left, minValue, maxValue);
        getDiff(node.right, minValue, maxValue);
    }
}

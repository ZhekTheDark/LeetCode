package com.easy;

import java.util.*;

public class _94_BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Runtime: 1ms Beats 5.35% of users with Java
     * Memory: 40.62mb Beats 85.12% of users with Java
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        Set<TreeNode> visited = new HashSet<>();

        stack.push(root);
        while (root != null && !stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (visited.contains(node) || (node.left == null && node.right == null)) {
                res.add(node.val);
            } else {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                if (node.left != null) stack.push(node.left);
                visited.add(node);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null ,null);
        TreeNode node2 = new TreeNode(2, node3 ,null);
        TreeNode node1 = new TreeNode(1, null ,node2);

        List<Integer> res = inorderTraversal(node1);
        System.out.println("GG WP");
    }
}

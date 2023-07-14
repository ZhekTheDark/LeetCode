package com.hard;

import com.easy.ListNode;

import java.util.Arrays;
import java.util.Optional;

public class _23_MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Integer minPos = getPosOfMinNodeValue(lists);
        if (minPos == null) return null;
        ListNode minNode = lists[minPos];
        lists[minPos] = minNode.next;
        minNode.next = mergeKLists(lists);
        return minNode;
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//
//    }

    private Integer getPosOfMinNodeValue(ListNode[] lists) {
        Integer res = null;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            int notNullableRes = res != null ? res : Integer.MAX_VALUE;
            if (node != null && node.val < notNullableRes) {
                res = i;
            }
        }
        return res;
    }

    private static ListNode toListNodes(int[] arr) {
        if (arr.length == 0) return null;
        ListNode node = new ListNode(arr[0]);
        node.next = toListNodes(Arrays.copyOfRange(arr, 1, arr.length));
        return node;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {2, 6};
        ListNode node1 = toListNodes(arr1);
        ListNode node2 = toListNodes(arr2);
        ListNode node3 = toListNodes(arr3);
        ListNode[] input = {node1, node2, node3};
        ListNode res = mergeKLists(input);

        System.out.println("GG WP");
    }
}

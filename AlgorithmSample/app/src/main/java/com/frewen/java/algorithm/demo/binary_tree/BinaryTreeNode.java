package com.frewen.java.algorithm.demo.binary_tree;

/**
 * 树的数据结构
 */
public class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode() {
    }

    BinaryTreeNode(int val) {
        this.val = val;
    }

    BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

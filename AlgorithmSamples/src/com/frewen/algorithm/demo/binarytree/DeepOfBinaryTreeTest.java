package com.frewen.algorithm.demo.binarytree;

import com.frewen.algorithm.demo.binarytree.base.TreeNode;

/**
 * 二叉树的深度相关的算法测试Demo
 */
public class DeepOfBinaryTreeTest {

    public static void main(String[] args) {


        testMiniDeepOfBinaryTree();
    }

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最小深度  2.
     *
     * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
     */
    private static void testMiniDeepOfBinaryTree() {

        // 最直接的思路就是递归。
        // 我们用深度优先搜索来解决这个问题。
        // 深度优先算法
        TreeNode root = null;
        int deep = minDeepOfBinaryTree(root);


    }

    private static int minDeepOfBinaryTree(TreeNode root) {
        int min_depth = Integer.MAX_VALUE;
        if (root == null) {
            min_depth = 0;
        }
        if ((root.left == null) && (root.right == null)) {
            min_depth = 1;
        }
        // 我们采用深度优先算法.如果有左子树，就先始终遍历左子树，然后直接计算出所有左子树的深度
        if (root.left != null) {
            min_depth = Math.min(minDeepOfBinaryTree(root.left), min_depth);
        }

        if (root.right != null) {
            min_depth = Math.min(minDeepOfBinaryTree(root.right), min_depth);
        }

        return min_depth + 1;
    }
}

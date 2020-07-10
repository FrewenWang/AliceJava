package com.frewen.algorithm.demo.binarytree

import com.frewen.algorithm.demo.binarytree.base.TreeNode

/**
 * LeetCode第543题目. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 其实我们思考这道题目，我们就可以发现其实我们只要计算左右子树的深度
 *
 *
 */
class DiameterOfBinaryTree {
    var result = 1
    /**
     * @param root
     * @return
     */
    fun diameterOfBinaryTree(root: TreeNode<*>?): Int {
        if (null == root) {
            return 0
        }
        depthOfTreeNode(root)
        return result - 1
    }

    /**
     *
     * @param node
     */
    private fun depthOfTreeNode(node: TreeNode<*>?): Int {
        if (node == null) {
            return 0
        }
        val leftDepth = depthOfTreeNode(node.left)
        val rightDepth = depthOfTreeNode(node.right)
        result = Math.max(result, leftDepth + rightDepth + 1)
        return Math.max(leftDepth, rightDepth) + 1
    }
}
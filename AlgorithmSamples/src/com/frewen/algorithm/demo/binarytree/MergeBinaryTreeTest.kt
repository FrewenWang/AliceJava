package com.frewen.algorithm.demo.binarytree

import com.frewen.algorithm.demo.binarytree.base.TreeNode

class MergeBinaryTreeTest {

    /**
     * 通过先序遍历的方式来进行二叉树的合并
     * @param t1
     * @param t2
     */
    fun mergeByRecursionPreOrderTraversal(t1: TreeNode<*>?, t2: TreeNode<*>?): TreeNode<*>? {
        if (null == t2) {
            return t1
        }
        if (null == t1) {
            return t2
        }
        t1.`val` = t1.`val`.toString() + "+" + t2.`val`
        t1.left = mergeByRecursionPreOrderTraversal(t1.left, t2.left)
        t1.right = mergeByRecursionPreOrderTraversal(t1.right, t2.right)
        return t1
    }

    /**
     * 中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
     *
     * @param root
     */
    fun recursionMiddleOrderTraversal(root: TreeNode<*>?) {
        if (root != null) {
            recursionMiddleOrderTraversal(root.leftNode)
            print(root.value.toString() + " ")
            recursionMiddleOrderTraversal(root.rightNode)
        }
    }
}
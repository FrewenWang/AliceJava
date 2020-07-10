package com.frewen.algorithm.demo.binarytree

import com.frewen.algorithm.demo.binarytree.base.TreeNode
import org.junit.After
import org.junit.Before
import org.junit.Test

class MergeBinaryTreeTestTest {


    private var mMergeBinaryTree: MergeBinaryTreeTest? = null
    private var treeNode1: TreeNode<String>? = null
    private var treeNode2: TreeNode<String>? = null

    @Before
    fun setUp() {
        treeNode1 = TreeNode.initBinaryTree()
        treeNode2 = TreeNode.initBinaryTree()
        mMergeBinaryTree = MergeBinaryTreeTest();
    }

    @After
    fun tearDown() {
    }

    @Test
    fun recursionMiddleOrderTraversal() {
        val node = mMergeBinaryTree?.mergeByRecursionPreOrderTraversal(treeNode1, treeNode2)
        print("递归中序遍历：")
        mMergeBinaryTree?.recursionMiddleOrderTraversal(node)
        println(" ")
    }
}
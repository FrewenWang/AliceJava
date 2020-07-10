package com.frewen.algorithm.demo.binarytree;

import com.frewen.algorithm.demo.binarytree.base.TreeNode;

public class SymmetricBinaryTreeTest {

    public static void main(String[] args) {
        // 先初始化一个非对称二叉树
        TreeNode<String> binaryTreeNode = initNotSymmetricBinaryTree();

        boolean isisSymmetricBinaryTree = isSymmetricBinaryTree(binaryTreeNode);
        System.out.println("SymmetricBinaryTreeTest isisSymmetricBinaryTree = " + isisSymmetricBinaryTree);

        TreeNode<String> binaryTreeNode2 = initSymmetricBinaryTree();
        boolean isisSymmetricBinaryTree2 = isSymmetricBinaryTree(binaryTreeNode2);
        System.out.println("SymmetricBinaryTreeTest isisSymmetricBinaryTree = " + isisSymmetricBinaryTree2);

    }

    private static boolean isSymmetricBinaryTree(TreeNode<String> root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode<String> t1, TreeNode<String> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


    /**
     *         A
     *      /       \
     *    B          C
     *  /  \      /   \
     * D   E     F    G
     *    / \     \   /
     *   H   I    J  P
     * <p>
     * 我们分析一下：
     * <p>
     * 先序遍历：A、B、D、E、H、I、C、F、J、G、P
     * 中序遍历：D、B、H、E、I、A、F、J、C、P、G
     * 后序遍历：D、H、I、E、B、J、F、P、G、C、A
     *
     * @return
     */
    private static TreeNode<String> initNotSymmetricBinaryTree() {
        TreeNode<String> D = new TreeNode<String>("D", null, null);
        TreeNode<String> H = new TreeNode<String>("H", null, null);
        TreeNode<String> I = new TreeNode<String>("I", null, null);
        TreeNode<String> J = new TreeNode<String>("J", null, null);
        TreeNode<String> P = new TreeNode<String>("P", null, null);
        TreeNode<String> G = new TreeNode<String>("G", P, null);
        TreeNode<String> F = new TreeNode<String>("F", null, J);
        TreeNode<String> E = new TreeNode<String>("E", H, I);
        TreeNode<String> B = new TreeNode<String>("B", D, E);
        TreeNode<String> C = new TreeNode<String>("C", F, G);
        TreeNode<String> A = new TreeNode<String>("A", B, C);
        return A;
    }

    /**
     *         A
     *      /    \
     *    B      B
     *  /  \   /   \
     * D   E  D    E
     * 我们分析一下：
     * 先序遍历：A、B、D、E、B、D、E、
     * 中序遍历：
     * 后序遍历：D、H、I、E、B、J、F、P、G、C、A
     *
     * @return
     */
    private static TreeNode<String> initSymmetricBinaryTree() {
        TreeNode<String> G = new TreeNode<>("three", null, null);
        TreeNode<String> F = new TreeNode<>("three", null, null);
        TreeNode<String> E = new TreeNode<>("three", null, null);
        TreeNode<String> D = new TreeNode<>("three", null, null);
        TreeNode<String> B = new TreeNode<>("two", D, E);
        TreeNode<String> C = new TreeNode<>("two", F, G);
        TreeNode<String> A = new TreeNode<>("one", B, C);
        return A;
    }

}

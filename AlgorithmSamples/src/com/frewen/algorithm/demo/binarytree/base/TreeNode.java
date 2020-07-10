package com.frewen.algorithm.demo.binarytree.base;


/**
 * 二叉树的节点
 */
public class TreeNode<Value> {

    public Value val;
    //左子树
    public TreeNode<Value> right;
    //右子树
    public TreeNode<Value> left;

    //构造方法
    TreeNode(Value x) {
        val = x;
    }

    public TreeNode(Value val, TreeNode<Value> leftNode, TreeNode<Value> rightNode) {
        this.val = val;
        this.left = leftNode;
        this.right = rightNode;
    }

    public Value getValue() {
        return val;
    }

    public void setValue(Value val) {
        this.val = val;
    }

    public TreeNode<Value> getLeftNode() {
        return left;
    }

    public void setLeftNode(TreeNode<Value> leftNode) {
        this.left = leftNode;
    }

    public TreeNode<Value> getRightNode() {
        return right;
    }

    public void setRightNode(TreeNode<Value> rightNode) {
        this.right = rightNode;
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
    public static TreeNode<String> initBinaryTree() {
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
    public static TreeNode<Integer> initBinarySearchTree() {
        TreeNode<Integer> D = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> H = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> I = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> J = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> P = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> G = new TreeNode<Integer>(1, P, null);
        TreeNode<Integer> F = new TreeNode<Integer>(1, null, J);
        TreeNode<Integer> E = new TreeNode<Integer>(1, H, I);
        TreeNode<Integer> B = new TreeNode<Integer>(1, D, E);
        TreeNode<Integer> C = new TreeNode<Integer>(1, F, G);
        TreeNode<Integer> A = new TreeNode<Integer>(1, B, C);
        return A;
    }


}

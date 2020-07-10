package com.frewen.algorithm.demo.binarytree.base;

/**
 * 红黑树的节点信息
 */
public class RBTreeNode<T extends Comparable<T>> {
    boolean color; //颜色
    T key; //关键字(键值)
    RBTreeNode<T> left; //左子节点
    RBTreeNode<T> right; //右子节点
    RBTreeNode<T> parent; //父节点

    /**
     * 红黑树的构造函数
     *
     * @param key    节点的Key
     * @param color  如果为true 则是红色节点   如果为false 则是黑色节点
     * @param parent 父节点
     * @param left   左子树
     * @param right  右子树
     */
    public RBTreeNode(T key, boolean color, RBTreeNode<T> parent, RBTreeNode<T> left, RBTreeNode<T> right) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return "" + key + (this.color == true ? "R" : "B");
    }
}

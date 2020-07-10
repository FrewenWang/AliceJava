package com.frewen.algorithm.demo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树的节点
 */
public class MultiTreeNode<Value> {
    /**
     * 多叉树的父节点的ID
     */
    private int parentId;
    /**
     * 多叉树的节点的ID
     */
    private int selfId;
    /**
     * 多叉树节点的名字
     */
    protected String nodeName;
    /**
     * 节点对象
     */
    protected Value obj;
    /**
     * 子节点的列表
     */
    protected List<MultiTreeNode> childList = new ArrayList<>();

    public MultiTreeNode(Value value) {
        this.obj = value;
    }

    public void addChild(MultiTreeNode node) {
        this.childList.add(node);
    }

    /**
     * 初始化多叉树的子节点
     * @return
     */
    public static MultiTreeNode<String> initChildList() {
        MultiTreeNode<String> H = new MultiTreeNode("H");
        MultiTreeNode<String> I = new MultiTreeNode("I");
        MultiTreeNode<String> J = new MultiTreeNode("J");
        MultiTreeNode<String> E = new MultiTreeNode("E");
        E.addChild(H);
        E.addChild(I);
        E.addChild(J);


        MultiTreeNode<String> F = new MultiTreeNode("F");
        MultiTreeNode<String> G = new MultiTreeNode("G");

        MultiTreeNode<String> B = new MultiTreeNode("B");
        MultiTreeNode<String> C = new MultiTreeNode("C");
        MultiTreeNode<String> D = new MultiTreeNode("D");

        B.addChild(E);
        B.addChild(F);
        D.addChild(G);


        MultiTreeNode<String> A = new MultiTreeNode("A");
        A.addChild(B);
        A.addChild(C);
        A.addChild(D);

        return A;

    }

    public List<MultiTreeNode> getChildren() {
        return this.childList;
    }
}

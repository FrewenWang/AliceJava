package com.frewen.algorithm.demo.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MultiTreeNodeTest {
    public static void main(String[] args) {
        System.out.println("Hello MultiTreeTest");


        System.out.println("多叉树的递归遍历");
        MultiTreeNode<String> multiTreeNode = MultiTreeNode.initChildList();
        recursionTraversal(multiTreeNode);
        System.out.println("遍历完毕！！！");

        System.out.println("多叉树的非递归遍历");
        System.out.println("多叉树的广度优先算法");
        breadthFirstTraversal(multiTreeNode);
        System.out.println("遍历完毕！！！");


        System.out.println("多叉树的深度优先算法");
        depthFirstTraversal(multiTreeNode);
        System.out.println("遍历完毕！！！");

        System.out.println("计算多叉树的深度");
        maxDepth(multiTreeNode);
    }

    /**
     * 计算多叉树的深度
     * 树（多叉树、二叉树）的深度计算一般都是用递归计算
     * 具体可以看多叉树的递归遍历算法
     * @param root
     * @return
     */
    private static int maxDepth(MultiTreeNode<String> root) {
        if (root == null) {
            return 0;
        }
        if (root.getChildren() == null || root.getChildren().isEmpty()) {
            return 1;
        }
        int maxDepth = 0;
        // 我们这个可以很好理解：
        // 每当我们遍历一层子节点，我们的树的深度就会增加1。
        // 直到递归遍历到最后的子节点位置。我们取这个子节点的最大的深度
        // 我们就取这个子节点中最大的深度位置
        for (MultiTreeNode node : root.getChildren()) {
            int depth = maxDepth(node) + 1;
            if (maxDepth < depth) {
                maxDepth = depth;
            }
        }
        return maxDepth;
    }


    /**
     * 多叉树的深度优先算法（非递归方式的遍历）
     * 深度优先需要构建一个后进先出的栈,
     * @param root
     */
    private static void depthFirstTraversal(MultiTreeNode<String> root) {
        // 深度优先需要构建一个后进先出的栈,
        Stack<MultiTreeNode> stack = new Stack<>();
        // 构建一个多叉树的引用，指向多叉树的Root
        MultiTreeNode<String> node = root;

        // 让根节点入栈
        stack.push(node);
        // 判断栈是否为空，然后执行出栈的操作。
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.obj + "、");
            // 因为是深度优先遍历，所以我们要先出栈根节点，然后，遍历根节点的所有子节点
            // 将子节点依次入栈。这样我们就可以将最终的叶子节点位于栈顶。
            // 然后我们依次执行出栈遍历的操作
            List<MultiTreeNode> children = node.getChildren();
            if (children != null && children.size() > 0) {
                // 这个我们故意从最后节点开始遍历，比较符合咱们的遍历习惯
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
    }

    /**
     * 多叉树的广度优先算法（非递归方式的遍历）
     * @param root
     */
    private static void breadthFirstTraversal(MultiTreeNode<String> root) {
        // 广度优先需要构建一个先进先出的队列
        Deque<MultiTreeNode> nodeDeque = new LinkedList<>();
        // 构建一个多叉树的引用，指向多叉树的Root
        MultiTreeNode<String> node = root;
        // 让根节点入队列
        nodeDeque.push(node);
        // 判断队列不为空，进行出队列的管理。所有广度遍历的节点依次入队列。
        // 待队列中所有元素均出队列之后，那么也表明多叉树的遍历结束
        while (!nodeDeque.isEmpty()) {
            // 判断出队列的node节点。第一个出来的Node节点的是根节点。
            node = nodeDeque.pop();
            System.out.print(node.obj + "、");
            // 因为是广度优先，所以先遍历根节点的所有的元素，然后将所有元素依次入队列
            // 然后这样，相当于一次广度遍历
            for (MultiTreeNode treeNode : node.getChildren()) {
                nodeDeque.addLast(treeNode);
            }
        }
    }

    /**
     * 多叉树的递归遍历。
     * 多叉树的递归遍历：先打印根节点的值，然后依次遍历所有的子节点。持续递归。
     *
     * 我们可以思考一个问题：
     * 使用递归遍历的优点：
     * 1、递归遍历代码实现比较简单
     *
     * 使用递归遍历的缺点：
     * 1、递归遍历实现不太便于理解。
     * 2、递归遍历需要递归入栈，如果树的结构特别复杂，特别深。那么我们递归的算法递归
     *      就会在当前线程的栈中不断的入栈,入的多了就爆了,就会抛出java.lang.StackOverflowError
     *      这种情况在尤其在我们误入递归死循环之后肯定会出现，相信大家都遇到过。
     * @param root
     */
    private static void recursionTraversal(MultiTreeNode<String> root) {
        if (null == root) {
            return;
        }
        System.out.print(root.obj + "、");
        for (MultiTreeNode treeNode : root.getChildren()) {
            recursionTraversal(treeNode);
        }

    }


}
package com.frewen.algorithm.demo.binarytree.search;

import com.frewen.algorithm.demo.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 *  
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 计算这个算法题，我们首先要知道二叉搜索树的特点
 */
public class Offer54KthLargestElements {
    TreeNode treeNode = TreeNode.initBinarySearchTree();
    int result = kthLargestElement(treeNode, 10);

    private int kthLargestElement(TreeNode treeNode, int k) {
        List<Integer> elements = new ArrayList<>();

        middleOrderTraversal(treeNode, elements);
        return elements.get(elements.size() - k);
    }

    /**
     * 我们采用中序遍历，依次将元素放入到List中。这样其实就是将元素按照大小来进行拍窜
     * @param treeNode
     * @param elements
     */
    private void middleOrderTraversal(TreeNode treeNode, List<Integer> elements) {
        if (treeNode != null) {
            middleOrderTraversal(treeNode,elements);
            elements.add(treeNode.val);
            middleOrderTraversal(treeNode,elements);
        }
    }
}

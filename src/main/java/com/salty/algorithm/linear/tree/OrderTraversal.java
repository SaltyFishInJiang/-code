package com.salty.algorithm.linear.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历 leetcode:102
 * @author ryan
 * @since 2020/09/29
 */
public class OrderTraversal {

    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x;
         }
     }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        helper(results, 0, root);
        return  results;
    }

    public void helper(List<List<Integer>> results, int level, TreeNode node) {
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(node.val);
        if (node.left != null) {
            helper(results, level + 1, node.left);
        }
        if (node.right != null) {
            helper(results, level + 1, node.right);
        }
    }
}

package com.lcy.leetcode.recursion;



/**
 * Created by luo on 2020/4/5.
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 */
public class TreeNodeLenth {

    /**
     * 问题分析：
     * 这题 当前的最长度=左侧子树的最长度+右侧子树的最长度
     * 终止条件：节点为空则不再遍历
     * 如果左侧节点与当前节点值一致  则令 当前左侧节点的最长度 + 1为当前节点的最长度
     * 右侧同理
     * 判断左侧最长度+右侧最长度是否>之前记录的最长度 如果大于则更改最大度
     * max(返回左侧最长度，右侧最长度)为当前节点的最长度
     * 这题的难点与传统的递归程序相比 返回值不再作为递归的数据传递值 数据传递值 通过max(返回左侧最长度，右侧最长度)为当前节点的最长度来记录
     */

    int res;
    public int length(TreeNode node){
        // 终止条件：节点为空则不再遍历 当前节点最长度为0
        if (node == null) {
            return 0;
        }
        //当前左侧节点的最长度
        int leftNum = length(node.left);
        //当前右侧节点的最长度
        int rigthNum = length(node.right);
        //如果左侧节点与当前节点值一致  则令 当前左侧节点的最长度 + 1为当前节点的最长度
        int arrowLeft = 0,arrowRight = 0;
        if (node.left!=null&&node.left.val ==node.val) {
            arrowLeft = leftNum+1;
        }
        //右侧同理
        if (node.right!=null&& node.right.val ==node.val) {
            arrowRight = rigthNum+1;
        }
        //判断左侧最长度+右侧最长度是否>之前记录的最长度 如果大于则更改最大度
        res = Math.max(res,arrowLeft + arrowRight);
        //返回了左，右侧节点最大最长度 作为当前节点 单边最长度
        return Math.max(arrowLeft,arrowRight);
    }

    public static void main(String[] args) {
        TreeNodeLenth tl = new TreeNodeLenth();
        TreeNode treeNode = tl.buildTreeNode_1();
        System.out.println(tl.maxLength(treeNode));
    }

    private int maxLength(TreeNode treeNode) {
        res = 0;
        length(treeNode);
        return res;
    }

    private TreeNode buildTreeNode_1() {
        TreeNode tn = new TreeNode(5);
        TreeNode tmp = tn;
        tmp.right = new TreeNode(5);
        tmp = tmp.right;
        tmp.right = new TreeNode(5);
        tmp = tn;
        tmp.left = new TreeNode(4);
        tmp = tmp.left;
        tmp.left = new TreeNode(1);
        tmp.right = new TreeNode(1) ;
        return tn;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


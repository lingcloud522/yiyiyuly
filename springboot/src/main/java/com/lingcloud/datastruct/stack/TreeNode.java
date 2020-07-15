package com.lingcloud.datastruct.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wushiyuan
 * @version 1.0
 * @className TreeNode
 * @description
 * @date 2019-08-02 15:52
 **/
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        List<Integer> integers = TreeNode.inorderTraversal(root);
        System.out.println(integers);
    }
}

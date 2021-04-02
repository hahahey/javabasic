package com.hahahey;

import java.util.Stack;

//节点结构
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class BinaryTree {


    //前序遍历
    public static void preOrderTraversal(TreeNode tree) {
        //判断根节点下是否有左子节点,如果不为null，则继续遍历
        System.out.print(tree.value);
        //获取进来处理的左节点
        TreeNode treeLeft = tree.left;
        if (treeLeft != null) {
            //不为null，继续递归处理，则调用的还是此方法
            preOrderTraversal(treeLeft);
        }
        TreeNode treeRight = tree.right;
        if (treeRight != null) {
            preOrderTraversal(treeRight);
        }

    }

    //非递归遍历
    public static void preOrderTraversalNR(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode left = tree.left;
        TreeNode right = tree.right;

        while (tree != null || !stack.isEmpty()) {
            //插入左边所有左节点
            while (tree != null) {
                System.out.print(tree.value);
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                tree = tree.right;
            }
        }
    }


    public static void main(String[] args) {

        //以数组形式生成一颗完全二叉树
        TreeNode[] tree = getTree();


//        preOrderTraversal(tree[0]);
//        System.out.println("\r");

        preOrderTraversalNR(tree[0]);

    }

    private static TreeNode[] getTree() {
        TreeNode[] tree = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            tree[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) {
                tree[i].left = tree[i * 2 + 1];
            }
            if (i * 2 + 2 < 10) {
                tree[i].right = tree[i * 2 + 2];
            }
        }
        return tree;
    }
}

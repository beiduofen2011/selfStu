package com.fen.dou.sjjg;

import java.util.LinkedList;
import java.util.List;

public class TwoTree {
    TreeNode root;


    public void addNode(TreeNode treeNode){
        if(root == null){
            this.root = treeNode;
        }else {
            TreeNode currentNode = this.root;
            TreeNode parent ;
            for(;;){
                parent = currentNode;
                if(treeNode.compareTo(currentNode) > 0){
                    currentNode = currentNode.right;
                    if (currentNode == null){
                        parent.right = treeNode;
                        break;
                    }
                }else {
                    currentNode = currentNode.left;

                    if (currentNode == null){
                        parent.left = treeNode;
                        break;
                    }
                }
            }
        }
    }
    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public void aroundOrder(TreeNode treeNode) {
        if (treeNode != null) {
            aroundOrder(treeNode.left);
            System.out.print(" " + treeNode.value + " ");
            aroundOrder(treeNode.right);
        }
    }
    /**
     * 后序遍历
     *
     * @param treeNode
     */
    public void afterOrder(TreeNode treeNode) {
        if (treeNode != null) {
            afterOrder(treeNode.left);
            afterOrder(treeNode.right);
            System.out.print(" " + treeNode.value + " ");
        }
    }

    /**
     * 先序遍历
     *
     * @param treeNode
     */
    public void beforeOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(" " + treeNode.value + " ");
            beforeOrder(treeNode.left);
            beforeOrder(treeNode.right);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> res = new LinkedList<>();
        if(root == null) return res;
        solve(root, "", res);
        return res;
    }

    public static void solve(TreeNode root, String cur, LinkedList<String> res) {
        if (root == null) {
            return;
        }
        cur += root.value;
        if (root.left == null && root.right == null) {
            res.add(cur);
        } else {
            solve(root.left, cur + "->", res);
            solve(root.right, cur + "->", res);
        }

    }

}
class TreeNode implements Comparable<TreeNode> {
    public TreeNode left;
    public  String value;
    public TreeNode(String value) {
        this.value = value;
    }
    public TreeNode right;

    @Override
    public int compareTo(TreeNode o) {
        return this.value.compareTo(o.value);
    }
}


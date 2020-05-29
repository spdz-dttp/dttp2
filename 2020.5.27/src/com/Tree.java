package com;

/**
 * @program: 2020.5.27
 * @description:
 * @author: spdz
 * @create: 2020-05-27 19:17
 **/

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
}
public class Tree {

    //根据前序数组，以0为空 ，建立二叉树
    int i = 0;
    public Node buildTree(int[] arr) {
        Node root = null;

        if(arr[0] == 0) {
            return root;
        }
        if(i < arr.length) {
            if(arr[i] != 0) {
                root = new Node(arr[i]);
                i++;
                root.left = buildTree(arr);
                root.right = buildTree(arr);

            }else {
                i++;
            }
        }

        return root;
    }

    //前序遍历
    public void pre(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        pre(root.left);
        pre(root.right);
    }

    //中序遍历
    public void in(Node root) {
        if(root == null) {
            return;
        }
        in(root.left);
        System.out.print(root.val + " ");
        in(root.right);
    }

    //二叉树搜索树转换成排序双向链表
    Node prev = null;
    public void cover2(Node root) {
        if(root == null) {
            return;
        }
        Node cur = root;
        cover2(cur.left);
        cur.left = prev;
        if(prev != null) {
            prev.right = cur;
        }
        prev = cur;
        cover2(cur.right);
    }

    public Node cover(Node root) {
        if(root == null) {
            return null;
        }
        cover2(root);
        Node head = root;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    //打印链表
    public void display(Node head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }
}

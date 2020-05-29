package com;

/**
 * @program: 2020.5.27
 * @description:
 * @author: spdz
 * @create: 2020-05-27 19:17
 **/

public class TestDemo {
    public static void main(String[] args) {
        Tree t = new Tree();
        int[] arr = {4,2,1,0,0,3,0,0,6,5,0,0,7,0,0};
        Node root = t.buildTree(arr);
        t.pre(root);
        System.out.println();
        t.in(root);
        System.out.println();
        t.display(t.cover(root));
    }
}


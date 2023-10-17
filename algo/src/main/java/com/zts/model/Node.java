package com.zts.model;

/**
 * @author : zhangtusheng
 * @date : 2022/5/28 2:05 AM
 * @description:
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

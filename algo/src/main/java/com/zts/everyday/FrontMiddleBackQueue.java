package com.zts.everyday;

import java.util.LinkedList;

/**
 * @Author zhangtusheng
 * @Date 2023 11 28 22 41
 * @describe：
 **/
public class FrontMiddleBackQueue {

    private LinkedList linkedList;

    public FrontMiddleBackQueue() {
        linkedList = new LinkedList();
    }

    public void pushFront(int val) {
        linkedList.addFirst(val);
    }

    public void pushMiddle(int val) {
        int size = linkedList.size();
        int index = size / 2;
        linkedList.add(index, val);
    }

    public void pushBack(int val) {
        linkedList.addLast(val);
    }

    public int popFront() {
        return (int) linkedList.removeFirst();
    }

    public int popMiddle() {
        int index = linkedList.size() /2;
        return (int) linkedList.remove(index);
    }

    public int popBack() {
        return (int) linkedList.removeLast();
    }
}

package com.zts.struct.queue;

import java.util.*;

/**
 * @Author zhangtusheng
 * @Date 2023 10 10 21 33
 * @describe：
 **/
class MinStack {

    PriorityQueue<Integer> queue;

    Stack<Integer> stack;

    HashMap<Integer, Integer> map = new HashMap<>();

    /** initialize your data structure here. */
    public MinStack() {
        queue = new PriorityQueue<Integer>();
        stack = new Stack<>();
    }

    public void push(int x) {
        Integer i = Integer.valueOf(x);
        queue.offer(i);
        stack.push(i);
        map.put(i, i);
    }

    public void pop() {
        Integer poll = queue.poll();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return queue.peek();
    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(64); // 使用较大的初始容量

        // 向HashMap中插入大量元素，使链表长度达到8
        for (int i = 1; i <= 1000; i++) {
            hashMap.put(i, i);
            hashMap.remove(i);
        }

        // 插入第1001个元素，触发红黑树化条件
        hashMap.put(1001, 1001);

        // 此时，HashMap中的链表已经变成了红黑树
        System.out.println(hashMap);
    }
}

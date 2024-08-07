package com.zts.week;

import com.alibaba.fastjson.JSON;
import com.zts.model.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author zhangtusheng
 * @Date 2024 07 14 10 35
 * @describe：https://leetcode.cn/contest/weekly-contest-406
 **/
public class Week406 {

    public static void main(String[] args) {
        Week406 week406 = new Week406();
//        System.out.println(week406.getSmallestString("001"));

        int[] ints = {1, 2, 3, 4, 5};
        ListNode head = new ListNode();
        for (int anInt : ints) {
            ListNode listNode = new ListNode(anInt);
            listNode.next = head.next;
            head.next = listNode;
        }
    }



    // 横着切，树着切。
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        long ans = 0;
        int i = m - 2;
        int j = n - 2;
        int cntH = 1;
        int cntV = 1;
        while (i >= 0 || j >= 0) {
            if (j < 0 && horizontalCut[i] > verticalCut[j]) {
                ans += horizontalCut[i--] * cntH;
                cntV++;
            } else {
                ans += verticalCut[j--] * cntV;
                cntH++;
            }
        }
        return ans;
    }


    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }
        Stack<Integer> stack = new Stack<>();
        ListNode newHead = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            if (!map.containsKey(current.val)) {
                stack.push(current.val);
            }
            current = current.next;
        }
        while (!stack.isEmpty()) {
            ListNode listNode = new ListNode(stack.pop());
            listNode.next = newHead.next;
            newHead.next = listNode;
        }
        return newHead.next;
    }


    public String getSmallestString(String s) {
        String result = "";
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int a = charArray[i] - '0';
            if (i == s.length() - 1) {
                result += charArray[i];
                break;
            }
            int b = charArray[i+1] - '0';
            if (a % 2 == b % 2 && a > b) {
                result += b;
                result += a;
                result += s.substring(i + 2);
                break;
            }
            result += charArray[i];
        }
        return result;
    }


}

package com.zts.divideConquer;

import java.util.HashMap;
import java.util.Map;

import com.zts.model.TreeNode;

/**
 * @author zts
 * @date 2023/8/19 17:18
 * @Description：分治算法
 */
public class DivideConquer {

	public static void main(String[] args) {
		DivideConquer divideConquer = new DivideConquer();
		System.out.println(divideConquer.verifyPostorder(new int[] {4, 8, 6, 12, 16, 14, 10}));

	}

	/**
	 *  二叉搜索树的后序遍历序列
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5vwxx5/
	 * @param postorder
	 * @return
	 * eg: [1,2,3,5,6]   [1,6,3,2,5]
	 */
	public boolean verifyPostorder(int[] postorder) {
		return isBinaryFlag(postorder, 0, postorder.length - 1);
	}

	private boolean isBinaryFlag(int[] postorder, int i, int j) {
		if (i >= j) {
			return true;
		}
		int p = i;
		while(postorder[p] < postorder[j]) {
			p++;
		}
		int m = p;
		while(postorder[p] > postorder[j]) {
			p++;
		}
		return p == j && isBinaryFlag(postorder, i, m - 1) && isBinaryFlag(postorder, m, j - 1);
	}


	/**
	 * 打印从 1 到最大的 n 位数
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/594wfg/
	 * @param n
	 * @return
	 */
	public int[] printNumbers(int n) {
		int max = 9;
		for (int i = 1; i < n; i++) {
			max = max * 10 + 9;
		}
		int[] res = new int[max];
		for (int i = 0; i < max; i++) {
			res[i] = i + 1;
		}
		return res;
	}

	/**
	 * 重建二叉树
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/99lxci/
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	int[] preorder;
	Map<Integer, Integer> dic = new	HashMap<Integer, Integer>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		for(int i = 0; i < inorder.length; i++) {
			dic.put(inorder[i], i);
		}
		return recur(0, 0, inorder.length - 1);
	}

	private TreeNode recur(int root, int left, int right) {
		if (left > right) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[root]);
		int i = dic.get(preorder[root]);
		node.left = recur(root + 1, left, i - 1);
		node.right = recur(root + i - left + 1, i+1, right);
		return node;
	}


	/**
	 * 数值的整数次方
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/57rwmg/
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		double res = 1.0;
		long b = n;
		boolean flag = false;
		if (n < 0) {
			b = Math.abs(b);
			flag = true;
		}
		while (b >= 1) {
			if (b % 2 == 1) res *= x;
			x *= x;
			b = b / 2;
		}
		if (flag) {
			res = 1 / res;
		}
		return res;
	}
}

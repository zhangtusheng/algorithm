package com.zts.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.alibaba.fastjson.JSON;
import com.zts.model.TreeNode;

/**
 * @author zts
 * @date 2023/9/4 12:56
 * @Description
 */
public class TreeMain {

	public static void main(String[] args) {
		Integer[] data = {8,17,21,18,null,null,6};
		BuilderTree builderTree = new BuilderTree();
		TreeNode root = builderTree.buildTree(data);
		TreeMain builder = new TreeMain();
		System.out.println(JSON.toJSONString(builder.levelOrder1(root)));

	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/9ackoe/
	 * @param root
	 * @return
	 */
	public int[] levelOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (! queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				TreeNode poll = queue.poll();
				result.add(poll.val);
				if (poll.left != null) {
					queue.offer(poll.left);
				}
				if (poll.right != null) {
					queue.offer(poll.right);
				}
			}
		}
		int[] ints = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			ints[i] = result.get(i);
		}
		return ints;
	}

	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (! queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> integers = new ArrayList<>();
			for (int i = 0; i < size; i++) {

				TreeNode poll = queue.poll();
				integers.add(poll.val);
				if (poll.left != null) {
					queue.offer(poll.left);
				}
				if (poll.right != null) {
					queue.offer(poll.right);
				}
			}
			result.add(integers);
		}
		return result;
	}






	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/575kd2/
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		Map<TreeNode, TreeNode> map = new HashMap<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if (poll.left != null) {
					map.put(poll.left, poll);
					queue.offer(poll.left);
				}
				if (poll.right != null) {
					map.put(poll.right, poll);
					queue.offer(poll.right);
				}
			}
		}
		// 查找路径。
		List<TreeNode> pList = new ArrayList<>();
		TreeNode currentNode = p;
		while(currentNode!= null) {
			pList.add(currentNode);
			currentNode = map.get(currentNode);
		}

		currentNode = q;
		while(currentNode != null) {
			if (pList.contains(currentNode)) {
				return currentNode;
			}
			currentNode = map.get(currentNode);
		}

		return null;

	}



}

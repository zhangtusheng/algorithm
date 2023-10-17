package com.zts.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

import com.zts.model.Node;
import com.zts.model.TreeNode;

/**
 * @author zts
 * @date 2023/9/4 12:56
 * @Description
 */
public class TreeMain {

	public static void main(String[] args) {
		Integer[] data = {4,2,5,1,3};
		BuilderTree builderTree = new BuilderTree();
		TreeNode root = builderTree.buildTree(data);
		TreeMain builder = new TreeMain();
//		TreeNode object = builder.treeToDoublyList(root);
//		TreeNode head = object;
//		System.out.println(head.val);
//		object = head.right;
//		while (object != head) {
//			System.out.println(object.val);
//			object= object.right;
//		}
		//System.out.println(JSON.toJSONString(object));

	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/lhhy8s/
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root.left == null && root.right == null) {
			return true;
		}
		int leftHeight = calculateDepth(root.left);
		int rightHeigth = calculateDepth(root.right);
		return Math.abs(leftHeight - rightHeigth)<=1 && isBalanced(root.left) && isBalanced(root.right);
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7ffjqr/
	 * @param root
	 * @return
	 */
	public int calculateDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(calculateDepth(root.left), calculateDepth(root.right));
	}


	Stack<Integer> valueNode ;

	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7ffx6t/
	 * @param root
	 * @param cnt
	 * @return
	 */
	public int findTargetNode(TreeNode root, int cnt) {
		valueNode = new Stack<>();
		preDfsTreeNode(root);
		int i =0 ;
		while (i < cnt) {
			Integer pop = valueNode.pop();
			i++;
			if (i == cnt) {
				return pop;
			}
		}
		return 0;
	}

	private void preDfsTreeNode(TreeNode root) {
		if (root == null) {
			return ;
		}
		preDfsTreeNode(root.left);
		valueNode.push(root.val);
		preDfsTreeNode(root.right);
	}

	Queue<Node> stack;

	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fjekj/
	 * @param root
	 * @return
	 */
	public Node treeToDoublyList(Node root) {
		stack = new ArrayDeque<>();
		if (root == null) {
			return root;
		}
		preDfsTreeNode(root);
		Node poll1 = stack.poll();
		Node head = poll1;
		while (!stack.isEmpty()) {
			Node poll = stack.poll();
			head.right = poll;
			poll.left = head;
			head = poll;
		}
		head.right = poll1;
		poll1.left = head;
		return poll1;
	}

	private void preDfsTreeNode(Node root) {
		if (root == null) {
			return ;
		}
		preDfsTreeNode(root.left);
		stack.offer(root);
		preDfsTreeNode(root.right);
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

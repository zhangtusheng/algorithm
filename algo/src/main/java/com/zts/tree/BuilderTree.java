package com.zts.tree;

import com.zts.model.TreeNode;

/**
 * @author zts
 * @date 2023/10/10 19:07
 * @Description
 */
public class BuilderTree {

	private TreeNode buildTree(Integer[] data, int index) {
		if (index >= data.length || data[index] == null) {
			return null;
		}

		TreeNode node = new TreeNode(data[index]);
		node.left = buildTree(data, 2 * index + 1);
		node.right = buildTree(data, 2 * index + 2);

		return node;
	}

	public TreeNode findNode(TreeNode root, int target) {
		if (root == null) {
			return null;
		}

		// 检查当前节点的值是否等于目标值
		if (root.val == target) {
			return root;
		}

		// 递归搜索左子树和右子树
		TreeNode leftResult = findNode(root.left, target);
		TreeNode rightResult = findNode(root.right, target);

		// 如果在左子树中找到目标节点，则返回左子树的结果
		if (leftResult != null) {
			return leftResult;
		}

		// 如果在右子树中找到目标节点，则返回右子树的结果
		if (rightResult != null) {
			return rightResult;
		}

		// 如果都没有找到，返回null
		return null;
	}


	public TreeNode buildTree(Integer[] data) {
		return buildTree(data, 0);
	}
}

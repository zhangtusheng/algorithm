package com.zts.other;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zts
 * @date 2024/6/6 17:24
 * @Description
 */
public class ACTrie {
	/**
	 * trie根节点
	 */
	private AcNode root;


	public ACTrie() {
		this.root = new AcNode();
	}

	class AcNode {
		/**
		 * 经过该节点的模式串的下层节点
		 */
		Map<Character, AcNode> next = new HashMap<>();

		/**
		 * 模式串的长度，也是节点的深度
		 */
		int depth;

		/**
		 * 失配指针，如果没有匹配到，则跳转到此状态。
		 */
		AcNode failure;

		public boolean hashNext(char nextKey) {
			return next.containsKey(nextKey);
		}

		public AcNode getNext(char nextKey) {
			return next.get(nextKey);
		}
	}

	/**
	 * 加入模式串，构建Trie
	 *
	 * @param word 模式串，非空
	 */
	public void insert(String word) {
		AcNode cur = root;
		for (char c : word.toCharArray()) {
			if (!cur.next.containsKey(c)) {
				cur.next.put(c, new AcNode());
			}
			cur = cur.next.get(c);
		}
		cur.depth = word.length();
	}

	/**
	 * 为所有节点构建失配指针，一个bfs层序遍历
	 */
	public void buildFailurePointer() {
		ArrayDeque<AcNode> queue = new ArrayDeque<AcNode>();
		//将所有root的直接子节点的failure设置为root，并且加入queue
		for (AcNode acNode : root.next.values()) {
			acNode.failure = root;
			queue.addLast(acNode);
		}
		//bfs构建失配指针
		while (!queue.isEmpty()) {
			//父节点出队列
			AcNode parent = queue.pollFirst();
			//遍历父节点的下层子节点，基于父节点求子节点的失配指针
			for (Map.Entry<Character, AcNode> characterAcNodeEntry : parent.next.entrySet()) {
				//获取父节点的失配指针
				AcNode pf = parent.failure;
				//获取子节点
				AcNode child = characterAcNodeEntry.getValue();
				//获取子节点对应的字符
				Character nextKey = characterAcNodeEntry.getKey();
				//如果pf节点不为null，并且pf节点的子节点对应的字符中，没有包含了当前节点的所表示的字符
				while (pf != null && !pf.hashNext(nextKey)) {
					//继续获取pf节点的失配指针节点，继续重复判断
					pf = pf.failure;
				}
				//pf为null，表示找到了根节点，并且根节点的子节点也没有匹配
				if (pf == null) {
					//此时直接将节点的失配指针指向根节点
					child.failure = root;
				}
				//pf节点的子节点对应的字符中，包含了当前节点的所表示的字符
				else {
					//节点的失配指针可以直接指向pf节点下的相同字符对应的子节点
					child.failure = pf.getNext(nextKey);
				}
				//最后不要忘了，将当前节点加入队列
				queue.addLast(child);
			}
		}
	}

	public void parseText1(String text) {
		char[] chars = text.toCharArray();
		AcNode p = root;
		//遍历字符串的每个字符
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			while (!p.hashNext(c) && p != root) {
				p = p.failure;
			}
			p = p.getNext(c);
			if (p == null) {
				p = root;
			} else {
				AcNode temp = p;
				while (temp != null) {
					if (temp.depth != 0) {
						int start = i - temp.depth + 1, end = i;
						System.out.println(start + " " + end + " " + new String(chars, start, temp.depth));
					}
					temp = temp.failure;
				}
			}
		}
	}

	/**
	 * 匹配文本
	 *
	 * @param text 文本字符串
	 */
	public List<ParseResult> parseText(String text) {
		List<ParseResult> parseResults = new ArrayList<>();
		char[] chars = text.toCharArray();
		//从根节点开始匹配
		AcNode cur = root;
		//遍历字符串的每个字符
		for (int i = 0; i < chars.length; i++) {
			//当前字符
			char nextKey = chars[i];
			//如果cur不为null，并且当前节点的的子节点不包括当前字符，即不匹配
			while (cur != null && !cur.hashNext(nextKey)) {
				//那么通过失配指针转移到下一个节点继续匹配
				cur = cur.failure;
			}
			//如果节点为null，说明当前字符匹配到了根节点且失败
			//那么继续从根节点开始进行下一轮匹配
			if (cur == null) {
				cur = root;
			} else {
				//匹配成功的节点
				cur = cur.getNext(nextKey);
				//继续判断
				AcNode temp = cur;
				while (temp != null) {
					//如果当前节点是某个关键词的结尾，那么取出来
					if (temp.depth != 0) {
						int start = i - temp.depth + 1, end = i;
						parseResults.add(new ParseResult(start, end, new String(chars, start, temp.depth)));
						//System.out.println(start + " " + end + " " + new String(chars, start, temp.depth));
					}
					//继续判断该节点的失配指针节点
					//因为失配指针节点表示的模式串是当前匹配的模式串的在这些关键词中的最长后缀，且由于当前节点的路径包括了失配指针的全部路径
					//并且失配指针路径也是一个完整的关键词，需要找出来。
					temp = temp.failure;
				}
			}
		}
		return parseResults;
	}

	class ParseResult {
		int startIndex;
		int endIndex;
		String key;

		public ParseResult(int startIndex, int endIndex, String key) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.key = key;
		}

		@Override
		public String toString() {
			return "{" +
				"startIndex=" + startIndex +
				", endIndex=" + endIndex +
				", key='" + key + '\'' +
				'}';
		}
	}


	public static void main(String[] args) {
		ACTrie acTrie3 = new ACTrie();
		//添加关键词，构建Trie
		acTrie3.insert("电焊");
		acTrie3.insert("电焊工");
		acTrie3.insert("电焊工人");
		acTrie3.insert("电焊学员");
		acTrie3.insert("电焊学徒");
		acTrie3.insert("电焊学徒工");
		acTrie3.insert("普工电焊工");
		acTrie3.insert("普工电商");
		acTrie3.insert("普工");
		//构建fail指针，一个bfs遍历
		acTrie3.buildFailurePointer();
		System.out.println(acTrie3.parseText("普工电焊工工作"));
	}
}


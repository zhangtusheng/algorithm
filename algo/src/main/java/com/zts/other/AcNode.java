package com.zts.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zts
 * @date 2024/6/6 17:26
 * @Description
 */
public class AcNode {

	Map<Character, AcNode> next = new HashMap<>();

	int depth;

	AcNode failure;

	public boolean hasNext(char c) {
		return next.containsKey(c);
	}

	public AcNode getNext(char c) {
		return next.get(c);
	}
}

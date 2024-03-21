package com.zts.find;

import java.util.Arrays;

/**
 * @author zts
 * @date 2024/3/21 20:02
 * @Description
 */
public class Finder <T extends Comparable<T>> {

	T[] arr;

	public Finder(T[] arr) {
		Arrays.sort(arr);
		this.arr = arr;
	}

	/**
	 * 寻找第一个等于target的元素。
	 * @param target
	 * @return
	 */
	public int binarySearchFirstEqual(T target) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid].equals(target)) {
				result = mid;
				right = mid - 1;
			} else if (arr[mid].compareTo(target) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

	/**
	 * 寻找第一个小于目标值的元素。
	 * @param target
	 * @return
	 */
	public int binarySearchFirstLess(T target){
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid].compareTo(target) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public int binarySearchFirstGreater(T target){
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid].compareTo(target) <= 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}



}

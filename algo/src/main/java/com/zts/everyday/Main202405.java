package com.zts.everyday;

/**
 * @author zts
 * @date 2024/5/8 15:15
 * @Description
 */
public class Main202405 {

	public static void main(String[] args) {
		Main202405 main202405 = new Main202405();
//		System.out.println(main202405.wateringPlants(new int[] {2, 2, 3, 3}, 5));
//		System.out.println(main202405.wateringPlants(new int[] {1,1,1,4,2,3}, 4));
		System.out.println(main202405.minimumRefill(new int[] {2, 2, 3, 3}, 5, 5));
		System.out.println(main202405.minimumRefill(new int[] {2, 2, 3, 3}, 3, 4));
		System.out.println(main202405.minimumRefill(new int[] {5}, 10, 8));
	}

	/**
	 * https://leetcode.cn/problems/watering-plants/?envType=daily-question&envId=2024-05-08
	 * @param plants
	 * @param capacity
	 * @return
	 */
	public int wateringPlants(int[] plants, int capacity) {
		int ans = 0;
		int currentCapacity = capacity;
		for (int i = 0; i < plants.length; i++) {
			int plant = plants[i];
			if (currentCapacity < plant) {
				// 当前距离 * 2 。
				ans += i * 2;
				currentCapacity = capacity;
			}
			ans++;
			currentCapacity -= plant;
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/watering-plants-ii/description/?envType=daily-question&envId=2024-05-09
	 * @param plants
	 * @param capacityA
	 * @param capacityB
	 * @return
	 */
	public int minimumRefill(int[] plants, int capacityA, int capacityB) {
		int ans = 0;
		// 就是要强行模拟这些操作。
		int currentCapacityA = capacityA;
		int currentCapacityB = capacityB;
		int start = 0, end = plants.length - 1;
		while (start <= end) {
			// 特殊处理一下，end - start = 1， end - start = 0的情况。
			if (end - start < 1) {
				int maxCapacity = Math.max(currentCapacityA, currentCapacityB);
				if (maxCapacity < plants[start]) {
					ans++;
				}
				break;
			}
			if (currentCapacityA < plants[start]) {
				currentCapacityA = capacityA;
				ans++;
			}
			if (currentCapacityB < plants[end]) {
				currentCapacityB = capacityB;
				ans++;
			}
			currentCapacityA -= plants[start++];
			currentCapacityB -= plants[end--];
		}
		return ans;
	}
}

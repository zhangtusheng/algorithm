package com.zts.everyday;

/**
 * @author zts
 * @date 2024/5/8 15:15
 * @Description
 */
public class Main202405 {

	public static void main(String[] args) {
		Main202405 main202405 = new Main202405();
		System.out.println(main202405.wateringPlants(new int[] {2, 2, 3, 3}, 5));
		System.out.println(main202405.wateringPlants(new int[] {1,1,1,4,2,3}, 4));
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
}

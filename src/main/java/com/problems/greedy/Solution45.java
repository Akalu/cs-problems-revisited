package com.problems.greedy;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] Output: 2 
 * 
 * Explanation: The minimum number of jumps to
 * reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the
 * last index.
 * 
 * [2,3,1,1,4] 2: 0 -> 3 -> 4
 */
public class Solution45 {

	public int jump(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return 0;
		}
		// max position one could reach from 0
		int maxReachablePos = nums[0];
		// max number of 1-steps one could do
		// inside this jump
		int maxPosForLastJump = nums[0];

		int jumps = 1;
		for (int i = 1; i < n; ++i) {
			// if to reach this point
			// one needs one more jump
			if (maxPosForLastJump < i) {
				++jumps;// need one more jump
				maxPosForLastJump = maxReachablePos;
			}
			maxReachablePos = Math.max(maxReachablePos, nums[i] + i);
		}
		return jumps;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
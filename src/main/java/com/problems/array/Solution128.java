package com.problems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence. Your algorithm should run in O(n) complexity.
 * 
 * Example: Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest
 * consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4
 */
public class Solution128 {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {// num is not in the middle of seq
                int currentNum = num;
                int currentStreak = 1;

                while (numsSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}

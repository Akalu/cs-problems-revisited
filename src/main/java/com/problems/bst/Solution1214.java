package com.problems.bst;

import java.util.HashSet;
import java.util.Set;

import com.problems.model.TreeNode;

/**
 * Given two binary search trees, return True if and only if there is a node in
 * the first tree and a node in the second tree whose values sum up to a given
 * integer target 
 * 
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5 Output:
 * true 
 * 
 * Explanation: 2 and 3 sum up to 5.
 * 
 * IDEA: the same as 2sum problem with sorted array
 */
public class Solution1214 {

    Set<Integer> inHashset(TreeNode r, int target, Set<Integer> s) {
        if (r == null)
            return s;
        inHashset(r.left, target, s);
        s.add(target - r.val);// add complementary
        inHashset(r.right, target, s);
        return s;
    }

    boolean inCheck(TreeNode r, Set<Integer> s) {
        if (r == null)
            return false;
        return inCheck(r.left, s) || s.contains(r.val) || inCheck(r.right, s);
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> s = inHashset(root1, target, new HashSet<>());
        return inCheck(root2, s);
    }

}
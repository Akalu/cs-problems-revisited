package com.problems.string;

/**
 * 
 * String
 * IDEA:
 * use freq map, iterate through array from back, removing duplicates on the way
 * O(2n)
 * 
 */
public class Solution1081 {

	public String removeDuplicateLetters(String s) {
		int[] freq = new int[26];
		boolean[] taken = new boolean[26];
		
		char[] letters = s.toCharArray();

		for (char c : letters) {
			freq[c - 'a']++;
		}

		StringBuilder res = new StringBuilder();
		res.append('0');

		for (char c : letters) {
			freq[c - 'a']--;
			int last = res.length() - 1;
			if (!taken[c - 'a']) {// if not taken yet on previous iteration removing duplicates on the way
				while (res.charAt(last) > c && freq[res.charAt(last) - 'a'] > 0) {
					taken[res.charAt(last) - 'a'] = false;
					res.deleteCharAt(last);
					last = res.length() - 1;
				}
				res.append(c);
				taken[c - 'a'] = true;
			}
		}

		return res.substring(1).toString();

	}

	

}

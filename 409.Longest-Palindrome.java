// https://leetcode.com/problems/longest-palindrome/
//
// algorithms
// Easy (49.23%)
// Total Accepted: 120,073
// Total Submissions: 243,895


class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int res = 0;
        for (int v : map.values()) {
            if ((v & 1) == 0) {
                res += v;
            } else {
                res += (v - 1);
            }
        }

        return Math.min(res + 1, len);
    }
}
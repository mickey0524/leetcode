// https://leetcode-cn.com/problems/palindrome-permutation-lcci/
// algorithms
// Easy (51.75%)
// Total Accepted: 2,221
// Total Submissions: 4,292


class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int oddNum = 0;
        for (int v : map.values()) {
            if ((v & 1) == 1) {
                oddNum++;
            }

            if (oddNum > 1) {
                return false;
            }
        }

        return true;
    }
}
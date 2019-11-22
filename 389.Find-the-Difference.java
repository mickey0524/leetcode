// https://leetcode.com/problems/find-the-difference/
//
// algorithms
// Easy (53.93%)
// Total Accepted: 165,145
// Total Submissions: 306,205


class Solution {
    public char findTheDifference(String s, String t) {
        int[] chNum = new int[26];

        for (char ch : s.toCharArray()) {
            chNum[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            int idx = ch - 'a';
            chNum[idx]--;
            if (chNum[idx] < 0) {
                return ch;
            }
        }

        return ' ';
    }
}
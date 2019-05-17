// https://leetcode.com/problems/longest-common-prefix/
//
// algorithms
// Easy (33.44%)
// Total Accepted: 458,776
// Total Submissions: 1,371,858

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int arrLen = strs.length;
        if (arrLen == 0) {
            return "";
        }

        int length = Integer.MAX_VALUE;

        for (String s : strs) {
            length = Math.min(length, s.length());
        }

        if (length == 0) {
            return "";
        }

        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < arrLen; j++) {
                if (strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, length);
    }
}
// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
// algorithms
// Easy (54.36%)
// Total Accepted: 13.1K
// Total Submissions: 24.1K


class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int idx = 0;
        int sLen = s.length();
        
        for (String w : words) {
            int len = w.length();
            if (!w.equals(s.substring(idx, Math.min(idx + len, sLen)))) {
                return false;
            }  

            idx += len;
            if (idx == sLen) {
                return true;
            }

            if (idx > sLen) {
                return false;
            }
        }

        return false;
    }
}
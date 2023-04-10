// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/
// algorithms
// Easy (45.41%)
// Total Accepted: 19.8K
// Total Submissions: 43.6K


class Solution {
 
    public int findTheLongestBalancedSubstring(String s) {
        int len = s.length();
        int res = 0;

        int zeroNum = 0;
        int oneNum = 0;
        boolean curZero = true;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (curZero) {
                    zeroNum += 1;
                } else {
                    curZero = true;
                    res = Math.max(res, Math.min(zeroNum, oneNum) * 2);
                    zeroNum = 1;
                    oneNum = 0;
                }
            } else {
                if (!curZero) {
                    oneNum += 1;
                } else {
                    curZero = false;
                    oneNum = 1;
                }
            }
        }

        return Math.max(res, Math.min(zeroNum, oneNum) * 2);
    }

}
// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
// algorithms
// Easy (42.19%)
// Total Accepted: 7,740
// Total Submissions: 18,346


class Solution {
    public boolean checkOnesSegment(String s) {
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        int i = 1;

        for (; i < len; i++) {
            if (chArr[i] == '0') {
                break;
            }
        }
        // 全 1 字符串
        if (i == len) {
            return true;
        }

        for (; i < len; i++) {
            if (chArr[i] == '1') {
                return false;
            }
        }

        return true;
    }
}
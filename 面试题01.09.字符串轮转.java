// https://leetcode-cn.com/problems/string-rotation-lcci/
// algorithms
// Easy (55.34%)
// Total Accepted: 1,965
// Total Submissions: 3,551


class Solution {
    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) {
            return false;
        }

        String tmp = s2 + s2;
        return tmp.indexOf(s1) != -1;
    }
}
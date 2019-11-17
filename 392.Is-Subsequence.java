// https://leetcode.com/problems/is-subsequence/
//
// algorithms
// Easy (47.62%)
// Total Accepted: 117,271
// Total Submissions: 246,242


class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        int idx = 0;
        boolean found = false;

        for (int i = 0; i < lenS; i++) {
            found = false;
            while (idx < lenT) {
                if (t.charAt(idx) == s.charAt(i)) {
                    idx++;
                    found = true;
                    break;
                }
                idx++;
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}
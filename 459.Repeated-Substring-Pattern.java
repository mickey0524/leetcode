// https://leetcode.com/problems/repeated-substring-pattern/
//
// algorithms
// Easy (40.71%)
// Total Accepted: 92,489
// Total Submissions: 227,201


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len < 2) {
            return false;
        }

        for (int i = 1; i <= len / 2; i++) {
            if (len % i != 0) {
                continue;
            }

            String tmp = s.substring(0, i);
            boolean match = true;
            for (int j = i; j < len; j += i) {
                if (!s.substring(j, j + i).equals(tmp)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }

        return false;
    }
}
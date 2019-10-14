// https://leetcode.com/problems/split-a-string-in-balanced-strings/
//
// algorithms
// Easy (79.9%)
// Total Accepted: 5,646
// Total Submissions: 7,066
// beats 100.0% of java submissions


class Solution {
    public int balancedStringSplit(String s) {
        int flag = 0;
        int res = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                flag++;
            } else {
                flag--;
            }

            if (flag == 0) {
                res++;
            }
        }

        return res;
    }
}
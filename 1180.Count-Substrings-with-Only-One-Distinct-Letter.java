// https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
//
// algorithms
// Easy (79.25%)
// Total Accepted: 1,753
// Total Submissions: 2,212
// beats 100.0% of java submissions


class Solution {
    public int countLetters(String S) {
        int len = S.length();
        if (len < 2) {
            return len;
        }

        int i = 0, res = 0;
        while (i < len) {
            int j = i + 1;
            while (j < len && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            for (int k = 1; k <= (j - i); k++) {
                res += k;
            }

            i = j;
        }

        return res;
    }

}
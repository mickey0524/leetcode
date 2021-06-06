// https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
// algorithms
// Easy (59.59%)
// Total Accepted: 15,741
// Total Submissions: 26,414


class Solution {

    public boolean checkZeroOnes(String s) {
        int zero = 0, one = 0;
        int len = s.length();
        int idx = 0;

        while (idx < len) {
            int tmp = idx + 1;
            while (tmp < len && s.charAt(tmp) == s.charAt(idx)) {
                tmp++;
            }

            if (s.charAt(idx) == '0') {
                zero = Math.max(zero, tmp - idx);
            } else {
                one = Math.max(one, tmp - idx);
            }

            idx = tmp;
        }

        return one > zero;
    }

}
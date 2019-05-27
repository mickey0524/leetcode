// https://leetcode.com/problems/reverse-integer/
//
// algorithms
// Easy (25.30%)
// Total Accepted: 691,114
// Total Submissions: 2,732,165
// beats 100.0% of java submissions


class Solution {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        int sample = x > 0 ? 1 : -1;
        if (x < 0) {
            x = -x;
        }

        int res = 0;
        while (x != 0) {
            int residual = x % 10;
            if ((Integer.MAX_VALUE - residual) / 10 < res) {
                return 0;
            }
            res = res * 10 + residual;

            x /= 10;
        }

        return sample * res;
    }
}
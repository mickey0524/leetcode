// https://leetcode.com/problems/the-kth-factor-of-n/
// algorithms
// Medium (70.49%)
// Total Accepted: 8,144
// Total Submissions: 11,553
// beats 100.0% of java submissions


class Solution {
    public int kthFactor(int n, int k) {
        int res = -1;

        for (int i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                k--;
            }

            if (k == 0) {
                return i;
            }
        }

        return -1;
    }
}
// https://leetcode.com/problems/minimum-operations-to-make-array-equal/
// algorithms
// Medium (77.91%)
// Total Accepted: 7,056
// Total Submissions: 9,057
// beats 100.0% of java submissions


class Solution {
    public int minOperations(int n) {
        if (n == 1) {
            return 0;
        }

        int equalNum = (1 + n * 2 - 1) / 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 2 * i + 1;
            if (tmp >= equalNum) {
                break;
            }

            res += (equalNum - tmp);
        }

        return res;
    }
}
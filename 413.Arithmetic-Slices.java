// https://leetcode.com/problems/arithmetic-slices/
//
// algorithms
// Medium (56.81%)
// Total Accepted: 73,609
// Total Submissions: 129,577
// beats 100.0% of java submissions


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }

        int res = 0;
        int diff = A[1] - A[0];
        int diffEqualLen = 2;
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] != diff) {
                if (diffEqualLen >= 3) {
                    int tmp = diffEqualLen - 2;
                    res += (1 + tmp) * tmp / 2;
                }

                diffEqualLen = 2;
                diff = A[i] - A[i - 1];
            } else {
                diffEqualLen++;
            }
        }

        if (diffEqualLen >= 3) {
            int tmp = diffEqualLen - 2;
            res += (1 + tmp) * tmp / 2;
        }

        return res;
    }
}
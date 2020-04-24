// https://leetcode-cn.com/problems/contiguous-sequence-lcci/
// algorithms
// Easy (59.14%)
// Total Accepted: 4,679
// Total Submissions: 7,912


class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, tmp = Integer.MIN_VALUE;

        for (int n : nums) {
            if (tmp < 0) {
                tmp = n;
            } else {
                tmp += n;
            }

            res = Math.max(res, tmp);
        }

        return res;
    }
}
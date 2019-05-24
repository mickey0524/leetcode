// https://leetcode.com/problems/longest-continuous-increasing-subsequence/
//
// algorithms
// Easy (44.24%)
// Total Accepted: 66,125
// Total Submissions: 149,461
// beats 100.0% of java submissions


class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int res = 1;
        int tmp = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                tmp += 1;
            } else {
                res = Math.max(res, tmp);
                tmp = 1;
            }
        }

        return Math.max(res, tmp);
    }
}
// https://leetcode.com/problems/running-sum-of-1d-array/
// algorithms
// Easy (95.47%)
// Total Accepted: 12,944
// Total Submissions: 13,558
// beats 100.0% of java submissions


class Solution {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = nums[0];

        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + nums[i];
        }

        return res;
    }
}
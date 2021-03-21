// https://leetcode.com/problems/maximum-ascending-subarray-sum/
// algorithms
// Easy (67.23%)
// Total Accepted: 5,530
// Total Submissions: 8,225


class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int tmp = nums[0];
        int len = nums.length;
        
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                res = Math.max(res, tmp);
                tmp = nums[i];
            } else {
                tmp += nums[i];
            }
        }
        
        return Math.max(tmp, res);
    }
}
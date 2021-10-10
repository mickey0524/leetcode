// https://leetcode.com/problems/maximum-difference-between-increasing-elements/
// algorithms
// Easy (56.78%)
// Total Accepted: 13.4K
// Total Submissions: 23.6K


class Solution {
    public int maximumDifference(int[] nums) {
        int curMin = nums[0];
        int len = nums.length;
        int res = -1;
        
        for (int i = 1; i < len; i++) {
            if (nums[i] > curMin) {
                res = Math.max(res, nums[i] - curMin);
            } else if (nums[i] < curMin) {
                curMin = nums[i];
            }
        }
        
        return res;
    }
}
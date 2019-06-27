// https://leetcode.com/problems/maximum-gap/
//
// algorithms
// Hard (32.7%)
// Total Accepted: 71,080
// Total Submissions: 217,394

class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }

        return res;
    }
}
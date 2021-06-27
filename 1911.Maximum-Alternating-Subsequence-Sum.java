// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
// algorithms
// Medium (54.67%)
// Total Accepted: 4.1K
// Total Submissions: 7.5K

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        long[][] dp = new long[len][2];
        dp[0][0] = nums[0];
        // dp[0][1] = Integer.MIN_VALUE;
        
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
        }

        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
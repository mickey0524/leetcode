// https://leetcode-cn.com/problems/the-masseuse-lcci/
// algorithms
// Easy (53.57%)
// Total Accepted: 24,557
// Total Submissions: 45,839


class Solution {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[len];
    }
}
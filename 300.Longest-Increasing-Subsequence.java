// https://leetcode.com/problems/find-the-duplicate-number/
//
// algorithms
// Medium (40.63%)
// Total Accepted:    215,062
// Total Submissions: 529,308
// beats 89.78% of java submissions


class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        
        int[] dp = new int[len + 1];
        dp[0] = Integer.MIN_VALUE;
        int idx = 0;
        
        for (int n : nums) {
            if (n > dp[idx]) {
                dp[++idx] = n;
            }
            
            int l = 1, r = idx, m;
            while (l <= r) {
                m = l + (r - l) / 2;
                if (n > dp[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            dp[l] = n;
        }
        
        return idx;
    }
}
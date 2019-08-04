// https://leetcode.com/problems/number-of-equivalent-domino-pairs/
//
// algorithms
// Medium (57.47%)
// Total Accepted: 1,265
// Total Submissions: 2,201

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[len1][len2];
    }
    
    public int max(int... nums) {
        int len = nums.length;
        int curMax = nums[0];
        
        for (int i = 1; i < len; i++) {
            curMax = Math.max(curMax, nums[i]);
        }
        
        return curMax;
    }
}
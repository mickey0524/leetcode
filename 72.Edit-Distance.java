// https://leetcode.com/problems/edit-distance/
//
// algorithms
// Hard (37.94%)
// Total Accepted:    176,406
// Total Submissions: 464,993

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }

        return dp[len1][len2];
    }

    public int min(int... nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = Math.min(res, nums[i]);
        }

        return res;
    }
}
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
//
// algorithms
// Medium (47.22%)
// Total Accepted: 40,258
// Total Submissions: 85,261


class Solution {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        int res = 0;
        
        for (int i = 1; i < lenA + 1; i++) {
            for (int j = 1; j < lenB + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }     
            }
        }
        
        return res;
    }
}
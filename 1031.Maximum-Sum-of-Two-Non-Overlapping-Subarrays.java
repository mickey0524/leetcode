// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
//
// algorithms
// Medium (54.34%)
// Total Accepted:    3,176
// Total Submissions: 5,845

class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int length = A.length;
        int sum[] = new int[length];
        
        sum[0] = A[0];
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        
        int res = 0, lMax = sum[L - 1], mMax = sum[M - 1];
        
        for (int i = 0; i < length; i++) {
            if (i >= L && i + M - 1 < length) {
                res = Math.max(res, lMax + sum[i + M - 1] - sum[i - 1]);
            }
            if (i >= M && i + L - 1 < length) {
                res = Math.max(res, mMax + sum[i + L - 1] - sum[i - 1]);
            }
            
            if (i >= L) {
                lMax = Math.max(lMax, sum[i] - sum[i - L]);
            }
            if (i >= M) {
                mMax = Math.max(mMax, sum[i] - sum[i - M]);
            }
        }
        
        return res;
    }
}
// https://leetcode.com/problems/get-maximum-in-generated-array/
// algorithms
// Easy (48.3%)
// Total Accepted: 8,052
// Total Submissions: 16,672
// beats 100.0% of java submissions


class Solution {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        
        int[] num = new int[n + 1];
        num[0] = 0;
        num[1] = 1;
        int res = 1;
        
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                num[i] = num[i / 2];
            } else {
                num[i] = num[i / 2] + num[i / 2 + 1];
            }
            
            res = Math.max(res, num[i]);
        }
        
        return res;
    }
}
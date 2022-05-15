// https://leetcode.com/problems/number-of-ways-to-split-array/
// algorithms
// Medium (40.19%)
// Total Accepted: 10,049
// Total Submissions: 25,000


class Solution {
    
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long[] l2r = new long[len];
        long[] r2l = new long[len];
        
        l2r[0] = nums[0];
        for (int i = 1; i < len; i++) {
            l2r[i] = l2r[i - 1] + nums[i];
        }
        
        for (int i = len - 2; i >= 0; i--) {
            r2l[i] = r2l[i + 1] + nums[i + 1];
        }
        
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            if (l2r[i] >= r2l[i]) {
                res++;
            }
        }
        
        return res;
    }
    
}
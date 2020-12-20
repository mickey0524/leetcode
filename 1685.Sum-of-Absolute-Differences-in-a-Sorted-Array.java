// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
// algorithms
// Medium (59.88%)
// Total Accepted: 5,553
// Total Submissions: 9,274


class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        
        for (int i = 1; i < len; i++) {
            leftToRight[i] = leftToRight[i - 1] + nums[i - 1];
        }
        
        for (int i = len - 2; i >= 0; i--) {
            rightToLeft[i] = rightToLeft[i + 1] + nums[i + 1];
        }
        
        int[] res = new int[len];
        
        res[0] = rightToLeft[0] - (len - 1) * nums[0];
        res[len - 1] = (len - 1) * nums[len - 1] - leftToRight[len - 1];
        for (int i = 1; i < len - 1; i++) {
            res[i] = Math.abs(leftToRight[i] - nums[i] * i) + Math.abs(rightToLeft[i] - nums[i] * (len - i - 1));
        }
        
        return res;
    }
}
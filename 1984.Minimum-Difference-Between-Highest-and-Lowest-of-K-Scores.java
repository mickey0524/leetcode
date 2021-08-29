// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
// algorithms
// Easy (53.9%)
// Total Accepted: 6.9K
// Total Submissions: 12.8K


class Solution {
    
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = nums[k - 1] - nums[0];
        int len = nums.length;
        
        for (int i = k; i < len; i++) {
            int tmp = nums[i] - nums[i - k + 1];
            res = Math.min(res, tmp);
        }
        
        return res;
    }
    
}
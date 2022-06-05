// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
// algorithms
// Medium (69.03%)
// Total Accepted: 10.7K
// Total Submissions: 15.5K


class Solution {
    
    public int partitionArray(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        
        Arrays.sort(nums);
        int res = 1;
        int curMin = nums[0];
        
        for (int i = 1; i < len; i++) {
            if (nums[i] - curMin > k) {
                res++;
                curMin = nums[i];
            }
        }
        
        return res;
    }
    
}
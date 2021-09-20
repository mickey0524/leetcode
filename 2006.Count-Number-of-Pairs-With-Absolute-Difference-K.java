// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
// algorithms
// Easy (85.88%)
// Total Accepted: 7.3K
// Total Submissions: 8.5K


class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        
        return res;
    }
}
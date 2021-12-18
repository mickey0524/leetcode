// https://leetcode.com/problems/sum-of-subarray-ranges/
// algorithms
// Medium (55.92%)
// Total Accepted: 8.5K
// Total Submissions: 15.2K


class Solution {
    
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long res = 0;
        int l = -1, r = -1;
        
        for (int i = 0; i < len; i++) {
            l = i - 1;
            r = i + 1;
            while (l >= 0 && nums[l] > nums[i]) {
                l--;
            }
            while (r < len && nums[r] >= nums[i]) {
                r++;
            }
            res -= (r - i) * (i - l) * (long) nums[i];
            
            l = i - 1;
            r = i + 1;
            while (l >= 0 && nums[l] < nums[i]) {
                l--;
            }
            while (r < len && nums[r] <= nums[i]) {
                r++;
            }
            res += (r - i) * (i - l) * (long) nums[i];
        }
        
        return res;
    }
    
}
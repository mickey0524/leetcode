// https://leetcode.com/problems/missing-number/
//
// algorithms
// Easy (48.10%)
// Total Accepted:    266,601
// Total Submissions: 554,267

class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        
        for (int i = 0; i < length; i++) {
            while (nums[i] != i && nums[i] < length) {
                swap(nums, nums[i], i);
            }
        }
        
        for (int i = 0; i < length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return length;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}

class Solution1 {
    public int missingNumber(int[] nums) {
        int res = 0, length = nums.length;
        
        for (int i = 0; i < length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        
        return res ^ length;
    }
}
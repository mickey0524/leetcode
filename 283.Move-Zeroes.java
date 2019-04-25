// https://leetcode.com/problems/move-zeroes/
//
// algorithms
// Easy (54.08%)
// Total Accepted:    450,301
// Total Submissions: 832,623
// beats 100.0% of java submissions

class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0, i = 0, len = nums.length;
        
        for (; i < len; i++) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        
        for (; idx < len; idx++) {
            nums[idx] = 0;
        }
        
    }
}
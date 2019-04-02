// https://leetcode.com/problems/jump-game/
//
// algorithms
// Medium (31.53%)
// Total Accepted:    246,679
// Total Submissions: 782,358
// beats 100.0% of java submissions


class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        
        if (length == 0) {
            return false;
        }
        
        if (length == 1) {
            return true;
        }
        
        int r = nums[0];
        for (int i = 0; i < length; i++) {
            if (r >= length - 1) {
                return true;
            }
            if (i > r + nums[r]) {
                return false;
            }
            if (i + nums[i] > r) {
                r = i + nums[i];
            }
        }
        
        return false;
    }
}
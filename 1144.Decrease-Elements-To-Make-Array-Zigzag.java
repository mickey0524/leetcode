// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
//
// algorithms
// Medium (35.79%)
// Total Accepted: 2,367
// Total Submissions: 6,614
// beats 100.0% of java submissions

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        
        return Math.min(compare(nums, true), compare(nums, false));
    }
    
    public int compare(int[] nums, boolean upper) {
        int len = nums.length;
        int res = 0, pre = nums[0];
        
        for (int i = 1; i < len; i++) {
            if (upper) {
                if (nums[i] <= pre) {
                    res += (pre - nums[i] + 1);
                }
                pre = nums[i];
            } else {
                if (nums[i] >= pre) {
                    res += (nums[i] - pre + 1);
                    pre = pre - 1;
                } else {
                    pre = nums[i];
                }
            }
            upper = !upper;
        }
        return res;
    }
}
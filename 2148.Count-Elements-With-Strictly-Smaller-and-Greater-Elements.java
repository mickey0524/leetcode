// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
// algorithms
// Easy (59.05%)
// Total Accepted: 10,280
// Total Submissions: 17,409


class Solution {
    
    public int countElements(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int l = 1;
        for (; l < len; l++) {
            if (nums[l] > nums[l - 1]) {
                break;
            }
        }
        
        int r = len - 2;
        for (; r >= 0; r--) {
            if (nums[r] < nums[r + 1]) {
                break;
            }
        }
        
        return r >= l ? r - l + 1 : 0;
    }
    
}
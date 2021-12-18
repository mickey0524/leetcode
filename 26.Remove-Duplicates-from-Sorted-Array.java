// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//
// algorithms
// Easy (47.38%)
// Total Accepted:    1.8M
// Total Submissions: 3.8M


class Solution {
    
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[res++] = nums[i];
            }
        }
        
        return res;
    }
    
}
// https://leetcode.com/problems/remove-element/description/
//
// algorithms
// Easy (41.9%)
// Total Accepted:    312.2k
// Total Submissions: 745.1k
// beats 100.00% of java submissions

class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int idx = 0;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        
        return idx;
    }
}
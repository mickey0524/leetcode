// https://leetcode.com/problems/find-peak-element/
//
// algorithms
// Medium (41.15%)
// Total Accepted:    233,327
// Total Submissions: 567,038
// beats 100.0% of java submissions

class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        
        int l = 0, r = len - 1, m = -1;
        
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}
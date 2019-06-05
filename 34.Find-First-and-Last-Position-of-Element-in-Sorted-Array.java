// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//
// algorithms
// Medium (33.6%)
// Total Accepted:    303,214
// Total Submissions: 902,428
// beats 100.00% of java submissions

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int start = -1, end = -1;
        
        int l = 0, r = len - 1, m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                if (m == 0 || nums[m - 1] != target) {
                    start = m;
                    break;
                } 
                r = m - 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (start == -1) {
            return new int[]{-1, -1};
        }
        
        l = 0;
        r = len - 1;
        m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                if (m == len - 1 || nums[m + 1] != target) {
                    end = m;
                    break;
                } 
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return new int[]{start, end};
    }
}
// https://leetcode.com/problems/search-in-rotated-sorted-array/
//
// algorithms
// Medium (32.88%)
// Total Accepted:    412,174
// Total Submissions: 1,253,675
// beats 100.00% of java submissions

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;

        int l = 0, r = len - 1, m = -1;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] >= nums[l]) {
                if (nums[m] > target && target >= nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
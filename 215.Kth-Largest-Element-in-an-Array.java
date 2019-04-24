// https://leetcode.com/problems/kth-largest-element-in-an-array/
//
// algorithms
// Medium (41.76%)
// Total Accepted:    356,466
// Total Submissions: 755,770

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return this.findKthLargest(nums, k, 0, nums.length - 1);
    }
    
    public int findKthLargest(int[] nums, int k, int l, int r) {
        int base = nums[r];
        int idx = l;

        for (int i = l; i < r; i++) {
            if (nums[i] > base) {
                this.swap(nums, idx, i);
                idx++;
            }
        }

        this.swap(nums, idx, r);
        int length = idx - l + 1;
        if (length == k) {
            return base;
        }

        if (length > k) {
            return this.findKthLargest(nums, k, l, idx - 1);
        }

        return this.findKthLargest(nums, k - length, idx + 1, r);
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
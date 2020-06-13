// https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
// algorithms
// Easy (52.75%)
// Total Accepted: 20,788
// Total Submissions: 39,412


class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int l = 0, r = len - 1, m = -1;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (l < 0 || l >= len || nums[l] != target) {
            return 0;
        }

        int leftIdx = l;
        r = len - 1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return r - leftIdx + 1;
    }
}
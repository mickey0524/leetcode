// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// algorithms
// Easy (82.33%)
// Total Accepted: 14,614
// Total Submissions: 17,750
// beats 100.0% of java submissions


class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        int st = Math.max(nums[0], nums[1]);
        int nd = Math.min(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            if (nums[i] > st) {
                nd = st;
                st = nums[i];
            } else if (nums[i] > nd) {
                nd = nums[i];
            }
        }

        return (st - 1) * (nd - 1);
    }
}
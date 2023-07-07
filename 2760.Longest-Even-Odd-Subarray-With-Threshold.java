// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
// algorithms
// Easy (27.55%)
// Total Accepted: 19.2K
// Total Submissions: 69.7K

class Solution {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        int len = nums.length;
        int preIdx = -1;
        int target = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] > threshold) {
                if (preIdx != -1) {
                    res = Math.max(res, i - preIdx);
                }

                preIdx = -1;
                target = 0;
            } else if (nums[i] % 2 == target) {
                if (preIdx == -1) {
                    preIdx = i;
                }
                target = 1 - target;
            } else {
                if (preIdx != -1) {
                    res = Math.max(res, i - preIdx);
                }

                if (target == 1) {
                    preIdx = i;
                } else {
                    preIdx = -1;
                }
            }
        }

        if (preIdx >= 0) {
            res = Math.max(res, len - preIdx);
        }

        return res;
    }
}
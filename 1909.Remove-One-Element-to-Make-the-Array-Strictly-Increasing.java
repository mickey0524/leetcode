// https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
// algorithms
// Easy (29.86%)
// Total Accepted: 6.6K
// Total Submissions: 22.1K


class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return true;
        }

        boolean skip = true;
        int preIdx = 0;
        boolean res = true;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[preIdx]) {
                if (skip) {
                    skip = false;
                } else {
                    res = false;
                    break;
                }
            } else {
                preIdx = i;
            }
        }

        if (res) {
            return res;
        }

        preIdx = 0;
        skip = true;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[preIdx]) {
                if (skip) {
                    skip = false;
                    preIdx = preIdx == 0 ? i : preIdx - 1;
                    if (preIdx != i && nums[i] <= nums[preIdx]) {
                        return false;
                    }

                    preIdx = i;
                } else {
                    return false;
                }
            } else {
                preIdx = i;
            }
        }

        return true;
    }
}
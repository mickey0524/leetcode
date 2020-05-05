// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
// algorithms
// Medium (68.12%)
// Total Accepted: 9,217
// Total Submissions: 13,531
// beats 100.0% of java submissions


class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int len = nums.length;
        int preIdx = -1;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 1) {
                continue;
            }

            if (preIdx != -1) {
                int interval = i - preIdx - 1;
                if (interval < k) {
                    return Boolean.FALSE;
                }
            }

            preIdx = i;
        }

        return Boolean.TRUE;
    }
}
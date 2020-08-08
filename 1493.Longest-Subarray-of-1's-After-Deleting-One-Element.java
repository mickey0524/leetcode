// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
// algorithms
// Medium (57.79%)
// Total Accepted: 7,745
// Total Submissions: 13,402
// beats 100.0% of java submissions


class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        int preStart = -1, preEnd = -1, idx = 0;
        while (idx < len) {
            if (nums[idx] == 0) {
                idx++;
                continue;
            }

            int tmpIdx = idx + 1;
            while (tmpIdx < len && nums[tmpIdx] == 1) {
                tmpIdx++;
            }

            if (preStart == -1 || (idx - preEnd) > 2) {
                res = Math.max(res, tmpIdx - idx);
            } else {
                res = Math.max(res, tmpIdx - idx + preEnd - preStart + 1);
            }

            preStart = idx;
            preEnd = tmpIdx - 1;
            idx = tmpIdx;
        }

        return Math.min(res, len - 1);
    }
}
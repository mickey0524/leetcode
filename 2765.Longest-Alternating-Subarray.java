// https://leetcode.com/problems/longest-alternating-subarray/
// algorithms
// Easy (32.6%)
// Total Accepted: 14.9K
// Total Submissions: 45.6K

class Solution {

    public int alternatingSubarray(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return -1;
        }

        int diff = 1;
        int curSubArrLen = 1;
        int res = -1;
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                curSubArrLen++;
                diff = -diff;
            } else if (curSubArrLen > 1) {
                res = Math.max(res, curSubArrLen);

                if (nums[i] - nums[i - 1] == -diff) {
                    curSubArrLen = 2;
                } else {
                    curSubArrLen = 1;
                    diff = 1;
                }
            }
        }

        if (curSubArrLen > 1) {
            res = Math.max(res, curSubArrLen);
        } 

        return res;
    }

}

// [14,30,29,49,3,23,44,21,26,52]
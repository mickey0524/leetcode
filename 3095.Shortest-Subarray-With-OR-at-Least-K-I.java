// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/description/
// algorithms
// Easy (37.3%)
// Total Accepted: 18.4K
// Total Submissions: 49.2K


class Solution {

    public int minimumSubarrayLength(int[] nums, int k) {
        int curOrRes = nums[0];
        if (curOrRes >= k) {
            return 1;
        }
        int len = nums.length;
        int res = len + 1;
        int preIdx = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] >= k) {
                return 1;
            }

            curOrRes |= nums[i];
            if (curOrRes >= k) {
                int tmp = nums[i];
                int tmp1 = nums[i];
                for (int j = i - 1; j >= preIdx; j--) {
                    tmp |= nums[j];
                    if (tmp >= k) {
                        preIdx = j;
                        res = Math.min(res, i - preIdx + 1);
                        curOrRes = tmp1;
                        break;
                    }
                    tmp1 |= nums[j];
                }
            }       
        }

        return res == len + 1 ? -1 : res;
    }

}
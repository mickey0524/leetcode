// https://leetcode.com/problems/max-consecutive-ones/
//
// algorithms
// Easy (55.76%)
// Total Accepted: 158,915
// Total Submissions: 284,984


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int tmp = 0;

        for (int n : nums) {
            if (n == 0) {
                res = Math.max(res, tmp);
                tmp = 0;
            } else {
                tmp++;
            }
        }

        return Math.max(res, tmp);
    }
}
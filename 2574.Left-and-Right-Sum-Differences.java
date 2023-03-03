// https://leetcode.com/problems/left-and-right-sum-differences/description/
// algorithms
// Easy (89.09%)
// Total Accepted: 24.5K
// Total Submissions: 27.5K


class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int len = nums.length;
        int[] l2r = new int[len];
        int[] r2l = new int[len];

        int l2rPreSum = 0;
        int r2lPreSum = 0;
        for (int i = 1; i < len; i++) {
            l2rPreSum += nums[i - 1];
            r2lPreSum += nums[len - i];
            l2r[i] = l2rPreSum;
            r2l[len - 1 - i] = r2lPreSum;
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Math.abs(l2r[i] - r2l[i]);
        }

        return res;
    }
}
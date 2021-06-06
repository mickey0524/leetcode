// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
// algorithms
// Easy (79.03%)
// Total Accepted: 10,772
// Total Submissions: 13,630


class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int i = 0, j = len - 1;

        while (i < j) {
            res = Math.max(res, nums[i] + nums[j]);

            i++;
            j--;
        }

        return res;
    }

}
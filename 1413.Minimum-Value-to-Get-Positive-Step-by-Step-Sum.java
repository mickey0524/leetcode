// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
// algorithms
// Easy (64.46%)
// Total Accepted: 5,770
// Total Submissions: 8,951
// beats 100.0% of java submissions


class Solution {
    public int minStartValue(int[] nums) {
        int curSum = 0, minSum = Integer.MAX_VALUE;
        for (int n : nums) {
            curSum += n;
            minSum = Math.min(minSum, curSum);
        }

        return minSum >= 0 ? 1 : 1 - minSum;
    }
}
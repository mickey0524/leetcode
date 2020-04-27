// https://leetcode-cn.com/problems/missing-number-lcci/
// algorithms
// Easy (63.6%)
// Total Accepted: 4,129
// Total Submissions: 6,492


class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, maxNum = -1;
        boolean zeroExist = false;
        for (int n : nums) {
            sum += n;
            maxNum = Math.max(maxNum, n);
            if (n == 0) {
                zeroExist = true;
            }
        }

        if (!zeroExist) {
            return 0;
        }

        int targetSum = (1 + maxNum) * maxNum / 2;

        if (targetSum == sum) {
            return maxNum + 1;
        }

        return targetSum - sum;
    }
}
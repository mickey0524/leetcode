// https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/description/
// algorithms
// Easy (57.4%)
// Total Accepted: 17.3K
// Total Submissions: 30.2K


class Solution {

    public int minimumPairRemoval(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        boolean isNonDecreasing = true;
        int curMinPairLeftIdx = 0;
        int curMinPairSum = nums[0] + nums[1];

        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                isNonDecreasing = false;
            }

            if (i < len - 1) {
                if (nums[i] + nums[i + 1] < curMinPairSum) {
                    curMinPairSum = nums[i] + nums[i + 1];
                    curMinPairLeftIdx = i;
                }
            } 
        }

        if (isNonDecreasing) {
            return 0;
        }

        int[] tmp = new int[len - 1];
        for (int i = 0; i < len; i++) {
            if (i == curMinPairLeftIdx) {
                tmp[i] = nums[i] + nums[i + 1];
            } else if (i == curMinPairLeftIdx + 1) {
                // nop
            } else if (i < curMinPairLeftIdx) {
                tmp[i] = nums[i];
            } else {
                tmp[i - 1] = nums[i];
            }
        }

        return 1 + minimumPairRemoval(tmp);
    }

}
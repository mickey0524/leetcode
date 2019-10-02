// https://leetcode.com/problems/non-decreasing-array/
//
// algorithms
// Easy (19.47%)
// Total Accepted: 64,190
// Total Submissions: 329,756
// beats 100.0% of java submissions


class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean change = false;
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (change) {
                    return false;
                } else {
                    if (i > 1) {
                        if (nums[i] < nums[i - 2]) {
                            nums[i] = nums[i - 1];
                        }
                    }
                    change = true;
                }
            }
        }

        return true;
    }
}
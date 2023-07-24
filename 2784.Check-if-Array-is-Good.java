// https://leetcode.com/problems/check-if-array-is-good/
// algorithms
// Easy (48.73%)
// Total Accepted: 21.1K
// Total Submissions: 43.3K


class Solution {

    public boolean isGood(int[] nums) {
        int len = nums.length;

        int[] flag = new int[len + 1];
        for (int n : nums) {
            if (n >= len) {
                return false;
            }

            flag[n] += 1;
            if (flag[n] > 1 && n != len - 1) {
                return false;
            }
        }

        for (int i = 1; i < len; i++) {
            if (flag[i] == 0) {
                return false;
            }
        }

        return flag[len - 1] == 2;
    }

}
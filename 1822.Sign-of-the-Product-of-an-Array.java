// https://leetcode.com/problems/sign-of-the-product-of-an-array/
// algorithms
// Easy (67.38%)
// Total Accepted: 6,556
// Total Submissions: 9,730


class Solution {
    public int arraySign(int[] nums) {
        int flag = 1;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }

            if (n > 0) {
                flag *= 1;
            } else {
                flag *= -1;
            }
        }

        return flag;
    }
}
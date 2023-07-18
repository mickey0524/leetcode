// https://leetcode.com/problems/sum-of-squares-of-special-elements/
// algorithms
// Easy (78.64%)
// Total Accepted: 24.3K
// Total Submissions: 30.9K

class Solution {

    public int sumOfSquares(int[] nums) {
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (len % (i + 1) == 0) {
                res += nums[i] * nums[i];
            }
        }

        return res;
    }

}
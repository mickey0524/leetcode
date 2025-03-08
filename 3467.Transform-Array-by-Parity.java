// https://leetcode.com/problems/transform-array-by-parity/description/
// algorithms
// Easy (88.4%)
// Total Accepted: 32.3K
// Total Submissions: 36.6K


class Solution {

    public int[] transformArray(int[] nums) {
        int len = nums.length;
        int evenNum = 0;

        for (int n : nums) {
            if ((n & 1) == 0) {
                evenNum += 1;
            }
        }    

        int[] res = new int[len];
        for (int i = evenNum; i < len; i++) {
            res[i] = 1;
        }

        return res;
    }

}
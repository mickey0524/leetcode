// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/
// algorithms
// Easy (84.2%)
// Total Accepted: 35.1K
// Total Submissions: 41.7K


class Solution {

    public int minOperations(int[] nums, int k) {
        int res = 0;

        for (int n : nums) {
            if (n < k) {
                res++;
            }
        }
        
        return res;
    }

}
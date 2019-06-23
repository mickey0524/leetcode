// https://leetcode.com/problems/single-number/
//
// algorithms
// Medium (31.93%)
// Total Accepted: 474,769
// Total Submissions: 785,782
// beats 100.0% of java submissions

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int n : nums) {
            xor ^= n;
        }

        return xor;
    }
}
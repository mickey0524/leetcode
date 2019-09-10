// https://leetcode.com/problems/sum-of-two-integers/
//
// algorithms
// Easy (50.8%)
// Total Accepted:    147,086
// Total Submissions: 289,545


class Solution {
    public int getSum(int a, int b) {
        int and_res = a & b, xor_res = a ^ b;

        while (and_res != 0) {
            int tmp = and_res << 1;
            and_res = tmp & xor_res;
            xor_res = xor_res ^ tmp;
        }

        return xor_res;
    }
}
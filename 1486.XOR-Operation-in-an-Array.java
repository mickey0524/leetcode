// https://leetcode.com/problems/xor-operation-in-an-array/
// algorithms
// Easy (89.44%)
// Total Accepted: 10,272
// Total Submissions: 11,485


class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            res ^= (start + 2 * i);
        }

        return res;
    }
}
// https://leetcode.com/problems/reverse-bits/
//
// algorithms
// Easy (31.01%)
// Total Accepted:    178,136
// Total Submissions: 574,497
// beats 100.0% of java submissions

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res ^= (n & 1);
            n >>= 1;
        }
        
        return res;
    }
}
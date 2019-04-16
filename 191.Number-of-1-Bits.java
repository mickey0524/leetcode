// https://leetcode.com/problems/number-of-1-bits/
//
// algorithms
// Easy (42.63%)
// Total Accepted:    250,314
// Total Submissions: 587,142

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        
        return res;
    }
}
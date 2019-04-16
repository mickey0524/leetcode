// https://leetcode.com/problems/bitwise-and-of-numbers-range/
//
// algorithms
// Medium (35.71%)
// Total Accepted:    79,489
// Total Submissions: 222,588
// beats 100.0% of java submissions

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            res++;
        }
        
        return m << res;
    }
}
// https://leetcode.com/problems/majority-element/
//
// algorithms
// Easy (37.34%)
// Total Accepted:    154,331
// Total Submissions: 413,341
// beats 100.0% of java submissions

class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        
        return n / 5 + trailingZeroes(n / 5);
    }
}
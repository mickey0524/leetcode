// https://leetcode.com/problems/sum-of-square-numbers/
//
// algorithms
// Easy (32.8%)
// Total Accepted:    40,687
// Total Submissions: 124,024
// beats 100.0% of java submissions

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c <= 2) {
            return true;
        }
        
        int l = 0;
        int r = (int) Math.sqrt(c) + 1;
        
        while (l <= r) {
            int s = l * l + r * r;
            if (s == c) {
                return true;
            } else if (s > c) {
                r--;
            } else {
                l++;
            }
        }
        
        return false;
    }
}
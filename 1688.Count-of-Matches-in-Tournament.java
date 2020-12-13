// https://leetcode.com/problems/count-of-matches-in-tournament/
// algorithms
// Easy (83.94%)
// Total Accepted: 5,565
// Total Submissions: 6,630


class Solution {
    public int numberOfMatches(int n) {
        int res = 0;
        
        while (n > 1) {
            int tmp = n / 2;
            
            
            res += tmp;
            n -= tmp;
        }
        
        return res;
    }
}
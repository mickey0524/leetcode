// https://leetcode.com/problems/a-number-after-a-double-reversal/
// algorithms
// Easy (78.54%)
// Total Accepted: 7,543
// Total Submissions: 9,604


class Solution {
    
    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        
        return (num % 10) != 0;
    }
    
}
// https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/description/
// algorithms
// Easy (67.02%)
// Total Accepted: 19.1K
// Total Submissions: 28.5K


class Solution {
    
    public boolean hasTrailingZeros(int[] nums) {
        int num = 0;
        
        for (int n : nums) {
            if ((n & 1) == 0) {
                num += 1;
                
                if (num > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
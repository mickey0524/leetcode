// https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/
// algorithms
// Easy (50.25%)
// Total Accepted: 11,085
// Total Submissions: 22,060

class Solution {
    
    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }   
        
        if (n % 2 == 0) {
            return n / 2;
        }
        
        return n;
    }
    
}
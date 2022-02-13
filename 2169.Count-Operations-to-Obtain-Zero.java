// https://leetcode.com/problems/count-operations-to-obtain-zero/
// algorithms
// Easy (72.71%)
// Total Accepted: 11,369
// Total Submissions: 15,637


class Solution {
    
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        
        if (num1 >= num2) {
            return countOperations(num1 - num2, num2) + 1;
        }
        
        return countOperations(num1, num2 - num1) + 1;
    }
    
}
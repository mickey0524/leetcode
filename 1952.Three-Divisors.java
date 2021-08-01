// https://leetcode.com/problems/three-divisors/
// algorithms
// Easy (55.64%)
// Total Accepted: 7.4K
// Total Submissions: 13.3K


class Solution {
    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }
        
        int tmp = (int) Math.sqrt(n);
        if (tmp * tmp != n) {
            return false;
        }
        
        for (int i = 2; i < tmp; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
// https://leetcode.com/problems/alternating-digit-sum/
// algorithms
// Easy (71.8%)
// Total Accepted: 26.5K
// Total Submissions: 37.9K

class Solution {
    
    public int alternateDigitSum(int n) {
        int res = 0;
        int bitNum = 0;
        boolean isPositive = true;

        while (n != 0) {
            int tmp = n % 10;
            
            if (isPositive) {
                res += tmp;
            } else {
                res -= tmp;
            }

            bitNum += 1;
            n = n / 10;
            isPositive = !isPositive;
        }

        if ((bitNum & 1) == 0) {
            return -res;
        } else {
            return res;
        }
    }

}
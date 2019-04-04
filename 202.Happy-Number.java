// https://leetcode.com/problems/two-sum/description/
//
// algorithms
// Easy (44.61%)
// Total Accepted:    220,976
// Total Submissions: 495,311

class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        
        while (!set.contains(n)) {
            set.add(n);
            int nextN = getDigitSum(n);
            if (nextN == 1) {
                return true;
            } 
            n = nextN;
        }
        
        return false;
    }
    
    public int getDigitSum(int n) {
        int res = 0;
        
        while (n != 0) {
            int remainder = n % 10;
            res += (remainder * remainder);
            n /= 10;
        }
        
        return res;
    }
}
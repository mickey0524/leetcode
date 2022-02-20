// https://leetcode.com/problems/count-integers-with-even-digit-sum/
// algorithms
// Easy (62.58%)
// Total Accepted: 10,177
// Total Submissions: 16,262


class Solution {
    
    public int countEven(int num) {
        int res = 0;
        
        for (int i = 1; i <= num; i++) {
            if ((getBitSum(i) & 1) == 0) {
                res++;
            }
        }
        
        return res;
    }
    
    private int getBitSum(int num) {
        String s = String.valueOf(num);
        int res = 0;

        for (char ch : s.toCharArray()) {
            res += (ch - '0');
        }
        
        return res;
    }
    
}
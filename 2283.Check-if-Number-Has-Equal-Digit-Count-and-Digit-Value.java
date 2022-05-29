// https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
// algorithms
// Easy (72.63%)
// Total Accepted: 13.8K
// Total Submissions: 19K


class Solution {
    
    public boolean digitCount(String num) {
        int[] cntArr = new int[10];
        for (char ch : num.toCharArray()) {
            cntArr[ch - '0']++;
        }
        
        int len = num.length();
        for (int i = 0; i < len; i++) {
            if ((int) (num.charAt(i) - '0') != cntArr[i]) {
                return false;
            }
        }
        
        return true;
    }
    
}
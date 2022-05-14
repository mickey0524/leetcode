// https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
// algorithms
// Easy (46.06%)
// Total Accepted: 17,104
// Total Submissions: 37,138


class Solution {
    
    public String removeDigit(String number, char digit) {
        int digitIdx = -1;
        int len = number.length();
        
        for (int i = 0; i < len; i++) {
            char ch = number.charAt(i);
            if (ch == digit) {
                digitIdx = i;
                if (i < len - 1 && number.charAt(i + 1) > ch) {
                    return number.substring(0, i) + number.substring(i + 1);
                }
            }
        }
        
        return number.substring(0, digitIdx) + number.substring(digitIdx + 1);
    }
    
}
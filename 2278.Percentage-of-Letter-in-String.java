// https://leetcode.com/problems/percentage-of-letter-in-string/
// algorithms
// Easy (70.23%)
// Total Accepted: 12,654
// Total Submissions: 18,019


class Solution {
    
    public int percentageLetter(String s, char letter) {
        int sLen = s.length(), letterNum = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                letterNum++;
            }
        }
        
        return (int) (letterNum * 100 / sLen);
    }
    
}
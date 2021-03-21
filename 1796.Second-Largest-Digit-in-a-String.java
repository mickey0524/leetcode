// https://leetcode.com/problems/second-largest-digit-in-a-string/
// algorithms
// Easy (46.38%)
// Total Accepted: 5,076
// Total Submissions: 10,945


class Solution {
    public int secondHighest(String s) {
        char[] chArr = s.toCharArray();
        int st = -1, rd = -1;

        for (char ch : chArr) {
            if (!Character.isDigit(ch)) {
                continue;
            }
            
            int n = ch - '0';
            if (n > st) {
                rd = st;
                st = n;
            } else if (n > rd && n != st) {
                rd = n;
            }
        }
        
        return rd;
    }
}
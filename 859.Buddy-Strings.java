// https://leetcode.com/problems/buddy-strings/
//
// algorithms
// Easy (27.45%)
// Total Accepted:    22,105
// Total Submissions: 80,533
// beats 100.0% of java submissions

class Solution {
    public boolean buddyStrings(String A, String B) {
        int ALen = A.length();
        int BLen = B.length();
        
        if (ALen != BLen) {
            return false;
        }
        
        int diff = 0;
        int idx[] = new int[3];
        int ch[] = new int[26];
        boolean hasDuplicate = false;
        for (int i = 0; i < ALen; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                idx[diff++] = i;
                if (diff > 2) {
                    return false;
                }
            }
            if (!hasDuplicate) {
                ch[A.charAt(i) - 'a']++;
                if (ch[A.charAt(i) - 'a'] == 2) {
                    hasDuplicate = true;
                }
            }
        }
        
        if (diff == 2) {
            if (B.charAt(idx[0]) == A.charAt(idx[1]) && B.charAt(idx[1]) == A.charAt(idx[0])) {
                return true;
            }
            return false;
        }
        if (diff == 1) {
            return false;
        }
        
        return hasDuplicate;        
    }
}
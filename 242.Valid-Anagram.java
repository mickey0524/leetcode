// https://leetcode.com/problems/valid-anagram/
//
// algorithms
// Easy (51.35%)
// Total Accepted:    314,951
// Total Submissions: 613,292
// beats 100.0% of java submissions

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int chs[] = new int[26];
        
        for (char ch : s.toCharArray()) {
            chs[ch - 'a'] += 1;
        }
        
        for (char ch : t.toCharArray()) {
            chs[ch - 'a'] -= 1;
            if (chs[ch - 'a'] < 0) {
                return false;
            } 
        }
        
        for (int i : chs) {
            if (i != 0) {
                return false;
            }
        }
        
        return true;
    }
}
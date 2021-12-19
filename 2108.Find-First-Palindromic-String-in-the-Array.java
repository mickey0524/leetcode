// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
// algorithms
// Easy (83.02%)
// Total Accepted: 7,902
// Total Submissions: 9,518


class Solution {
    
    public String firstPalindrome(String[] words) {
        for (String w : words) {
            if (isPalindrome(w)) {
                return w;
            }
        }
        
        return "";
    }
    
    private boolean isPalindrome(String w) {
        int len = w.length();
        int l = 0, r = len - 1;
        
        while (l < r) {
            if (w.charAt(l) != w.charAt(r)) {
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
    
}
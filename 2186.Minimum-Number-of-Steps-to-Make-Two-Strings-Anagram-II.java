// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
// algorithms
// Easy (67.09%)
// Total Accepted: 12,335
// Total Submissions: 18,387


class Solution {
    
    public int minSteps(String s, String t) {
        int[] sChCount = countChar(s);
        int[] tChCount = countChar(t);
        
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(sChCount[i] - tChCount[i]);
        }
        
        return res;
    }
    
    private int[] countChar(String s) {
        int[] res = new int[26];
        
        for (char ch : s.toCharArray()) {
            res[ch - 'a']++;
        }
        
        return res;
    }
    
}
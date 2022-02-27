// https://leetcode.com/problems/counting-words-with-a-given-prefix/
// algorithms
// Easy (76.45%)
// Total Accepted: 13,593
// Total Submissions: 17,780


class Solution {
    
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        int prefixLen = pref.length();
        
        for (String w : words) {
            int wLen = w.length();
            if (prefixLen > wLen) {
                continue;
            }
            
            if (pref.equals(w.substring(0, prefixLen))) {
                res++;
            }
        }
        
        return res;
    }
    
}
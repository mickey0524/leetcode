// https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/
// algorithms
// Easy (83%)
// Total Accepted: 57.3K
// Total Submissions: 69K


class Solution {

    public boolean isAcronym(List<String> words, String s) {
        int wordSize = words.size();
        int sLen = s.length();

        if (wordSize != sLen) {
            return false;
        }
        
        int idx = 0;
        for (String w : words) {
            if (w.charAt(0) != s.charAt(idx)) {
                return false;
            }
            
            idx++;
        }
        
        return true;
    }

}
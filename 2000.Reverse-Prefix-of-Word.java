// https://leetcode.com/problems/reverse-prefix-of-word/
// algorithms
// Easy (80.9%)
// Total Accepted: 7.2K
// Total Submissions: 8.9K


class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = -1;
        int len = word.length();
        
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == ch) {
                idx = i;
                break;
            }
        }
        
        if (idx != -1) {
            StringBuilder sb = new StringBuilder();
            for (int i = idx; i >= 0; i--) {
                sb.append(word.charAt(i));
            }
            sb.append(word.substring(idx + 1));
            
            return sb.toString();
        }
        
        return word;
    }
}
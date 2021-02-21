// https://leetcode.com/problems/merge-strings-alternately/
// algorithms
// Easy (85.2%)
// Total Accepted: 6,913
// Total Submissions: 8,114


class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        while (idx < Math.min(len1, len2)) {
            sb.append(word1.charAt(idx));
            sb.append(word2.charAt(idx));
            idx++;
        }
        
        sb.append(idx == len1 ? word2.substring(idx) : word1.substring(idx));
        
        return sb.toString();
    }
}
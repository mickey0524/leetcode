// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
// algorithms
// Medium (70.79%)
// Total Accepted: 6.3K
// Total Submissions: 8.9K


class Solution {
    
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int idx, pLen = part.length();
        while ((idx = s.indexOf(part)) != -1) {
            sb.append(s, 0, idx).append(s.substring(idx + pLen));
            s = sb.toString();
            sb.setLength(0);
        }
        
        return s;
    }
    
}
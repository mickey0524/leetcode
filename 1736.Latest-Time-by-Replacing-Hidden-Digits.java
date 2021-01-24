// https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
// algorithms
// Easy (40.85%)
// Total Accepted: 6,769
// Total Submissions: 16,570


class Solution {
    
    private static final int[] MAX_CH = new int[]{2, 9, -1, 5, 9};
    
    private static final char MARK = '?';
    
    private static final String SEPARATOR = ":";
    
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for (char ch : time.toCharArray()) {
            if (ch == MARK) {
                if (idx == 0 && time.charAt(1) != MARK && time.charAt(1) >= '4') {
                    sb.append('1');
                } else if (idx == 1 && sb.charAt(0) == '2') {
                    sb.append('3');
                } else {
                    sb.append(MAX_CH[idx]);
                }                    
            } else {
                sb.append(ch);
            }
            
            idx++;
        }
        
        return sb.toString();
    }
    
}
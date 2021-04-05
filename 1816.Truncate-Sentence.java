// https://leetcode.com/problems/truncate-sentence/
// algorithms
// Easy (78.79%)
// Total Accepted: 7,660
// Total Submissions: 9,722


class Solution {
    
    private static final char SPACE = ' ';
    
    public String truncateSentence(String s, int k) {
        int curSpace = 0;
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        
        for (int i = 0; i < len; i++) {
            if (chArr[i] == ' ') {
                curSpace++;
                if (curSpace == k) {
                    return s.substring(0, i);
                }
            }
        }
        
        return s;
    }
}
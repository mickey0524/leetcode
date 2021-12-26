// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
// algorithms
// Easy (86.82%)
// Total Accepted: 6,930
// Total Submissions: 7,982


class Solution {
    
    public int mostWordsFound(String[] sentences) {
        int res = Integer.MIN_VALUE;
        
        for (String s : sentences) {
            res = Math.max(res, calWordLen(s));
        }
        
        return res;
    }
    
    private int calWordLen(String s) {
        String[] arr = s.split(" ");
        
        return arr.length;
    }
    
}
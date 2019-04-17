// https://leetcode.com/problems/number-of-segments-in-a-string/
//
// algorithms
// Easy (36.80%)
// Total Accepted:    53,638
// Total Submissions: 145,761
// beats 100.0% of java submissions


class Solution {
    public int countSegments(String s) {
        int length = s.length();
        char[] chs = s.toCharArray();
        int res = 0;
        
        for (int i = 0; i < length; i++) {
            if (chs[i] != ' ' && (i == 0 || chs[i - 1] == ' ')) {
                res++;
            }   
        }
        
        return res;
    }
}
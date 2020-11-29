// https://leetcode.com/problems/maximum-repeating-substring/
// algorithms
// Easy (37.53%)
// Total Accepted: 3,751
// Total Submissions: 9,994
// beats 100.0% of java submissions


class Solution {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        int sLen = sequence.length(), wLen = word.length();
        int idx = 0;
        
        while (idx <= sLen - wLen) {
            if (word.equals(sequence.substring(idx, idx + wLen))) {
                int tmp = 1, j = idx + wLen;
                while (j < sLen && word.equals(sequence.substring(j, Math.min(j + wLen, sLen)))) {
                    j += wLen;
                    tmp++;
                }
                res = Math.max(res, tmp);
            }
            
            idx++;
        }
        
        return res;
    }
}
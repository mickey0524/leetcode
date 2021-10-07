// https://leetcode.com/problems/minimum-moves-to-convert-string/
// algorithms
// Easy (51.05%)
// Total Accepted: 9.7K
// Total Submissions: 19K


class Solution {
    
    public int minimumMoves(String s) {
        char[] chArr = s.toCharArray();
        int res = 0;
        int len = chArr.length;
        int idx = 0;
        
        while (idx < len) {
            if (chArr[idx] == 'O') {
                idx++;
                continue;
            }
            
            int tmp = Math.min(len, idx + 3);
            for (int i = idx; i < tmp; i++) {
                chArr[i] = 'O';
            }
            
            idx += 3;
            res++;
        }
        
        return res;
    }
    
}
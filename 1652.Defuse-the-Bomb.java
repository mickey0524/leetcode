// https://leetcode.com/problems/defuse-the-bomb/
// algorithms
// Easy (71.39%)
// Total Accepted: 3,364
// Total Submissions: 4,712
// beats 100.0% of java submissions


class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        if (len == 0 || k == 0) {
            return res;
        }
        
        for (int i = 0; i < len; i++) {
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    res[i] += code[(j + i) % len];
                }    
            } else {
                for (int j = 1; j <= -k; j++) {
                    int idx = i - j;
                    if (idx < 0) {
                        idx += len;
                    }
                    
                    res[i] += code[idx];
                }
            }
        }
        
        return res;
    }
}
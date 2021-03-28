// https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
//
// algorithms
// Medium (69.64%)
// Total Accepted:    4,584
// Total Submissions: 6,582
// beats 100.0% of java submissions


class Solution {
    public int reinitializePermutation(int n) {
        int res = 0;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        
        boolean isOk = true;
        while (true) {
            res++;
            isOk = true;
            
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 1) {
                    tmp[i] = perm[n / 2 + (i - 1) / 2];
                } else {
                    tmp[i] = perm[i / 2];
                }
                
                if (tmp[i] != i) {
                    isOk = false;
                }
            }
            
            if (isOk) {
                break;
            }
            
            perm = tmp;
        }
        
        return res;
    }
}
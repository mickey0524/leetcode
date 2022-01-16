// https://leetcode.com/problems/minimum-moves-to-reach-target-score/
// algorithms
// Medium (44.91%)
// Total Accepted: 8977
// Total Submissions: 19991


class Solution {
    
    public int minMoves(int target, int maxDoubles) {
        if (maxDoubles == 0) {
            return target - 1;
        }
        
        int res = 0;
        for (int i = 0; i < maxDoubles; i++) {
            if (target == 1) {
                return res;
            }
            
            if ((target & 1) == 1) {
                res++;
                target--;
            }
            
            if (target == 1) {
                return res;
            }
            
            target >>>= 1;
            res++;
        }
        
        return res + (target - 1);
    }
    
}
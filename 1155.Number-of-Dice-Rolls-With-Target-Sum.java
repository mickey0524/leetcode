// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
//
// algorithms
// Medium (48.83%)
// Total Accepted: 2,289
// Total Submissions: 4,688
// beats 100.0% of java submissions

class Solution {
    
    private int optionNum;
    private int modulo = 1000000007;
    
    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) {
            return 0;
        }
        
        int length = d * f + 1;
        int[] num = new int[length];
        
        for (int i = 1; i <= f; i++) {
            num[i] = 1;
        }
        
        for (int i = 2; i <= d; i++) {
            int[] tmp = new int[length];
            for (int j = i - 1; j <= (i - 1) * f; j++) {
                for (int k = 1; k <= f; k++) {
                    tmp[j + k] += num[j];
                    if (tmp[j + k] >= modulo) {
                        tmp[j + k] -= modulo;
                    }  
                }
            }
            copy(tmp, num);
        }
        
        return num[target];
    }
    
    public void copy(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }
   
}
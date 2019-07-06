// https://leetcode.com/problems/ugly-number-ii/
//
// algorithms
// Medium (36.71%)
// Total Accepted:    107,559
// Total Submissions: 292,988


class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        
        int[] res = new int[n];
        res[0] = 1;
        int two = 0, three = 0, five = 0;
        
        for (int i = 1; i < n; i++) {
            int twoTmp = 2 * res[two], threeTmp = 3 * res[three], fiveTmp = 5 * res[five];
            int curMin = Math.min(Math.min(twoTmp, threeTmp), fiveTmp);
            res[i] = curMin;
            
            if (twoTmp <= curMin) {
                two++;
            }
            if (threeTmp <= curMin) {
                three++;
            }
            if (fiveTmp <= curMin) {
                five++;
            }
        }
        
        return res[n - 1];
    }
}
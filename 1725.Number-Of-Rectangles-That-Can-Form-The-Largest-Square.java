// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
// algorithms
// Easy (75.56%)
// Total Accepted: 5,474
// Total Submissions: 7,245


class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int l = Integer.MIN_VALUE;
        int res = 0;
        
        for (int[] r : rectangles) {
            int tmp = Math.min(r[0], r[1]);
            if (tmp > l) {
                l = tmp;
                res = 1;
            } else if (tmp == l) {
                res++;
            }
        }
        
        return res;
    }
}
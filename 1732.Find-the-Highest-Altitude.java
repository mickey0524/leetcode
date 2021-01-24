// https://leetcode.com/problems/find-the-highest-altitude/
// algorithms
// Easy (82.01%)
// Total Accepted: 6,862
// Total Submissions: 8,367


class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int h = 0;
        
        for (int n : gain) {
            h += n;
            res = Math.max(res, h);
        }
        
        return res;
    }
}
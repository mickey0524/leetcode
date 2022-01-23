// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
// algorithms
// Easy (57.6%)
// Total Accepted: 11,423
// Total Submissions: 19,830


class Solution {
    
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int len = cost.length;
        if (len < 3) {
            return sum(cost);
        }
        
        int res = 0;
        for (int i = len - 1; i >= 0; i -= 3) {
            res += cost[i];
            if (i > 0) {
                res += cost[i - 1];
            }
        }
        
        return res;
    }
    
    private int sum(int[] cost) {
        int res = 0;
        
        for (int n : cost) {
            res += n;
        }
        
        return res;
    }
    
}
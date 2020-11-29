// https://leetcode.com/problems/richest-customer-wealth/
// algorithms
// Easy (95.18%)
// Total Accepted: 6,080
// Total Submissions: 6,388
// beats 100.0% of java submissions


class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        
        for (int[] arr : accounts) {
            int tmp = sum(arr);
            res = Math.max(res, tmp);
        }
        
        return res;
    }
    
    private int sum(int[] arr) {
        int res = 0;
        
        for (int n : arr) {
            res += n;
        }
        
        return res;
    }
}
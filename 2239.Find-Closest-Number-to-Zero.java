// https://leetcode.com/problems/find-closest-number-to-zero/
// algorithms
// Easy (46.36%)
// Total Accepted: 16,901
// Total Submissions: 36,453


class Solution {
    
    public int findClosestNumber(int[] nums) {
        int res = -1, diff = Integer.MAX_VALUE;
        
        for (int n : nums) {
            int absN = Math.abs(n);
            if (absN < diff) {
                res = n;
                diff = absN;
            } else if (absN == diff && n > res) {
                res = n;
            }
        }
        
        return res;
    }
    
}
// https://leetcode.com/problems/find-greatest-common-divisor-of-array/
// algorithms
// Easy (83.1%)
// Total Accepted: 6.9K
// Total Submissions: 8.3K


class Solution {
    public int findGCD(int[] nums) {
        int maxNum = nums[0], minNum = nums[0];
        int len = nums.length;
        
        for (int i = 1; i < len; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            minNum = Math.min(minNum, nums[i]);
        }
        
        return gcd(maxNum, minNum);
    }
    
    private int gcd(int a, int b) {
        int tmp = a % b;
        if (tmp == 0) {
            return b;
        }
        
        return gcd(b, tmp);
    }
}
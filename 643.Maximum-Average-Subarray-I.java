// https://leetcode.com/problems/maximum-average-subarray-i/
//
// algorithms
// Easy (39.14%)
// Total Accepted:    47,855
// Total Submissions: 122,262
// beats 100.0% of java submissions

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curSum = 0;
        int length = nums.length;
        
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        
        int res = curSum;
        
        for (int i = k, beforeIdx = 0; i < length; i++, beforeIdx++) {
            curSum = curSum - nums[beforeIdx] + nums[i];
            res = Math.max(curSum, res);
        }
        
        return (double) res / k;
    }
}


class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int curSum = 0;

        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }

        int tmp = curSum;
        for (int i = k; i < len; i++) {
            tmp += nums[i] - nums[i - k];
            curSum = Math.max(curSum, tmp);
        }

        return (double) curSum / k;
    }
}
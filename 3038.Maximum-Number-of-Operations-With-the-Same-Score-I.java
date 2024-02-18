// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/description/
// algorithms
// Easy (48.6%)
// Total Accepted: 21.1K
// Total Submissions: 43.5K


class Solution {

    public int maxOperations(int[] nums) {
        int res = 1;
        int opScore = nums[0] + nums[1];
        int len = nums.length;
        
        for (int i = 2; i < len; i += 2) {
            if (i == len - 1) {
                break;
            }
            
            if (nums[i] + nums[i + 1] != opScore) {
                break;
            }
            
            res += 1;
        }
        
        return res;
    }

}
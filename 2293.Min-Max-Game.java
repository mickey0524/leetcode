// https://leetcode.com/problems/min-max-game/
// algorithms
// Easy (61.43%)
// Total Accepted: 13.7K
// Total Submissions: 22.3K


class Solution {
    
    public int minMaxGame(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        
        int size = len / 2;
        int[] res = new int[size];
        for (int i = 0; i < len; i += 2) {
            int idx = i / 2;
            if (idx % 2 == 0) {
                res[idx] = Math.min(nums[i], nums[i + 1]);
            } else {
                res[idx] = Math.max(nums[i], nums[i + 1]);
            }
        }
        
        return minMaxGame(res);
    }
    
}
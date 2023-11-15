// https://leetcode.com/problems/maximum-strong-pair-xor-i/description/
// algorithms
// Easy (74.9%)
// Total Accepted: 15.9K
// Total Submissions: 21.2K

class Solution {

    public int maximumStrongPairXor(int[] nums) {
        int res = 0;
        int length = nums.length;
        if (length == 1) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] - nums[i] > nums[i]) {
                    break;
                }
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        
        return res;
    }

}
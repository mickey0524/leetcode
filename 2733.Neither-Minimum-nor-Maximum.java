// https://leetcode.com/problems/neither-minimum-nor-maximum/
// algorithms
// Easy (79.4%)
// Total Accepted: 39.4K
// Total Submissions: 49.6K

class Solution {

    public int findNonMinOrMax(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return -1;
        }

        Arrays.sort(nums);
        return nums[1];
    }

}
// https://leetcode.com/problems/maximum-product-of-three-numbers/
//
// algorithms
// Easy (46.78%)
// Total Accepted: 92,233
// Total Submissions: 197,156

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int sum1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int sum2 = nums[0] * nums[1] * nums[len - 1];

        return Math.max(sum1, sum2);
    }
}
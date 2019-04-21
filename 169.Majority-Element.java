// https://leetcode.com/problems/majority-element/
//
// algorithms
// Easy (52.16%)
// Total Accepted:    368,798
// Total Submissions: 707,068
// beats 100.0% of java submissions

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
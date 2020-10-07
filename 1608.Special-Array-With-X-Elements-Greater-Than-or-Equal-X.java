// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
// algorithms
// Easy (63.27%)
// Total Accepted: 8,658
// Total Submissions: 13,685
// beats 100.0% of java submissions


class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = len; i > 0; i--) {
            if (nums[len - i] >= i) {
                if (i != len && nums[len - i - 1] >= i) {
                    continue;
                }

                return i;
            }
        }

        return -1;
    }
}

// 0 0 3 4 4
// 0 3 6 7 7
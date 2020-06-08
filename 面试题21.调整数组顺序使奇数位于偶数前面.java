// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
// algorithms
// Easy (63.9%)
// Total Accepted: 26,487
// Total Submissions: 41,453


class Solution {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int preIdx = 0;

        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                swap(nums, preIdx, i);
                preIdx++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
// algorithms
// Easy (43.67%)
// Total Accepted: 13,843
// Total Submissions: 31,702
// beats 100.0% of java submissions


class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroNum = 0;
        for (int n : nums) {
            if (n == 0) {
                zeroNum++;
            }
        }

        int len = nums.length;
        int idx = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            return true;
        }
        idx++;

        for (; idx < len; idx++) {
            if (nums[idx] == nums[idx - 1]) {
                return false;
            }
            if (nums[idx] != nums[idx - 1] + 1) {
                zeroNum -= (nums[idx] - nums[idx - 1] - 1);
                if (zeroNum < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
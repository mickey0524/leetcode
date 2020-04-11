// https://leetcode-cn.com/problems/find-majority-element-lcci/
// algorithms
// Easy (63.76%)
// Total Accepted: 3,075
// Total Submissions: 4,823


class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int curNum = nums[0], times = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == curNum) {
                times++;
            } else {
                times--;
            }

            if (times == 0) {
                curNum = nums[i];
                times = 1;
            }
        }

        times = 0;
        for (int n : nums) {
            if (n == curNum) {
                times++;
            }
        }

        return times > len / 2 ? curNum : -1;
    }
}
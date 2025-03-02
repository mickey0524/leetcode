// https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/
// algorithms
// Easy (36.7%)
// Total Accepted: 20.5K
// Total Submissions: 56K

class Solution {

    public int largestInteger(int[] nums, int k) {
        int len = nums.length;
        if (k == len) {
            int res = -1;
            for (int n : nums) {
                res = Math.max(res, n);
            }
            return res;
        } else if (k == 1) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            int res = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    res = Math.max(res, entry.getKey());
                }
            }

            return res;
        }

        if (nums[0] == nums[len - 1]) {
            return -1;
        }

        boolean firstOut = false;
        boolean lastOut = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[0]) {
                firstOut = true;
            }
            if (nums[len - 1 - i] == nums[len - 1]) {
                lastOut = true;
            }
        }

        if (firstOut && lastOut) {
            return -1;
        }

        if (firstOut) {
            return nums[len - 1];
        }

        if (lastOut) {
            return nums[0];
        }

        return Math.max(nums[0], nums[len - 1]);
    }

}
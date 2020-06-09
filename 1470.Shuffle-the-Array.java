// https://leetcode.com/problems/shuffle-the-array/
// algorithms
// Easy (91.64%)
// Total Accepted: 12,939
// Total Submissions: 14,119
// beats 100.0% of java submissions


class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int len = 2 * n;

        for (int i = 0; i < n; i++) {
            res[i * 2] = nums[i];
        }
        for (int i = n; i < len; i++) {
            res[(i - n) * 2 + 1] = nums[i];
        }

        return res;
    }
}
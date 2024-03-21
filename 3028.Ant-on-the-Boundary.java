// https://leetcode.com/problems/ant-on-the-boundary/description/
// algorithms
// Easy (75.0%)
// Total Accepted: 37.5K
// Total Submissions: 49.9K


class Solution {

    public int returnToBoundaryCount(int[] nums) {
        int curPosition = 0;
        int res = 0;

        for (int n : nums) {
            curPosition += n;

            if (curPosition == 0) {
                res += 1;
            }
        }

        return res;
    }

}
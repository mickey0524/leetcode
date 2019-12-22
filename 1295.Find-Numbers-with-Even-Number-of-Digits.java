// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
// algorithms
// Easy (89.34%)
// Total Accepted: 3,102
// Total Submissions: 3,472
// beats 100.0% of java submissions


class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;

        for (int n : nums) {
            String tmp = String.valueOf(n);
            int len = tmp.length();
            if ((len & 1) == 0) {
                res++;
            }
        }

        return res;
    }
}
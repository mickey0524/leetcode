// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
// algorithms
// Easy (87.8%)
// Total Accepted: 34.9K
// Total Submissions: 39.7K


class Solution {

    public int differenceOfSum(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res += n;
            String tmp = String.valueOf(n);
            for (char ch : tmp.toCharArray()) {
                res -= (ch - '0');
            }
        }

        return Math.abs(res);     
    }

}
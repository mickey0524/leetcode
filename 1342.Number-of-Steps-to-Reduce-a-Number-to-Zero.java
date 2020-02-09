// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
// algorithms
// Easy (90.75%)
// Total Accepted: 3,602
// Total Submissions: 3,969
// beats 100.0% of java submissions


class Solution {
    public int numberOfSteps(int num) {
        String s = Integer.toBinaryString(num);
        int res = 0;

        for (char ch : s.toCharArray()) {
            res += (ch == '0' ? 1 : 2);
        }

        return res - 1;
    }
}
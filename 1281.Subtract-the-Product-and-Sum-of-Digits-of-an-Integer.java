// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
// algorithms
// Easy (84.96%)
// Total Accepted: 4,871
// Total Submissions: 5,733
// beats 100.0% of java submissions


class Solution {
    public int subtractProductAndSum(int n) {
        int mul = 1, add = 0, tmp = -1;

        while (n != 0) {
            tmp = n % 10;
            n /= 10;
            mul *= tmp;
            add += tmp;
        }

        return mul - add;
    }
}
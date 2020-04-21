// https://leetcode-cn.com/problems/na-ying-bi/
// Easy (77.48%)
// beats 100.0 % of java submissions


class Solution {
    public int minCount(int[] coins) {
        int times = 0;

        for (int n : coins) {
            times += (n / 2);
            times += (n % 2);
        }

        return times;
    }
}
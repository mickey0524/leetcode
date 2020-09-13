// https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
// algorithms
// Medium (59.66%)
// Total Accepted: 9,364
// Total Submissions: 15,696
// beats 100.0% of java submissions


class Solution {

    public int minCost(String s, int[] cost) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        char[] chArr = s.toCharArray();
        int len = chArr.length;
        int res = 0;
        int idx = 0;

        while (idx < len - 1) {
            if (chArr[idx] == chArr[idx + 1]) {
                res += Math.min(cost[idx], cost[idx + 1]);
                cost[idx + 1] = Math.max(cost[idx], cost[idx + 1]);
            }

            idx++;
        }

        return res;
    }

}
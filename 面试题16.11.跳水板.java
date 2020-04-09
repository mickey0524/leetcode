// https://leetcode-cn.com/problems/diving-board-lcci/
// algorithms
// Easy (40.38%)
// Total Accepted: 2,041
// Total Submissions: 5,054


class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[] {};
        }
        if (shorter == longer) {
            return new int[] { k * longer };
        }

        int[] res = new int[k + 1];
        int diff = longer - shorter;
        int num = k * shorter;
        for (int i = 0; i <= k; i++) {
            res[i] = num;
            num += diff;
        }

        return res;
    }
}
// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
// algorithms
// Medium (82.83%)
// Total Accepted: 6,754
// Total Submissions: 8,154


class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length;
        int res = 0, idx = len - 2;

        for (int i = 0; i < len / 3; i++) {
            res += piles[idx];
            idx -= 2;
        }

        return res;
    }
}
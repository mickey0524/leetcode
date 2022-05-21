// https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
// algorithms
// Medium (52.19%)
// Total Accepted: 15,701
// Total Submissions: 30,086


class Solution {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int len = special.length;

        int res = Math.max(special[0] - bottom, top - special[len - 1]);
        for (int i = 1; i < len; i++) {
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }

        return res;
    }

}
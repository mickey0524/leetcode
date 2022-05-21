// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
// algorithms
// Medium (69.84%)
// Total Accepted: 11,992
// Total Submissions: 17,171


class Solution {

    public int largestCombination(int[] candidates) {
        int[] flag = new int[32];

        for (int c : candidates) {
            for (int i = 0; i < 31; i++) {
                if ((c & 1) == 1) {
                    flag[i]++;
                }
                c >>>= 1;
                if (c == 0) {
                    break;
                }
            }
        }

        int res = 1;
        for (int n : flag) {
            res = Math.max(res, n);
        }

        return res;
    }

}
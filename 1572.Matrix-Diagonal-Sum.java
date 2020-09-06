// https://leetcode.com/problems/matrix-diagonal-sum/
// algorithms
// Easy (78.56%)
// Total Accepted: 7,333
// Total Submissions: 9,334
// beats 100.0% of java submissions


class Solution {
    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += mat[i][i];
            res += mat[i][len - 1 - i];
        }

        if ((len & 1) == 1) {
            int idx = len / 2;
            res -= mat[idx][idx];
        }

        return res;
    }
}
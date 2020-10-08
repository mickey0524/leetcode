// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
// algorithms
// Medium (75.13%)
// Total Accepted: 4,211
// Total Submissions: 5,605
// beats 100.0% of java submissions


class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length, col = colSum.length;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int minNum = Math.min(rowSum[i], colSum[j]);
                res[i][j] = minNum;

                rowSum[i] -= minNum;
                colSum[j] -= minNum;
            }
        }

        return res;
    }
}

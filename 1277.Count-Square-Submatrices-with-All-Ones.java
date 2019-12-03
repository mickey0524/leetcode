// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
// algorithms
// Medium (66.67%)
// Total Accepted: 3.6K
// Total Submissions: 5.4K
// beats 100.0% of java submissions


class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        int row = matrix.length, col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    res++;
                } else {
                    continue;
                }
                if (i > 0 && j > 0 && matrix[i - 1][j] != 0 && matrix[i][j - 1] != 0 && matrix[i - 1][j - 1] != 0) {
                    int tmp = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j]));
                    res += tmp;
                    matrix[i][j] = tmp + 1;
                }
            }
        }

        return res;
    }
}
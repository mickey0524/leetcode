// https://leetcode.com/problems/toeplitz-matrix/
//
// algorithms
// Easy (62.58%)
// Total Accepted: 70,909
// Total Submissions: 113,301
// beats 100.0% of java submissions


class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = row - 1; i >= 0; i--) {
            int x = i, y = 0;
            int value = matrix[x][y];
            while (x >= 0 && x < row && y >= 0 && y < col) {
                if (matrix[x][y] != value) {
                    return false;
                }
                x++;
                y++;
            }
        }

        for (int i = 1; i < col; i++) {
            int x = 0, y = i;
            int value = matrix[x][y];
            while (x >= 0 && x < row && y >= 0 && y < col) {
                if (matrix[x][y] != value) {
                    return false;
                }
                x++;
                y++;
            }
        }

        return true;
    }
}
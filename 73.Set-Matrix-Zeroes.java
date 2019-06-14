// https://leetcode.com/problems/set-matrix-zeroes/
//
// algorithms
// Medium (39.95%)
// Total Accepted:    212,151
// Total Submissions: 531,054

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        
        BitSet rowSet = new BitSet();
        BitSet colSet = new BitSet();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.set(i);
                    colSet.set(j);
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            if (rowSet.get(i)) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < col; i++) {
            if (colSet.get(i)) {
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
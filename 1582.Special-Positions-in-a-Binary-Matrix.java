// https://leetcode.com/problems/special-positions-in-a-binary-matrix/
// algorithms
// Easy (59.69%)
// Total Accepted: 5,921
// Total Submissions: 9,920
// beats 100.0% of java submissions


class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        if (row == 0) {
            return 0;
        }
        int col = mat[0].length;

        int[] rowFlag = new int[row];
        int[] colFlag = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    rowFlag[i]++;
                    colFlag[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowFlag[i] == 1 && colFlag[j] == 1 && mat[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
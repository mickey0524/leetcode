// https://leetcode.com/problems/surface-area-of-3d-shapes/
//
// algorithms
// Easy (57.73%)
// Total Accepted: 15,255
// Total Submissions: 26,425


class Solution {

    private static final int[][] deltaArr = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int surfaceArea(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                int num = grid[x][y];
                if (num == 0) {
                    continue;
                }

                res += 2;

                int diff;
                for (int[] delta : deltaArr) {
                    if (isValidCoordinate(row, col, x + delta[0], y + delta[1])) {
                        diff = num - grid[x + delta[0]][y + delta[1]];
                        if (diff > 0) {
                            res += diff;
                        }
                    } else {
                        res += num;
                    }
                }
            }
        }

        return res;
    }

    public boolean isValidCoordinate(int row, int col, int x, int y) {
        if (x < 0 || x >= row) {
            return false;
        }

        if (y < 0 || y >= col) {
            return false;
        }

        return true;
    }
}
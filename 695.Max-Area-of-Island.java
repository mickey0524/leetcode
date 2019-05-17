// https://leetcode.com/problems/max-area-of-island/
//
// algorithms
// Medium (57.06%)
// Total Accepted: 80,923
// Total Submissions: 141,818
// beats 100.0% of java submissions

class Solution {

    static int curArea;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        int flag = 2;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    Solution.curArea = 0;
                    recursive(grid, flag, i, j);
                    flag++;
                    res = Math.max(res, Solution.curArea);
                }
            }
        }

        return res;

    }

    public void recursive(int[][] grid, int flag, int i, int j) {
        int row = grid.length, col = grid[0].length;

        grid[i][j] = flag;
        Solution.curArea++;

        if (i > 0 && grid[i - 1][j] == 1) {
            recursive(grid, flag, i - 1, j);
        }

        if (i < row - 1 && grid[i + 1][j] == 1) {
            recursive(grid, flag, i + 1, j);
        }

        if (j > 0 && grid[i][j - 1] == 1) {
            recursive(grid, flag, i, j - 1);
        }

        if (j < col - 1 && grid[i][j + 1] == 1) {
            recursive(grid, flag, i, j + 1);
        }
    }
}
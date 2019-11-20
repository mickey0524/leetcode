// https://leetcode.com/problems/number-of-closed-islands/
// algorithms
// Easy (59.85%)
// Total Accepted: 5,585
// Total Submissions: 9,331
// beats 100.0% of java submissions


class Solution {

    private static final int ISLAND = 0;
    private static final int SEA = 1;

    public int closedIsland(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (grid[i][j] == ISLAND) {
                    if (recursive(grid, i, j)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public boolean recursive(int[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        grid[i][j] = SEA;
        if (i == 0 || i == row - 1) {
            return false;
        }
        if (j == 0 || j == col - 1) {
            return false;
        }

        boolean res = true;
        if (grid[i - 1][j] == ISLAND) {
            res &= recursive(grid, i - 1, j);
        }
        if (grid[i + 1][j] == ISLAND) {
            res &= recursive(grid, i + 1, j);
        }
        if (grid[i][j - 1] == ISLAND) {
            res &= recursive(grid, i, j - 1);
        }
        if (grid[i][j + 1] == ISLAND) {
            res &= recursive(grid, i, j + 1);
        }

        return res;
    }
}
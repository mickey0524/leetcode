// https://leetcode.com/problems/island-perimeter/
//
// algorithms
// Easy (62.11%)
// Total Accepted: 155,394
// Total Submissions: 250,181


class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    if (i == row - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    if (j == col - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
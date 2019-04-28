// https://leetcode.com/problems/coloring-a-border/
//
// algorithms
// Medium (38.33%)
// Total Accepted:    1,599
// Total Submissions: 4,172
// beats 100.0% of java submissions


class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int row = grid.length, col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        
        recursiveColor(grid, isVisited, r0, c0, color, grid[r0][c0]);
        
        return grid;
    }
    
    public void recursiveColor(int[][] grid, boolean[][] isVisited, int i, int j, int color, int flag) {
        int row = grid.length, col = grid[0].length;
        isVisited[i][j] = true;
        
        if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
            grid[i][j] = color;
        }
        
        if (i > 0 && !isVisited[i - 1][j]) {
            if (grid[i - 1][j] != flag) {
                grid[i][j] = color;
            }
            else {
                recursiveColor(grid, isVisited, i - 1, j, color, flag);
            }
        }
        
        if (i < row - 1 && !isVisited[i + 1][j]) {
            if (grid[i + 1][j] != flag) {
                grid[i][j] = color;
            }
            else {
                recursiveColor(grid, isVisited, i + 1, j, color, flag);
            }
        }
        
        if (j > 0 && !isVisited[i][j - 1]) {
            if (grid[i][j - 1] != flag) {
                grid[i][j] = color;
            }
            else {
                recursiveColor(grid, isVisited, i, j - 1, color, flag);
            }
        }
        
        if (j < col - 1 && !isVisited[i][j + 1]) {
            if (grid[i][j + 1] != flag) {
                grid[i][j] = color;
            }
            else {
                recursiveColor(grid, isVisited, i, j + 1, color, flag);
            }
        }
    }
}
// https://leetcode.com/problems/number-of-islands/
//
// algorithms
// Medium (44.11%)
// Total Accepted:    336,992
// Total Submissions: 819,641
// beats 100.0% of java submissions

class Solution {
        
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        
        int flag = 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    recursive(grid, (char) (flag + '0'), i, j);
                    flag++;
                }
            }
        }
        
        return flag - 2;
    }
    
    public void recursive(char[][] grid, char flag, int i, int j) {
        int row = grid.length, col = grid[0].length;
        grid[i][j] = flag;
        
        if (i > 0 && grid[i - 1][j] == '1') {
            recursive(grid, flag, i - 1, j);
        }
        
        if (i < row - 1 && grid[i + 1][j] == '1') {
            recursive(grid, flag, i + 1, j);
        }
        
        if (j > 0 && grid[i][j - 1] == '1') {
            recursive(grid, flag, i, j - 1);
        }
        
        if (j < col - 1 && grid[i][j + 1] == '1') {
            recursive(grid, flag, i, j + 1);
        }
    } 
    
}
// https://leetcode.com/problems/unique-paths-ii/
//
// algorithms
// Medium (33.5%)
// Total Accepted: 203,149
// Total Submissions: 606,490
// beats 100.0% of java submissions

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int col = obstacleGrid[0].length;
        
        int dp[][] = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;   
            } else {
                break;
            }
        }
        
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;   
            } else {
                break;
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[row - 1][col - 1];
    }
}
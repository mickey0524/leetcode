// https://leetcode.com/problems/replace-elements-in-an-array/
// algorithms
// Medium (61.07%)
// Total Accepted: 9.1K
// Total Submissions: 14.9K


class Solution {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = grid[0][i];
        }
        for (int i = 0; i < m - 1; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (tmp[k] == 0) {
                        tmp[k] = dp[j] + moveCost[grid[i][j]][k] + grid[i + 1][k];
                    } else {
                        tmp[k] = Math.min(tmp[k], dp[j] + moveCost[grid[i][j]][k] + grid[i + 1][k]);
                    }
                }
            }
            dp = tmp;
        }

        return min(dp);
    }

    private int min(int[] dp) {
        int res = Integer.MAX_VALUE;

        for (int n : dp) {
            res = Math.min(res, n);
        }

        return res;
    }

}
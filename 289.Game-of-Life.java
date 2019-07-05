// https://leetcode.com/problems/game-of-life/
//
// algorithms
// Medium (46.04%)
// Total Accepted:    117,326
// Total Submissions: 254,832
// beats 100.0% of java submissions

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;

        int[][] tmp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int aliveNum = 0;
                for (int k = Math.max(0, i - 1); k <= Math.min(m - 1, i + 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(n - 1, j + 1); l++) {
                        if (board[k][l] == 1) {
                            aliveNum++;
                        }
                    }
                }
                if (board[i][j] == 1) {
                    if (aliveNum == 3 || aliveNum == 4) {
                        tmp[i][j] = 1;
                    }
                } else {
                    if (aliveNum == 3) {
                        tmp[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = tmp[i][j];
            }
        }

        return;
    }
}
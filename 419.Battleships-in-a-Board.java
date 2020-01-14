// https://leetcode.com/problems/battleships-in-a-board/
//
// algorithms
// Medium (67.51%)
// Total Accepted: 75,626
// Total Submissions: 112,025
// beats 100.0% of java submissions


class Solution {

    public int countBattleships(char[][] board) {
        if (board == null) {
            return 0;
        }
        int row = board.length;
        if (row == 0) {
            return 0;
        }
        int col = board[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 'X') {
                    continue;
                }

                if (i == 0 && j == 0) {
                    res++;
                } else if (i == 0) {
                    if (board[i][j - 1] != 'X') {
                        res++;
                    }
                } else if (j == 0) {
                    if (board[i - 1][j] != 'X') {
                        res++;
                    }
                } else {
                    if (board[i - 1][j] != 'X' && board[i][j - 1] != 'X') {
                        res++;
                    }
                }
            }
        }

        return res;
    }

}
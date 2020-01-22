// https://leetcode.com/problems/available-captures-for-rook/
//
// algorithms
// Easy (65.93%)
// Total Accepted: 22,438
// Total Submissions: 34,035
// beats 100.0% of java submissions


class Solution {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        int x = -1, y = -1;
        int row = board.length, col = board[0].length;
        boolean rookFound = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    rookFound = true;
                    break;
                }
            }
            if (rookFound) {
                break;
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'p') {
                res++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }

        for (int i = x + 1; i < row; i++) {
            if (board[i][y] == 'p') {
                res++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'p') {
                res++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }

        for (int i = y + 1; i < col; i++) {
            if (board[x][i] == 'p') {
                res++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }

        return res;

    }
}
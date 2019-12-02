// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/submissions/
// algorithms
// Medium (56.48%)
// Total Accepted: 3,624
// Total Submissions: 6,416
// beats 100.0% of java submissions


class Solution {

    private static final String A = "A";
    private static final String B = "B";
    private static final String DRAW = "Draw";
    private static final String PENDING = "Pending";

    public String tictactoe(int[][] moves) {
        int[] row = new int[3];
        int[] col = new int[3];
        int diagonal1 = 0, diagonal2 = 0;
        int step = 1;

        for (int[] point : moves) {
            row[point[0]] += step;
            col[point[1]] += step;
            if (point[0] == point[1]) {
                diagonal1 += step;
            }
            if (point[0] + point[1] == 2) {
                diagonal2 += step;
            }
            step = -step;

            String tmp = checkEnd(row, col, diagonal1, diagonal2);
            if (tmp != DRAW) {
                return tmp;
            }
        }

        return moves.length == 9 ? DRAW : PENDING;
    }

    public String checkEnd(int[] row, int[] col, int diagonal1, int diagonal2) {
        if (diagonal1 == 3 || diagonal2 == 3) {
            return A;
        }
        if (diagonal1 == -3 || diagonal2 == -3) {
            return B;
        }

        for (int n : row) {
            if (n == 3) {
                return A;
            } else if (n == -3) {
                return B;
            }
        }
        for (int n : col) {
            if (n == 3) {
                return A;
            } else if (n == -3) {
                return B;
            }
        }

        return DRAW;
    }

}
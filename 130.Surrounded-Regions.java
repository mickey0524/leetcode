// https://leetcode.com/problems/triangle/
//
// algorithms
// Medium (23.05%)
// Total Accepted: 147,661
// Total Submissions: 640,572

class Solution {
    static boolean meetBoard;

    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;

        boolean[][] isVisited = new boolean[row][col];
        ArrayList<int[]> path = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !isVisited[i][j]) {
                    path.clear();
                    meetBoard = false;
                    recursive(board, i, j, isVisited, path);
                    if (!meetBoard) {
                        for (int[] p : path) {
                            board[p[0]][p[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    public void recursive(char[][] board, int i, int j, boolean[][] isVisited, ArrayList<int[]> path) {
        int row = board.length, col = board[0].length;
        path.add(new int[] { i, j });
        isVisited[i][j] = true;

        if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
            meetBoard = true;
        }

        if (i > 0 && !isVisited[i - 1][j] && board[i - 1][j] == 'O') {
            recursive(board, i - 1, j, isVisited, path);
        }

        if (i < row - 1 && !isVisited[i + 1][j] && board[i + 1][j] == 'O') {
            recursive(board, i + 1, j, isVisited, path);
        }

        if (j > 0 && !isVisited[i][j - 1] && board[i][j - 1] == 'O') {
            recursive(board, i, j - 1, isVisited, path);
        }

        if (j < col - 1 && !isVisited[i][j + 1] && board[i][j + 1] == 'O') {
            recursive(board, i, j + 1, isVisited, path);
        }
    }
}
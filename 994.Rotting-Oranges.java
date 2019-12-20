// https://leetcode.com/problems/rotting-oranges/
//
// algorithms
// Easy (46.61%)
// Total Accepted: 32,491
// Total Submissions: 69,714
// beats 100.0% of java submissions


class Solution {

    private static final int FRESH = 1;
    private static final int ROT = 2;

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        int initFreshNum = 0;
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == ROT) {
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] == FRESH) {
                    initFreshNum++;
                }
            }
        }
        if (initFreshNum == 0) {
            return 0;
        }

        int minute = 0, rotNum = 0;
        while (!q.isEmpty()) {
            LinkedList<int[]> tmp = new LinkedList<>();
            boolean freshFound = false;

            while (!q.isEmpty()) {
                int[] cur = q.pollFirst();

                if (cur[0] > 0 && grid[cur[0] - 1][cur[1]] == FRESH) {
                    rotNum++;
                    tmp.offer(new int[] { cur[0] - 1, cur[1] });
                    grid[cur[0] - 1][cur[1]] = ROT;
                    freshFound = true;
                }
                if (cur[0] < row - 1 && grid[cur[0] + 1][cur[1]] == FRESH) {
                    rotNum++;
                    tmp.offer(new int[] { cur[0] + 1, cur[1] });
                    grid[cur[0] + 1][cur[1]] = ROT;
                    freshFound = true;
                }
                if (cur[1] > 0 && grid[cur[0]][cur[1] - 1] == FRESH) {
                    rotNum++;
                    tmp.offer(new int[] { cur[0], cur[1] - 1 });
                    grid[cur[0]][cur[1] - 1] = ROT;
                    freshFound = true;
                }
                if (cur[1] < col - 1 && grid[cur[0]][cur[1] + 1] == FRESH) {
                    rotNum++;
                    tmp.offer(new int[] { cur[0], cur[1] + 1 });
                    grid[cur[0]][cur[1] + 1] = ROT;
                    freshFound = true;
                }
            }

            q = tmp;
            if (freshFound) {
                minute++;
            }
        }

        if (rotNum < initFreshNum) {
            return -1;
        }

        return minute;
    }
}
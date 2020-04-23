// https://leetcode-cn.com/problems/na-ying-bi/
// Easy (53.76%)
// beats 100.0 % of java submissions


class Solution {

    private static int res;

    public int numWays(int n, int[][] relation, int k) {
        boolean[][] flag = new boolean[n][n];
        for (int[] r : relation) {
            flag[r[0]][r[1]] = true;
        }

        res = 0;
        recursive(0, n - 1, k, flag);

        return res;
    }

    private void recursive(int curIdx, int endIdx, int remainingTimes, boolean[][] flag) {
        if (remainingTimes == 0) {
            if (curIdx == endIdx) {
                res++;
            }

            return;
        }

        for (int i = 0; i <= endIdx; i++) {
            if (i == curIdx) {
                continue;
            }

            if (flag[curIdx][i] && remainingTimes > 0) {
                recursive(i, endIdx, remainingTimes - 1, flag);
            }
        }
    }
}
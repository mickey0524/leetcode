// https://leetcode.com/problems/count-servers-that-communicate/
// algorithms
// Medium (58.15%)
// Total Accepted: 7,731
// Total Submissions: 13,294


class Solution {

    private final static int EXIST_BIT = 1;
    private final static int COMPUTED_BIT = 1 << 1;

    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            l.clear();
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    l.add(j);
                }
            }
            if (l.size() > 1) {
                res += l.size();
                for (int j : l) {
                    grid[i][j] |= COMPUTED_BIT;
                }
            }
        }

        for (int j = 0; j < col; j++) {
            l.clear();
            for (int i = 0; i < row; i++) {
                if ((grid[i][j] & EXIST_BIT) != 0) {
                    l.add(i);
                }
            }
            if (l.size() > 1) {
                for (int i : l) {
                    if ((grid[i][j] & COMPUTED_BIT) == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

}
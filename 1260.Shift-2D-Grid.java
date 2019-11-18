// https://leetcode.com/problems/shift-2d-grid/
// algorithms
// Easy (56.84%)
// Total Accepted: 3,918
// Total Submissions: 6,893
// beats 100.0% of java submissions


class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int divRes = k / m, remainder = k % m;
        divRes %= n;

        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = grid[j][i];
            }

            for (int j = 0; j < n; j++) {
                int idx = (j + n - divRes) % n;
                grid[j][i] = tmp[idx];
            }
        }

        int[][] tmp = new int[n][m];
        for (int i = 0; i < m - remainder; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][i + remainder] = grid[j][i];
            }
        }
        for (int i = m - 1; i >= m - remainder; i--) {
            int colIdx = (i + remainder) % m;
            for (int j = 0; j < n; j++) {
                int rowIdx = (j + n - 1) % n;
                tmp[j][colIdx] = grid[rowIdx][i];
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            for (int num : tmp[i]) {
                l.add(num);
            }
            res.add(l);
        }

        return res;
    }

}
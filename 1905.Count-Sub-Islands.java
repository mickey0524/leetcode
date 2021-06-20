// https://leetcode.com/problems/count-sub-islands/
// algorithms
// Medium (57.95%)
// Total Accepted: 5.1K
// Total Submissions: 8.8K


class Solution {
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        int m = grid2.length;
        int n = grid2[0].length;

        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !set.contains(buildKey(i, j))) {
                    List<int[]> path = new ArrayList<>();
                    recursive(grid2, path, set, i, j);

                    boolean isOk = true;
                    for (int[] p : path) {
                        if (grid1[p[0]][p[1]] == 0) {
                            isOk = false;
                            break;
                        }
                    }

                    if (isOk) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private void recursive(int[][] grid2, List<int[]> path, Set<String> set, int x, int y) {
        int m = grid2.length;
        int n = grid2[0].length;

        if (grid2[x][y] == 0) {
            return;
        }

        set.add(buildKey(x, y));
        path.add(new int[]{x, y});

        if (x < m - 1 && grid2[x + 1][y] == 1 && !set.contains(buildKey(x + 1, y))) {
            recursive(grid2, path, set, x + 1, y);
        }

        if (y < n - 1 && grid2[x][y + 1] == 1 && !set.contains(buildKey(x, y + 1))) {
            recursive(grid2, path, set, x, y + 1);
        }

        if (x > 0 && grid2[x - 1][y] == 1 && !set.contains(buildKey(x - 1, y))) {
            recursive(grid2, path, set, x - 1, y);
        }

        if (y > 0 && grid2[x][y - 1] == 1 && !set.contains(buildKey(x, y - 1))) {
            recursive(grid2, path, set, x, y - 1);
        }
    }

    private String buildKey(int x, int y) {
        StringBuilder sb = new StringBuilder();

        sb.append(x).append('#').append(y);

        return sb.toString();
    }

}
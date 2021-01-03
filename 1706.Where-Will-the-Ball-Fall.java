// https://leetcode.com/problems/where-will-the-ball-fall/
// algorithms
// Medium (56.43%)
// Total Accepted: 5,023
// Total Submissions: 8,901


class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (n == 1) {
            return new int[]{-1};
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            while (x < m) {
                if (y == 0 && grid[x][y] == -1) {
                    y = -1;
                    break;
                } else if (y == n - 1 && grid[x][y] == 1) {
                    y = -1;
                    break;
                } else {
                    if (grid[x][y] == 1) {
                        if (grid[x][y + 1] == -1) {
                            y = -1;
                            break;
                        }
                        
                        x++;
                        y++;
                    } else {
                        if (grid[x][y - 1] == 1) {
                            y = -1;
                            break;
                        }
                        
                        x++;
                        y--;
                    }
                }
            }
            
            res[i] = y;
        }
        
        return res;
    }
}
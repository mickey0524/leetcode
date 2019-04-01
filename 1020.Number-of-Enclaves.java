// https://leetcode.com/problems/number-of-enclaves/
//
// algorithms
// Medium (53.34%)
// Total Accepted:    2,913
// Total Submissions: 5,461

class Solution {
    
    public int numEnclaves(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int res = 0;
        
        ArrayList<int[]> path = new ArrayList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    path.clear();
                    this.recursive(A, path, i, j, row, col);
                    if (A[i][j] == 0 && path.size() > 0) {
                        res += path.size();
                    }
                }
            }
        }
        
        return res;
    }
    
    public void recursive(int[][] A, ArrayList<int[]> path, int x, int y, int row, int col) {
        path.add(new int[]{x, y});
        A[x][y] = 0;
        if (x == 0 || x == row - 1 || y == 0 || y == col - 1 ||
            A[x + 1][y] == -1 || A[x - 1][y] == - 1 || A[x][y + 1] == -1 || A[x][y - 1] == -1) {
            for (int i = 0; i < path.size(); i++) {
                A[path.get(i)[0]][path.get(i)[1]] = -1;
            }
            return;
        }
        if (A[x - 1][y] == 1) {
            this.recursive(A, path, x - 1, y, row, col);
        }
        if (A[x + 1][y] == 1) {
            this.recursive(A, path, x + 1, y, row, col);
        }
        if (A[x][y + 1] == 1) {
            this.recursive(A, path, x, y + 1, row, col);
        }
        if (A[x][y - 1] == 1) {
            this.recursive(A, path, x, y - 1, row, col);
        }
    }
}

class Solution1 {
    int iLen = 0, jLen = 0;
    public int numEnclaves(int[][] A) {
        iLen = A.length;
        jLen = A[0].length;
        
        for (int i = 0; i < iLen; ++i) {
            flood(i, 0, A);
            flood(i, jLen - 1, A);
        }
        for (int j = 0; j < jLen; ++j) {
            flood(0, j, A);
            flood(iLen - 1, j, A);
        }

        int count = 0;
        for (int i = 0; i < iLen; ++i)
            for (int j = 0; j < jLen; ++j)
                count += A[i][j];
        return count;
    }
    
    private void flood(int i, int j, int[][] A) {
        if (i == -1 || i == iLen || j == -1 || j == jLen || A[i][j] == 0)
            return;
        A[i][j] = 0;
        
        flood(i - 1, j, A);
        flood(i + 1, j, A);
        flood(i, j - 1, A);
        flood(i, j + 1, A);
    }
}
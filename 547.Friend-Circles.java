// https://leetcode.com/problems/friend-circles/
//
// algorithms
// Medium (53.54%)
// Total Accepted: 84,688
// Total Submissions: 158,175
// beats 100.0% of java submissions

class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }
        int n = M.length;
        if (n == 0) {
            return 0;
        }

        int flag = 2;
        for (int i = 0; i < n; i++) {
            if (M[i][i] == 1) {
                recursive(M, i, flag);
                flag++;
            }
        }

        return flag - 2;
    }

    public void recursive(int[][] M, int idx, int flag) {
        int n = M.length;
        M[idx][idx] = flag;

        for (int i = 0; i < n; i++) {
            if (M[idx][i] == 1 && M[i][i] == 1) {
                recursive(M, i, flag);
            }
        }
    }
}
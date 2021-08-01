// https://leetcode.com/problems/maximum-compatibility-score-sum/
// algorithms
// Medium (56.12%)
// Total Accepted: 7.8K
// Total Submissions: 13.9K

class Solution {
    
    private static int res;
    
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        
        int[][] score = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = 0;
                for (int k = 0; k < n; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        tmp++;
                    }
                }
                score[i][j] = tmp;
            }
        }
        
        res = 0;
        boolean[] isVisited = new boolean[m];
        recursive(score, 0, 0, isVisited);
        
        return res;
    }
    
    private void recursive(int[][] score, int idx, int curSum, boolean[] isVisited) {
        int len = score.length;
        if (idx == len) {
            res = Math.max(res, curSum);
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (isVisited[i]) {
                continue;
            }
            
            isVisited[i] = true;
            recursive(score, idx + 1, curSum + score[idx][i], isVisited);
            isVisited[i] = false;
        }
    }
}
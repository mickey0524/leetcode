// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
// algorithms
// Easy (47.92%)
// Total Accepted: 7,529
// Total Submissions: 15,711


class Solution {
    
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            boolean[] flag = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                flag[matrix[i][j]] = true;
            }
            
            if (!isValid(flag)) {
                return false;
            }
        }
        
        for (int i = 0; i < n; i++) {
            boolean[] flag = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                flag[matrix[j][i]] = true;
            }
            
            if (!isValid(flag)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValid(boolean[] flag) {
        int len = flag.length;
        
        for (int i = 1; i < len; i++) {
            if (!flag[i]) {
                return false;
            }
        }
        
        return true;
    } 
    
}
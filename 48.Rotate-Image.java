// https://leetcode.com/problems/rotate-image/
//
// algorithms
// Medium (48.67%)
// Total Accepted: 254,139
// Total Submissions: 522,212
// beats 100.0% of java submissions

public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len <= 1) return ;
        int temp [] = new int [2 * len];
        for(int i = 0; i < len / 2; i++) {
            temp[1] = matrix[i][i];
            matrix[i][i] = matrix[len - 1 - i][i];
            temp[2] = matrix[i][len - 1 - i];
            matrix[i][len - 1 - i] = temp[1];
            temp[1] = matrix[len - 1 - i][len - 1 - i];
            matrix[len - 1 - i][len - 1 - i] = temp[2];
            matrix[len - 1 - i][i] = temp[1];
        }
        for(int i = 0; i < len / 2; i++) {
            int num1 = 0;
            int num2 = len;
            for(int j = i + 1; j <= len - 1 - i - 1; j++) {
                temp[num1] = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                num1 += 1;
                temp[num2] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = matrix[len - 1 - j][len - 1 - i];
                num2 += 1;
            }
            int n1 = 0;
            int n2 = len;
            for(int j = i + 1; j <= len - 1 - i - 1; j++) {
                matrix[j][len - 1 - i] = temp[n1];
                n1 += 1;
                matrix[j][i] = temp[n2];
                n2 += 1;
            }
        }
        return ;
    }
}
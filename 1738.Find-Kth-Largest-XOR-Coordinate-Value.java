// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
// algorithms
// Medium (59.97%)
// Total Accepted: 4,076
// Total Submissions: 6,797


class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] flag = new int[n];
        flag[0] = matrix[0][0];
        List<Integer> l = new ArrayList<>();
        l.add(flag[0]);
        
        for (int i = 1; i < n; i++) {
            flag[i] = flag[i - 1] ^ matrix[0][i];
            l.add(flag[i]);
        }
        
        for (int i = 1; i < m; i++) {
            int[] tmp = new int[n];
            int temp = matrix[i][0];
            tmp[0] = flag[0] ^ matrix[i][0];
            l.add(tmp[0]);
            for (int j = 1; j < n; j++) {
                tmp[j] = temp ^ matrix[i][j] ^ flag[j];
                l.add(tmp[j]);
                temp ^= matrix[i][j];
            }
            
            flag = tmp;
        }

        Collections.sort(l);
        
        return l.get(m * n - k);
    }
}
// https://leetcode.com/problems/find-center-of-star-graph/
// algorithms
// Medium (86.59%)
// Total Accepted: 6,129
// Total Submissions: 7,078

class Solution {
    public int findCenter(int[][] edges) {
        int len = edges.length;
        
        int[] degree = new int[len + 2];
        for (int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
        }
        
        int res = -1;
        int maxNum = Integer.MIN_VALUE;
        
        for (int i = 1; i <= len + 1; i++) {
            if (degree[i] > maxNum) {
                maxNum = degree[i];
                res = i;
            }
        }
        
        return res;
    }
}
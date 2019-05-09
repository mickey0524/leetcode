// https://leetcode.com/problems/4sum-ii/
//
// algorithms
// Medium (50.42%)
// Total Accepted:    63,990
// Total Submissions: 126,920


class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int s = A[i] + B[j];
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int s = C[i] + D[j];
                if (map.containsKey(-s)) {
                    res += map.get(-s);
                }
            }
        }
        
        return res;
    }
}
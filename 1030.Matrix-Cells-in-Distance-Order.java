// https://leetcode.com/problems/matrix-cells-in-distance-order/
//
// algorithms
// Easy (67.8%)
// Total Accepted:    4,449
// Total Submissions: 6,562
// beats 73.15% of java submissions


class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int idx = 0;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[idx][0] = i;
                res[idx][1] = j;
                idx++;
            }
        }
        
        Arrays.sort(res, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                int distance1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
                int distance2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
                return distance1 - distance2;
            }
        });
        
        return res;
    }
}
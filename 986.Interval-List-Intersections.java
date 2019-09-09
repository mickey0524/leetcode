// https://leetcode.com/problems/interval-list-intersections/
//
// algorithms
// Medium (63.86%)
// Total Accepted:    30,038
// Total Submissions: 47,034
// beats 100.0% of java submissions


class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int ALen = A.length, BLen = B.length;
        int AIdx = 0, BIdx = 0;
        
        ArrayList<int[]> l = new ArrayList<>();
        
        while (AIdx < ALen && BIdx < BLen) {
            if (A[AIdx][0] <= B[BIdx][1] && A[AIdx][1] >= B[BIdx][0]) {
                l.add(new int[]{Math.max(A[AIdx][0], B[BIdx][0]), Math.min(A[AIdx][1], B[BIdx][1])});
            }
            
            if (A[AIdx][1] <= B[BIdx][1]) {
                AIdx++;
            } else {
                BIdx++;
            }
        }
        
        return l.toArray(new int[0][]);
    }
}
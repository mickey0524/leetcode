// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
// algorithms
// Medium (86.65%)
// Total Accepted: 5,166
// Total Submissions: 5,962
// beats 100.0% of java submissions


class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> l = new ArrayList<>(points.length);
        
        for (int[] p : points) {
            l.add(p[0]);
        }
        
        Collections.sort(l);
        int res = 0, len = l.size();
        
        for (int i = 1; i < len; i++) {
            int tmpDiff = l.get(i) - l.get(i - 1);
            res = Math.max(res, tmpDiff);
        }
        
        return res;
    }
}
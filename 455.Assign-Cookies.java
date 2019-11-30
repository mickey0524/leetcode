// https://leetcode.com/problems/assign-cookies/
//
// algorithms
// Easy (48.91%)
// Total Accepted: 77,083
// Total Submissions: 157,592


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gLen = g.length, sLen = s.length;
        int res = 0, gIdx = 0, sIdx = 0;

        while (gIdx < gLen && sIdx < sLen) {
            if (s[sIdx] >= g[gIdx]) {
                gIdx++;
                sIdx++;
                res++;
            } else {
                sIdx++;
            }
        }

        return res;
    }
}
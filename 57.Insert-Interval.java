// https://leetcode.com/problems/insert-interval/
//
// algorithms
// Hard (31.27%)
// Total Accepted:    178,572
// Total Submissions: 571,118
// beats 100.0% of java submissions


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int mergeStart = Integer.MIN_VALUE, mergeEnd = Integer.MIN_VALUE;
        int beginIdx = -1, endIdx = len;

        for (int i = 0; i < len; i++) {
            if (mergeEnd != Integer.MIN_VALUE) {
                if (intervals[i][0] <= mergeEnd) {
                    mergeEnd = Math.max(intervals[i][1], mergeEnd);
                } else {
                    endIdx = i;
                    break;
                }
            } else {
                if (newInterval[0] <= intervals[i][1] && intervals[i][0] <= newInterval[1]) {
                    mergeStart = Math.min(newInterval[0], intervals[i][0]);
                    mergeEnd = Math.max(newInterval[1], intervals[i][1]);
                    beginIdx = i;
                } else if (newInterval[1] < intervals[i][0]) {
                    break;
                }
            }
        }

        if (beginIdx == -1) {
            int[][] res = new int[len + 1][2];
            boolean insert = false;
            int idx = 0;
            
            for (int[] interval: intervals) {
                if (!insert && newInterval[1] < interval[0]) {
                    insert = true;
                    res[idx++] = newInterval;   
                }
                res[idx++] = interval;
            }
            if (!insert) {
                res[idx] = newInterval;
            }

            return res;
        }
        
        if (endIdx == len) {
            if (len == 1) {
                return new int[][]{{mergeStart, mergeEnd}};
            }
            int[][] res = new int[beginIdx + 1][2];
            
            for (int i = 0; i < beginIdx; i++) {
                res[i] = intervals[i];
            }
            
            res[beginIdx] = new int[]{mergeStart, mergeEnd};
            
            return res;
        }
        
        int[][] res = new int[1 + beginIdx + len - endIdx][2];
        for (int i = 0; i < beginIdx; i++) {
            res[i] = intervals[i];
        }
        res[beginIdx] = new int[]{mergeStart, mergeEnd};
        for (int i = beginIdx + 1; i < res.length; i++) {
            res[i] = intervals[endIdx];
            endIdx++;
        }
        
        return res;
    }
}
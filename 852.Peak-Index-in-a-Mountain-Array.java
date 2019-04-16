// https://leetcode.com/problems/peak-index-in-a-mountain-array/
//
// algorithms
// Easy (69.36%)
// Total Accepted:    67,563
// Total Submissions: 97,412


class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int length = A.length;
        int idx = 0;
        
        while (idx < length - 1) {
            if (A[idx] > A[idx + 1]) {
                return idx;
            }
            idx++;
        }
        
        return 0;
    }
}
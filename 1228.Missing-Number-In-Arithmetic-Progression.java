// https://leetcode.com/problems/missing-number-in-arithmetic-progression/
//
// algorithms
// Easy (51.34%)
// Total Accepted: 3,146
// Total Submissions: 6,128
// beats 100.0% of java submissions


class Solution {
    public int missingNumber(int[] arr) {
        int len = arr.length;
        if (len == 2) {
            return arr[0] + (arr[1] - arr[0]) / 2;
        }
        
        int diff = arr[1] - arr[0], curDiff = -1;
        for (int i = 1; i < len - 1; i++) {
            curDiff = arr[i + 1] - arr[i];
            if (curDiff == diff) {
                continue;
            }
            
            if (diff * 2 == curDiff) {
                return arr[i] + (arr[i + 1] - arr[i]) / 2;
            } else {
                return arr[i - 1] + (arr[i] - arr[i - 1]) / 2;
            }
        }
        
        return arr[0];
    }
}
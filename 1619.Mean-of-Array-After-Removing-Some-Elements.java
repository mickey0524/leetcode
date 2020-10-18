// https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
// algorithms
// Easy (64.96%)
// Total Accepted: 4,812
// Total Submissions: 7,408
// beats 100.0% of java submissions


class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int segmentLen = len / 20;

        int beginIdx = segmentLen, endIdx = len - segmentLen;
        double s = 0;
        for (int i = beginIdx; i < endIdx; i++) {
            s += arr[i];
        }

        return s / (endIdx - beginIdx);
    }
}
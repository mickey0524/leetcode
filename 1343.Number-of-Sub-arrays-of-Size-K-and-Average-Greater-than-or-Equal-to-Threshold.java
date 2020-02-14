// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
// algorithms
// Medium (64.05%)
// Total Accepted: 3,940
// Total Submissions: 6,151
// beats 100.0% of java submissions


class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold *= k;
        int res = 0, curSum = 0;

        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }
        if (curSum >= threshold) {
            res++;
        }

        for (int i = k; i < arr.length; i++) {
            curSum += arr[i];
            curSum -= arr[i - k];
            if (curSum >= threshold) {
                res++;
            }
        }

        return res;
    }
}
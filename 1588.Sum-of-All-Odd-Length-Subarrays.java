// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
// algorithms
// Easy (81.33%)
// Total Accepted: 11,428
// Total Submissions: 14,052
// beats 100.0% of java submissions


class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;

        int[] sumArr = new int[len + 1];
        sumArr[0] = 0;
        for (int i = 0; i < len; i++) {
            sumArr[i + 1] = sumArr[i] + arr[i];
        }

        int res = sumArr[len];
        for (int i = 3; i < len + 1; i += 2) {
            for (int j = i; j < len + 1; j++) {
                res += sumArr[j] - sumArr[j - i];
            }
        }

        return res;
    }
}
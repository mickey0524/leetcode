// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
// algorithms
// Medium (45.49%)
// Total Accepted: 3,663
// Total Submissions: 7,987


class Solution {
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        Arrays.sort(arr);
        int curSum = 0;

        if (arr[0] * len >= target || arr[len - 1] * len <= target) {
            int tmp = target / len;
            return Math.abs(tmp * len - target) < Math.abs((tmp + 1) * len - target) ? tmp : tmp + 1;
        }

        int idx = -1;
        for (int i = 0; i < len; i++) {
            int tmp = curSum + (len - i) * arr[i];
            if (tmp >= target) {
                idx = i - 1;
                break;
            }
            curSum += arr[i];
        }

        int diff = Integer.MAX_VALUE;
        int subLen = len - idx - 1;
        int res = -1;
        for (int i = arr[idx]; i <= arr[idx + 1]; i++) {
            int tmp = curSum + subLen * i;
            int diffTmp = target - tmp;
            if (Math.abs(diffTmp) < diff) {
                diff = Math.abs(diffTmp);
                res = i;
            }
            if (diffTmp <= 0) {
                break;
            }
        }

        return res;
    }
}
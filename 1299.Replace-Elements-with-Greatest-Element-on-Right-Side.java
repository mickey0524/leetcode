// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
// algorithms
// Easy (76.1%)
// Total Accepted: 2,935
// Total Submissions: 3,857
// beats 100.0% of java submissions


class Solution {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];

        int curMax = -1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = curMax;
            curMax = Math.max(curMax, arr[i]);
        }

        return res;
    }
}
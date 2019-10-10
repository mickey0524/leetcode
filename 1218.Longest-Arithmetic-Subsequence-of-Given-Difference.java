// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
//
// algorithms
// Medium (36.7%)
// Total Accepted: 5,377
// Total Submissions: 14,651
// beats 74.97% of java submissions


class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 1, tmp = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            tmp = n - difference;
            if (map.containsKey(tmp)) {
                int prev = map.get(tmp) + 1;
                res = Math.max(res, prev);
                map.put(n, prev);
            } else if (!map.containsKey(n)) {
                map.put(n, 1);
            }
        }

        return res;
    }
}
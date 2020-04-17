// https://leetcode.com/problems/queries-on-a-permutation-with-key/
// algorithms
// Easy (82.39%)
// Total Accepted: 9,363
// Total Submissions: 11,364
// beats 100.0% of java submissions


class Solution {
    public int[] processQueries(int[] queries, int m) {
        int len = queries.length;
        int[] res = new int[len];
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < len; i++) {
            int n = queries[i];

            int targetIdx = -1;
            for (int j = 0; j < m; j++) {
                if (arr[j] == n) {
                    targetIdx = j;
                    break;
                }
            }

            res[i] = targetIdx;
            System.arraycopy(arr, 0, arr, 1, targetIdx);
            arr[0] = n;
        }

        return res;
    }
}
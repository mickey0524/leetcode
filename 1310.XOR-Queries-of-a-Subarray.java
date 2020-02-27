// https://leetcode.com/problems/xor-queries-of-a-subarray/
// algorithms
// Medium (66.3%)
// Total Accepted: 8,463
// Total Submissions: 12,764


class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int queryLen = queries.length;
        int[] res = new int[queryLen];
        int arrLen = arr.length;
        int[][] flag = new int[arrLen + 1][32];

        for (int i = 0; i < arrLen; i++) {
            char[] tmp = getBinaryCharArray(arr[i]);
            for (int j = 0; j < 32; j++) {
                flag[i + 1][j] = flag[i][j];
                if (tmp[j] == '1') {
                    flag[i + 1][j]++;
                }
            }
        }

        for (int i = 0; i < queryLen; i++) {
            int startIdx = queries[i][0], endIdx = queries[i][1];
            int ones;
            char[] tmp = new char[32];

            for (int j = 0; j < 32; j++) {
                ones = flag[endIdx + 1][j] - flag[startIdx][j];
                tmp[j] = (ones & 1) == 1 ? '1' : '0';
            }

            res[i] = Integer.valueOf(new String(tmp), 2);
        }

        return res;
    }

    private char[] getBinaryCharArray(int n) {
        char[] res = new char[32];

        String tmp = Integer.toBinaryString(n);
        int idx = tmp.length() - 1;
        for (int i = 31; i >= 0; i--) {
            res[i] = tmp.charAt(idx--);
            if (idx < 0) {
                break;
            }
        }

        return res;
    }
}
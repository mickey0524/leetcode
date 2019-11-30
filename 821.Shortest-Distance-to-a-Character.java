// https://leetcode.com/problems/shortest-distance-to-a-character/
//
// algorithms
// Easy (64.85%)
// Total Accepted: 48,327
// Total Submissions: 74,524
// beats 100.0% of java submissions


class Solution {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] res = new int[len];

        List<Integer> CIdx = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (C == S.charAt(i)) {
                CIdx.add(i);
            }
        }

        int CNum = CIdx.size();
        if (CNum == 1) {
            int tmp = CIdx.get(0);
            for (int i = 0; i < len; i++) {
                res[i] = Math.abs(tmp - i);
            }
            return res;
        }
        for (int i = 0; i < CNum; i++) {
            if (i == 0) {
                int tmp = CIdx.get(i);
                for (int j = 0; j < tmp; j++) {
                    res[j] = tmp - j;
                }
            } else {
                if (i == CNum - 1) {
                    int tmp = CIdx.get(i);
                    for (int j = len - 1; j > tmp; j--) {
                        res[j] = j - tmp;
                    }
                }
                int pre = CIdx.get(i - 1), cur = CIdx.get(i);
                int mid = pre + (cur - pre) / 2;
                for (int j = pre + 1; j <= mid; j++) {
                    res[j] = j - pre;
                }
                for (int j = mid + 1; j < cur; j++) {
                    res[j] = cur - j;
                }
            }
        }

        return res;
    }
}
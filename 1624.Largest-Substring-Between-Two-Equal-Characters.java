// https://leetcode.com/problems/largest-substring-between-two-equal-characters/
// algorithms
// Easy (59.27%)
// Total Accepted: 6,484
// Total Submissions: 10,940
// beats 100.0% of java submissions


class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] preIdx = new int[26];
        Arrays.fill(preIdx, -1);

        int res = -1, len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (preIdx[idx] != -1) {
                res = Math.max(res, i - preIdx[idx] - 1);
            } else {
                preIdx[idx] = i;
            }

        }

        return res;
    }
}
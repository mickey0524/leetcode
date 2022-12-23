// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/
// algorithms
// Medium (63.7%)
// Total Accepted: 16.5K
// Total Submissions: 25.9K


class Solution {

    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int tIdx = 0;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == t.charAt(tIdx)) {
                tIdx += 1;
                if (tIdx >= tLen) {
                    return 0;
                }
            }
        }

        return tLen - tIdx;
    }

}
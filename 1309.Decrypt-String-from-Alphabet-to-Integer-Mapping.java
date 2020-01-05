// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
// algorithms
// Easy (77.70%)
// Total Accepted: 3,864
// Total Submissions: 4,973


class Solution {
    public String freqAlphabets(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < len) {
            int n;
            if (idx < len - 2 && s.charAt(idx + 2) == '#') {
                n = Integer.valueOf(s.substring(idx, idx + 2));
                idx += 3;
            } else {
                n = Integer.valueOf(s.charAt(idx) - '0');
                idx++;
            }

            sb.append((char) ('a' + (n - 1)));
        }

        return sb.toString();
    }
}
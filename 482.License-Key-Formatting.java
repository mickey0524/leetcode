// https://leetcode.com/problems/license-key-formatting/
//
// algorithms
// Easy (42.14%)
// Total Accepted: 104,594
// Total Submissions: 248,208


class Solution {

    private static final char SEPARATOR = '-';

    public String licenseKeyFormatting(String S, int K) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        int charNum = 0;

        for (int i = len - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch == SEPARATOR) {
                continue;
            }

            sb.append(Character.toUpperCase(ch));
            charNum++;
            if (charNum == K) {
                charNum = 0;
                sb.append(SEPARATOR);
            }
        }

        if (charNum == 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

}
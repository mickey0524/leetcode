// https://leetcode-cn.com/problems/compress-string-lcci/
// algorithms
// Easy (45.65%)
// Total Accepted: 2,088
// Total Submissions: 4,574


class Solution {
    public String compressString(String S) {
        int length = S.length();
        if (length == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();

        int preIdx = 0;
        for (int i = 1; i < length; i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                sb.append(S.charAt(i - 1)).append(i - preIdx);
                preIdx = i;
            }

            if (sb.length() >= length) {
                return S;
            }
        }

        sb.append(S.charAt(length - 1)).append(length - preIdx);

        return sb.length() >= length ? S : sb.toString();
    }
}
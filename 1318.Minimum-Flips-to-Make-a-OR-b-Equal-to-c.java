// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
// algorithms
// Medium (61.16%)
// Total Accepted: 7,354
// Total Submissions: 12,024
// beats 100.0% of java submissions


class Solution {
    public int minFlips(int a, int b, int c) {
        String binaryA = leftPadding(Integer.toBinaryString(a), 32, '0');
        String binaryB = leftPadding(Integer.toBinaryString(b), 32, '0');
        String binaryC = leftPadding(Integer.toBinaryString(c), 32, '0');

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (binaryC.charAt(i) == '0') {
                if (binaryA.charAt(i) == '1') {
                    res++;
                }
                if (binaryB.charAt(i) == '1') {
                    res++;
                }
            } else {
                if (binaryA.charAt(i) == '0' && binaryB.charAt(i) == '0') {
                    res++;
                }
            }
        }

        return res;
    }

    private String leftPadding(String s, int expectLen, char paddingChar) {
        int curLen = s.length();
        if (expectLen <= curLen) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expectLen - curLen; i++) {
            sb.append(paddingChar);
        }
        sb.append(s);

        return sb.toString();
    }
}
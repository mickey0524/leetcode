// https://leetcode-cn.com/problems/convert-integer-lcci/
// algorithms
// Easy (50.2%)
// Total Accepted: 2,777
// Total Submissions: 5,532


class Solution {
    public int convertInteger(int A, int B) {
        if (A == B) {
            return 0;
        }

        String strA = zFill(Integer.toBinaryString(A), 32, '0');
        String strB = zFill(Integer.toBinaryString(B), 32, '0');

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (strA.charAt(i) != strB.charAt(i)) {
                res++;
            }
        }

        return res;
    }

    private String zFill(String s, int targetLen, char ch) {
        if (s == null) {
            return null;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetLen - len; i++) {
            sb.append(ch);
        }
        sb.append(s);

        return sb.toString();
    }
}
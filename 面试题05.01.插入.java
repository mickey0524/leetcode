// https://leetcode-cn.com/problems/insert-into-bits-lcci/
// algorithms
// Easy (45.43%)
// Total Accepted: 621
// Total Submissions: 1,367


class Solution {
    public int insertBits(int N, int M, int i, int j) {
        String nStr = zFill(toBinaryString(N), '0', 32);
        String mStr = zFill(toBinaryString(M), '0', j - i + 1);
        String tmp = nStr.substring(0, 32 - j - 1) + mStr + nStr.substring(32 - i);

        return Integer.parseInt(tmp, 2);
    }

    private String toBinaryString(int n) {
        return Integer.toBinaryString(n);
    }

    private String zFill(String s, char ch, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - s.length(); i++) {
            sb.append(ch);
        }
        sb.append(s);

        return sb.toString();
    }

}
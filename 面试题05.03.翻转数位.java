// https://leetcode-cn.com/problems/reverse-bits-lcci/
// algorithms
// Easy (47.9%)
// Total Accepted: 946
// Total Submissions: 1,975


class Solution {
    public int reverseBits(int num) {
        String str = zFill(Integer.toBinaryString(num), 32, '0');
        int res = 1;

        ArrayList<String> l = new ArrayList<>();
        int preIdx = 0;
        for (int i = 1; i < 32; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                l.add(str.substring(preIdx, i));
                preIdx = i;
            }
        }
        l.add(str.substring(preIdx));

        if (l.size() == 1) {
            return l.get(0).charAt(0) == '0' ? 1 : 32;
        }

        int lSize = l.size();
        for (int i = 0; i < lSize; i++) {
            String tmp = l.get(i);
            if (tmp.charAt(0) == '0') {
                if (tmp.length() == 1 && i > 0 && i < lSize - 1) {
                    res = Math.max(res, l.get(i - 1).length() + 1 + l.get(i + 1).length());
                }
            } else {
                res = Math.max(res, tmp.length() + 1);
            }
        }

        return res;
    }

    private String zFill(String s, int len, char ch) {
        if (s.length() == len) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - s.length(); i++) {
            sb.append(ch);
        }
        sb.append(s);

        return sb.toString();
    }
}
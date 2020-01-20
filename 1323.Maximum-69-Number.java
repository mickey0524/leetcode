// https://leetcode.com/problems/maximum-69-number/
// algorithms
// Easy (81.98%)
// Total Accepted: 6,709
// Total Submissions: 8,184
// beats 100.0% of java submissions


class Solution {
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '6') {
                chs[i] = '9';
                break;
            }
        }

        return Integer.valueOf(new String(chs));
    }
}
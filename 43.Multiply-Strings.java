// https://leetcode.com/problems/multiply-strings/
//
// algorithms
// Easy (30.57%)
// Total Accepted: 198,592
// Total Submissions: 649,579
// beats 99.12% of java submissions

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();

        String more = len1 > len2 ? num1 : num2;
        String less = len1 > len2 ? num2 : num1;
        int[] res = new int[len1 + len2];
        int beginIdx = 0;

        for (int i = less.length() - 1; i >= 0; i--) {
            int m = Integer.valueOf(less.charAt(i) - '0');
            int idx = beginIdx;
            for (int j = more.length() - 1; j >= 0; j--) {
                int n = Integer.valueOf(more.charAt(j) - '0');
                res[idx] += m * n;
                idx++;
            }
            beginIdx++;
        }

        for (int i = 0; i < len1 + len2; i++) {
            if (res[i] >= 10) {
                res[i + 1] += res[i] / 10;
                res[i] = res[i] % 10;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            ans.append(res[i]);
        }

        String r = ans.toString();
        int i = 0;

        for (; i < r.length(); i++) {
            if (r.charAt(i) != '0') {
                break;
            }
        }

        return r.substring(i);
    }
}
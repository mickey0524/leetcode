// https://leetcode.com/problems/excel-sheet-column-title/
//
// algorithms
// Easy (30.19%)
// Total Accepted: 200,464
// Total Submissions: 663,997
// beats 100.0% of java submissions


class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int tmp = (n - 1) % 26;
            sb.append((char) ('A' + tmp));

            n = (n - 1) / 26;
        }

        return sb.reverse().toString();
    }
}
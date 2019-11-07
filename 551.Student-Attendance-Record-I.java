// https://leetcode.com/problems/student-attendance-record-i/
//
// algorithms
// Easy (45.17%)
// Total Accepted:    49,022
// Total Submissions: 108,534
// beats 100.0% of java submissions

class Solution {
    public boolean checkRecord(String s) {
        int late = 0, absent = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                late = 0;
                absent++;
            } else if (ch == 'L') {
                late++;
            } else {
                late = 0;
            }

            if (absent > 1 || late > 2) {
                return false;
            }
        }

        return true;
    }
}
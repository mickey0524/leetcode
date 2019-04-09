// https://leetcode.com/problems/student-attendance-record-i/
//
// algorithms
// Easy (45.17%)
// Total Accepted:    49,022
// Total Submissions: 108,534
// beats 100.0% of java submissions

class Solution {
    public boolean checkRecord(String s) {
        int ANum = 0;
        int LNum = 0;
        int length = s.length();
        char[] chs = s.toCharArray();
        
        for (int i = 0; i < length; i++) {
            if (chs[i] == 'A') {
                ANum++;
                LNum = 0;
                if (ANum > 1) {
                    return false;
                }
            } else if (chs[i] == 'L') {
                LNum++;
                if (LNum == 3) {
                    return false;
                }
            } else {
                LNum = 0;
            }
        }
        
        return true;
    }
}
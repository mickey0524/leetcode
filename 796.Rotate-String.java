// https://leetcode.com/problems/rotate-string/
//
// algorithms
// Easy (49.79%)
// Total Accepted: 56,587
// Total Submissions: 114,343


class Solution {
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        int lenA = A.length(), lenB = B.length();
        if (lenA != lenB) {
            return false;
        }

        for (int i = 1; i < lenA; i++) {
            if (A.substring(i).equals(B.substring(0, lenA - i))
                    && A.substring(0, i).equals(B.substring(lenA - i, lenA))) {
                return true;
            }
        }

        return false;
    }
}
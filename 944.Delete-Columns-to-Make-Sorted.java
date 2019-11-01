// https://leetcode.com/problems/delete-columns-to-make-sorted/
//
// algorithms
// Easy (69.67%)
// Total Accepted: 30,408
// Total Submissions: 43,645


class Solution {
    public int minDeletionSize(String[] A) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }
        int strLen = A[0].length(), ALen = A.length;

        for (int i = 0; i < strLen; i++) {
            char tmp = A[0].charAt(i);
            for (int j = 1; j < ALen; j++) {
                if (A[j].charAt(i) < tmp) {
                    res++;
                    break;
                } else {
                    tmp = A[j].charAt(i);
                }
            }
        }

        return res;
    }
}

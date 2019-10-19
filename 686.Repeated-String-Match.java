// https://leetcode.com/problems/repeated-string-match/
//
// algorithms
// Easy (31.79%)
// Total Accepted: 76,525
// Total Submissions: 240,679


class Solution {
    public int repeatedStringMatch(String A, String B) {
        int ALen = A.length(), BLen = B.length();
        StringBuilder sb = new StringBuilder();

        sb.append(A);
        while (sb.length() < BLen) {
            sb.append(A);
        }
        sb.append(A).append(A);

        String tmp = sb.toString();
        for (int i = 0; i <= tmp.length() - BLen; i++) {
            if (tmp.substring(i, i + BLen).equals(B)) {
                int beginIdx = i % ALen;
                int first = ALen - beginIdx;
                int remainder = BLen - first;
                if (remainder <= 0) {
                    return 1;
                }
                int res = 1 + remainder / ALen;
                if (remainder % ALen == 0) {
                    return res;
                }
                return 1 + res;
            }
        }
        
        return -1;
    }
}
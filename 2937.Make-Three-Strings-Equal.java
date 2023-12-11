// https://leetcode.com/problems/make-three-strings-equal/description/
// algorithms
// Easy (40.8%)
// Total Accepted: 19.2K
// Total Submissions: 47.1K


class Solution {

    public int findMinimumOperations(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();

        int minLen = Math.min(s1Len, Math.min(s2Len, s3Len));
        int idx;
        for (idx = 0; idx < minLen; idx++) {
            if (s1.charAt(idx) != s2.charAt(idx) || s2.charAt(idx) != s3.charAt(idx) || s1.charAt(idx) != s3.charAt(idx)) {
                break;
            }
        }
        
        return idx == 0 ? -1 : s1Len + s2Len + s3Len - idx * 3;
    }
    

}
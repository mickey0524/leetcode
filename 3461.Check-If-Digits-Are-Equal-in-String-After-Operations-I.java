// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
// algorithms
// Easy (79.8%)
// Total Accepted: 38.7K
// Total Submissions: 48.5K


class Solution {

    public boolean hasSameDigits(String s) {
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            sb.append((s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10);
        }
        
        return hasSameDigits(sb.toString());
    }

}



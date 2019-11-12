// https://leetcode.com/problems/detect-capital/
//
// algorithms
// Easy (52.82%)
// Total Accepted: 95,676
// Total Submissions: 181,124
// beats 100.0% of java submissions


class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 0) {
            return true;
        }

        char[] chArr = word.toCharArray();

        if (Character.isLowerCase(chArr[0])) {
            for (int i = 1; i < len; i++) {
                if (Character.isUpperCase(chArr[i])) {
                    return false;
                }
            }

            return true;
        } else {
            boolean lower = true;
            if (len > 1 && Character.isUpperCase(chArr[1])) {
                lower = false;
            }
            for (int i = 1; i < len; i++) {
                if (lower && Character.isUpperCase(chArr[i])) {
                    return false;
                }
                if (!lower && Character.isLowerCase(chArr[i])) {
                    return false;
                }
            }

            return true;
        }
    }
}
// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
// algorithms
// Easy (75.86%)
// Total Accepted: 8.8K
// Total Submissions: 11.6K


class Solution {

    public boolean areOccurrencesEqual(String s) {
        int[] tmp = new int[26];
        for (char ch : s.toCharArray()) {
            tmp[ch - 'a']++;
        }

        int times = -1;
        for (int i = 0; i < 26; i++) {
            if (tmp[i] == 0) {
                continue;
            }

            if (times == -1) {
                times = tmp[i];
            } else if (tmp[i] != times) {
                return false;
            }
        }

        return true;
    }

}
// https://leetcode.com/problems/scramble-string/
//
// algorithms
// Medium (31.67%)
// Total Accepted: 91,120
// Total Submissions: 287,720
// beats 100.0% of java submissions

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();

        int[] chs = new int[26];
        boolean res = true;
        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            chs[ch1 - 'a']++;
            chs[ch2 - 'a']--;
            if (ch1 != ch2) {
                res = false;
            }
        }
        if (res) {
            return true;
        }

        for (int n : chs) {
            if (n != 0) {
                return false;
            }
        }

        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && (isScramble(s1.substring(i), s2.substring(i)))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && (isScramble(s1.substring(i), s2.substring(0, len - i)))) {
                return true;
            }
        }

        return false;
    }
}
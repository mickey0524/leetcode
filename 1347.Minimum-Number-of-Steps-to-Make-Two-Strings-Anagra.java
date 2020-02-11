// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
// algorithms
// Medium (76.79%)
// Total Accepted: 6,825
// Total Submissions: 8,888
// beats 100.0% of java submissions


class Solution {
    public int minSteps(String s, String t) {
        int len = s.length();
        int[] charNumS = new int[26];
        int[] charNumT = new int[26];

        for (int i = 0; i < len; i++) {
            charNumS[s.charAt(i) - 'a']++;
            charNumT[t.charAt(i) - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (charNumT[i] > charNumS[i]) {
                res += charNumT[i] - charNumS[i];
            }
        }

        return res;
    }
}
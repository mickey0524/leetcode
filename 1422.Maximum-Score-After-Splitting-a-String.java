// https://leetcode.com/problems/maximum-score-after-splitting-a-string/
// algorithms
// Easy (52.95%)
// Total Accepted: 7,965
// Total Submissions: 15,043
// beats 100.0% of java submissions


class Solution {
    public int maxScore(String s) {
        int len = s.length();
        char[] chArr = s.toCharArray();
        int score = 0;

        for (int i = len - 1; i > 0; i--) {
            if (chArr[i] == '1') {
                score++;
            }
        }
        if (chArr[0] == '0') {
            score++;
        }

        int tmp = score;
        for (int i = 1; i < len - 1; i++) {
            if (chArr[i] == '0') {
                tmp++;
            } else {
                tmp--;
            }

            score = Math.max(score, tmp);
        }

        return score;
    }
}
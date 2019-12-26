// https://leetcode.com/problems/shortest-completing-word/
//
// algorithms
// Easy (55.78%)
// Total Accepted: 26,939
// Total Submissions: 48,294
// beats 100.0% of java submissions


class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] chNum = new int[26];
        for (char ch : licensePlate.toCharArray()) {
            if (isLetter(ch)) {
                char tmp = Character.toLowerCase(ch);
                chNum[tmp - 'a']++;
            }
        }

        String res = null;
        for (String w : words) {
            String tmp = w.toLowerCase();
            int[] chNumTmp = Arrays.copyOf(chNum, 26);
            for (char ch : tmp.toCharArray()) {
                chNumTmp[ch - 'a']--;
            }

            boolean ok = true;
            for (int n : chNumTmp) {
                if (n > 0) {
                    ok = false;
                    break;
                }
            }

            if (ok && (res == null || res.length() > w.length())) {
                res = w;
            }
        }

        return res;
    }

    private boolean isLetter(char ch) {
        ch = Character.toLowerCase(ch);
        int tmp = ch - 'a';
        if (tmp >= 0 && tmp < 26) {
            return true;
        }

        return false;
    }
}
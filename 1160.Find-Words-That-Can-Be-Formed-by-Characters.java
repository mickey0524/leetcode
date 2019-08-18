// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
//
// algorithms
// Easy (71.72%)
// Total Accepted: 3,629
// Total Submissions: 5,060
// beats 100.0% of java submissions


class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsNum = new int[26];

        for (char ch : chars.toCharArray()) {
            charsNum[ch - 'a']++;
        }

        int res = 0;
        for (String s : words) {
            int[] tmp = new int[26];
            boolean isOk = true;
            for (char ch : s.toCharArray()) {
                tmp[ch - 'a'] += 1;
                if (tmp[ch - 'a'] > charsNum[ch - 'a']) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                res += s.length();
            }
        }

        return res;
    }
}
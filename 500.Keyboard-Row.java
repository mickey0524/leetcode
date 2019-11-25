// https://leetcode.com/problems/keyboard-row/
//
// algorithms
// Easy (63.16%)
// Total Accepted: 98.4K
// Total Submissions: 155.8K


class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        int[] chArr = new int[26];
        for (char ch : new char[] { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P' }) {
            chArr[ch - 'A'] = 0;
        }

        for (char ch : new char[] { 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L' }) {
            chArr[ch - 'A'] = 1;
        }

        for (char ch : new char[] { 'Z', 'X', 'C', 'V', 'B', 'N', 'M' }) {
            chArr[ch - 'A'] = 2;
        }

        for (String w : words) {
            int tmp = -1;
            boolean ok = true;
            for (char ch : w.toCharArray()) {
                if (tmp == -1) {
                    tmp = chArr[Character.toUpperCase(ch) - 'A'];
                } else {
                    if (chArr[Character.toUpperCase(ch) - 'A'] != tmp) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                res.add(w);
            }
        }

        return res.toArray(new String[0]);
    }
}
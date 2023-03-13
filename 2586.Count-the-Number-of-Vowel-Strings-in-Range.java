// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
// algorithms
// Easy (78.83%)
// Total Accepted: 17.5K
// Total Submissions: 22.2K


class Solution {

    private static final Set<Character> VOWEL_SET = new HashSet<>();

    static {
        VOWEL_SET.add('a');
        VOWEL_SET.add('e');
        VOWEL_SET.add('i');
        VOWEL_SET.add('o');
        VOWEL_SET.add('u');
    }

    public int vowelStrings(String[] words, int left, int right) {
        int wordNum = words.length;
        int safeLeft = Math.max(left, 0);
        int safeRight = Math.min(right, wordNum - 1);

        int res = 0;
        for (int i = safeLeft; i <= safeRight; i++) {
            int wordLen = words[i].length();
            if (wordLen > 0 && VOWEL_SET.contains(words[i].charAt(0)) && VOWEL_SET.contains(words[i].charAt(wordLen - 1))) {
                res++;
            } 
        }

        return res;
    }

}
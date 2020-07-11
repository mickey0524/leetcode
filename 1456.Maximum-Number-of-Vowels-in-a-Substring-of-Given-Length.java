// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
// algorithms
// Medium (51.66%)
// Total Accepted: 14,408
// Total Submissions: 27,892


class Solution {

    private static final Set<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public int maxVowels(String s, int k) {
        int len = s.length();
        char[] chArr = s.toCharArray();

        int res = 0;
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(chArr[i])) {
                tmp++;
            }
        }
        res = tmp;

        for (int i = k; i < len; i++) {
            if (set.contains(chArr[i - k])) {
                tmp--;
            }
            if (set.contains(chArr[i])) {
                tmp++;
            }

            res = Math.max(res, tmp);
        }

        return res;
    }

}
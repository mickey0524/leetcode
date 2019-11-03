// https://leetcode.com/problems/letter-case-permutation/
//
// algorithms
// Easy (59.87%)
// Total Accepted: 61,594
// Total Submissions: 102,874
// beats 100.0% of java submissions


class Solution {

    List<String> res;

    public List<String> letterCasePermutation(String S) {
        char[] chs = S.toCharArray();
        res = new ArrayList<>();

        recursive(chs, 0);

        return res;
    }

    public void recursive(char[] chs, int idx) {
        int len = chs.length;

        if (idx == len) {
            res.add(new String(chs));
            return;
        }

        if (!isAlpha(chs[idx])) {
            recursive(chs, idx + 1);
        } else {
            chs[idx] = Character.toLowerCase(chs[idx]);
            recursive(chs, idx + 1);
            chs[idx] = Character.toUpperCase(chs[idx]);
            recursive(chs, idx + 1);
        }
    }

    public boolean isAlpha(char ch) {
        int tmp = ch - 'a';
        if (tmp >= 0 && tmp <= 25) {
            return true;
        }

        tmp = ch - 'A';
        if (tmp >= 0 && tmp <= 25) {
            return true;
        }

        return false;
    }

}
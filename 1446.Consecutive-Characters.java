// https://leetcode.com/problems/consecutive-characters/
// algorithms
// Easy (63.22%)
// Total Accepted: 6,170
// Total Submissions: 9,759
// beats 100.0% of java submissions


class Solution {
    public int maxPower(String s) {
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        int preIdx = 0;
        int res = 1;

        for (int i = 1; i < len; i++) {
            if (chArr[i] != chArr[i - 1]) {
                res = Math.max(res, i - preIdx);
                preIdx = i;
            }
        }

        return Math.max(res, len - preIdx);
    }
}
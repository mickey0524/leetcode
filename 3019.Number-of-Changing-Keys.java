// https://leetcode.com/problems/number-of-changing-keys/description/
// algorithms
// Easy (80.0%)
// Total Accepted: 38.3K
// Total Submissions: 47.9K

class Solution {

    public int countKeyChanges(String s) {
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        if (len == 0) {
            return 0;
        }

        int res = 0;
        char preCh = Character.toLowerCase(chArr[0]);
        for (int i = 1; i < len; i++) {
            char curCh = Character.toLowerCase(chArr[i]);
            if (curCh != preCh) {
                res += 1;
                preCh = curCh;
            }
        }

        return res;
    }

}
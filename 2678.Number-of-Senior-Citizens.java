// https://leetcode.com/problems/number-of-senior-citizens/description/
// algorithms
// Easy (78.85%)
// Total Accepted: 16.4K
// Total Submissions: 20.8K


class Solution {

    public int countSeniors(String[] details) {
        int res = 0;

        for (String s : details) {
            int age = Integer.parseInt(s.substring(11, 13));
            if (age > 60) {
                res += 1;
            }
        }

        return res;
    }

}
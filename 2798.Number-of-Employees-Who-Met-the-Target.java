// https://leetcode.com/problems/number-of-employees-who-met-the-target/
// algorithms
// Easy (48.73%)
// Total Accepted: 24.8K
// Total Submissions: 27.3K


class Solution {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        
        for (int h : hours) {
            if (h >= target) {
                res += 1;
            }
        }

        return res;
    }

}
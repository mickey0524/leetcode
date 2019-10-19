// https://leetcode.com/problems/airplane-seat-assignment-probability/
//
// algorithms
// Easy (67.4%)
// Total Accepted: 492
// Total Submissions: 730
// beats 100.0% of java submissions


class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0;
        }
        
        return 0.5;
    }
}
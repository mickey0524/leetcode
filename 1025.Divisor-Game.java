// https://leetcode.com/problems/divisor-game/
//
// algorithms
// Medium (55.70%)
// Total Accepted:    3,087
// Total Submissions: 5,542

class Solution {
    public boolean divisorGame(int N) {
        return (N & 1) == 1 ? false : true;
    }
}
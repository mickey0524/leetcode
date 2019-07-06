// https://leetcode.com/problems/nim-game/
//
// algorithms
// Easy (55.70%)
// Total Accepted:    186,525
// Total Submissions: 334,882
// beats 100.0% of java submissions

public class Solution {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }
}
// https://leetcode.com/problems/total-distance-traveled/
// algorithms
// Easy (37.95%)
// Total Accepted: 20K
// Total Submissions: 52.7K

class Solution {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        
        while (mainTank >= 5) {
            res += 50;
            mainTank -= 5;
            if (additionalTank > 0) {
                mainTank += 1;
                additionalTank -= 1;
            }
        }

        res += 10 * mainTank;

        return res;
    }

}

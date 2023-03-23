// https://leetcode.com/problems/pass-the-pillow/
// algorithms
// Easy (46.25%)
// Total Accepted: 22.8K
// Total Submissions: 49.3K

class Solution {

    public int passThePillow(int n, int time) {
        int loopLen = n - 1;

        int curIdx = 1;
        int direction = 1;
        while (time >= loopLen) {
            if (direction == 1) {
                curIdx += loopLen;
            } else {
                curIdx -= loopLen;
            }

            time -= loopLen;
            direction = -direction;
        }

        return direction == 1 ? curIdx + time : curIdx - time;
    }

}
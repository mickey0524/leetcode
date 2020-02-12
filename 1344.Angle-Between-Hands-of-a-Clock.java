// https://leetcode.com/problems/angle-between-hands-of-a-clock/
// algorithms
// Medium (61.62%)
// Total Accepted: 3,529
// Total Submissions: 5,727
// beats 100.0% of java submissions


class Solution {

    private static final double HOUR_UNIT = 60.0;
    private static final double HOUR_ANGLE = 30.0;
    private static final double MINUTE_ANGLE = 6.0;

    public double angleClock(int hour, int minutes) {
        hour %= 12;
        double extraAngle = ((double) minutes / HOUR_UNIT) * HOUR_ANGLE;
        double minutePos = MINUTE_ANGLE * minutes;
        double hourPos = HOUR_ANGLE * hour + extraAngle;

        double angleDiff = Math.abs(minutePos - hourPos);
        if (angleDiff > 180) {
            angleDiff = 360 - angleDiff;
        }

        return angleDiff;
    }

}
// https://leetcode.com/problems/valid-boomerang/
//
// algorithms
// Easy (35.88%)
// Total Accepted:    3,514
// Total Submissions: 9,793
// beats 100.0% of java submissions

class Solution {
    
    public boolean isBoomerang(int[][] points) {
        if ((points[0][0] == points[1][0] && points[0][1] == points[1][1]) ||
            (points[0][0] == points[2][0] && points[0][1] == points[2][1]) ||
            (points[1][0] == points[2][0] && points[1][1] == points[2][1])) {
            return false;
        }
            
        int xDiff = points[1][0] - points[0][0];
        int yDiff = points[1][1] - points[0][1];
        
        int xTmpDiff = points[2][0] - points[1][0];
        int yTmpDiff = points[2][1] - points[1][1];
        
        if (xDiff * xTmpDiff == 0) {
            return (xDiff == 0 && xTmpDiff == 0) ? false : true;
        }
        
        if (yDiff * yTmpDiff == 0) {
            return (yDiff == 0 && yTmpDiff == 0) ? false : true;
        }
        
        int gcd = getMaxGcd(xDiff, yDiff);
        xDiff /= gcd;
        yDiff /= gcd;
        
        gcd = getMaxGcd(xTmpDiff, yTmpDiff);
        xTmpDiff /= gcd;
        yTmpDiff /= gcd;
        
        if (xDiff == xTmpDiff && yDiff == yTmpDiff) {
            return false;
        }
        
        return true;
    }
    
    public int getMaxGcd(int a, int b) {
        int res = 1;
        
        for (int i = 2; i < Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                res = i;
            }
        }
        
        return res;
    }
    
}
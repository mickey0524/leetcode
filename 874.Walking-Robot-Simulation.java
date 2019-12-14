// https://leetcode.com/problems/walking-robot-simulation/
//
// algorithms
// Easy (33.64%)
// Total Accepted: 13,605
// Total Submissions: 40,437
// beats 100.0% of java submissions


class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Point> obstacleMap = new HashSet<>();
        for (int[] o : obstacles) {
            obstacleMap.add(new Point(o[0], o[1]));
        }
        int xStep = 0, yStep = 1;
        int res = 0, x = 0, y = 0;

        for (int c : commands) {
            if (c == -2) {
                if (xStep == 0 && yStep == 1) {
                    xStep = -1;
                    yStep = 0;
                } else if (xStep == -1 && yStep == 0) {
                    xStep = 0;
                    yStep = -1;
                } else if (xStep == 0 && yStep == -1) {
                    xStep = 1;
                    yStep = 0;
                } else {
                    xStep = 0;
                    yStep = 1;
                }
            } else if (c == -1) {
                if (xStep == 0 && yStep == 1) {
                    xStep = 1;
                    yStep = 0;
                } else if (xStep == 1 && yStep == 0) {
                    xStep = 0;
                    yStep = -1;
                } else if (xStep == 0 && yStep == -1) {
                    xStep = -1;
                    yStep = 0;
                } else {
                    xStep = 0;
                    yStep = 1;
                }
            } else {
                for (int i = 0; i < c; i++) {
                    int xTmp = x + xStep;
                    int yTmp = y + yStep;
                    Point point = new Point(xTmp, yTmp);
                    if (obstacleMap.contains(point)) {
                        break;
                    }

                    x = xTmp;
                    y = yTmp;
                }
            }
            res = Math.max(res, calculate(x, y));
        }

        return res;
    }

    private int calculate(int x, int y) {
        return x * x + y * y;
    }

    private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x ^ y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Point)) {
                return false;
            }

            Point tmp = (Point) obj;
            if (this.x == tmp.x && this.y == tmp.y) {
                return true;
            }

            return false;
        }
    }

}
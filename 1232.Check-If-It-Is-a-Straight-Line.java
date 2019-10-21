// https://leetcode.com/problems/check-if-it-is-a-straight-line/
//
// algorithms
// Easy (47.04%)
// Total Accepted: 5,219
// Total Submissions: 11,094


class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int xDiff = coordinates[1][0] - coordinates[0][0], xTmp = -1;
        int yDiff = coordinates[1][1] - coordinates[0][1], yTmp = -1;

        for (int i = 2; i < coordinates.length; i++) {
            xTmp = coordinates[i][0] - coordinates[i - 1][0];
            yTmp = coordinates[i][1] - coordinates[i - 1][1];

            if (yDiff * xTmp != yTmp * xDiff) {
                return false;
            }
            
            xDiff = xTmp;
            yDiff = yTmp;
        }

        return true;
    }
}
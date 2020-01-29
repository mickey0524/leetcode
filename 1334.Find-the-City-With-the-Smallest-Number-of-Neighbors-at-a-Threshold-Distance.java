// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
// algorithms
// Easy (37.94%)
// Total Accepted: 3,588
// Total Submissions: 9,456
// beats 100.0% of java submissions


class Solution {

    private static final int MAX_THRESHOLD = 10001;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], MAX_THRESHOLD);
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }

                    if (distance[j][i] + distance[i][k] < distance[j][k]) {
                        distance[j][k] = distance[j][i] + distance[i][k];
                        distance[k][j] = distance[j][k];
                    }
                }
            }
        }

        int res = -1, city = Integer.MAX_VALUE, tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    tmp++;
                }
            }
            if (tmp <= city) {
                city = tmp;
                res = i;
            }
        }

        return res;
    }
}
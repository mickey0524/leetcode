// https://leetcode.com/problems/maximal-network-rank/
// algorithms
// Easy (50.96%)
// Total Accepted: 8,401
// Total Submissions: 16,487


class Solution {

    private static final char SEPARATOR = '|';

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        Set<String> connectedSet = new HashSet<>();

        for (int[] r : roads) {
            degree[r[0]]++;
            degree[r[1]]++;

            connectedSet.add(buildKey(r));
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = degree[i] + degree[j];
                if (connectedSet.contains(buildKey(new int[] { i, j }))) {
                    tmp--;
                }

                res = Math.max(res, tmp);
            }
        }

        return res;
    }

    private String buildKey(int[] r) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(r);
        sb.append(r[0]).append(SEPARATOR).append(r[1]);

        return sb.toString();
    }
}
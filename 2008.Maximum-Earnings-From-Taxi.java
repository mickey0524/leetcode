// https://leetcode.com/problems/maximum-earnings-from-taxi/
// algorithms
// Mediumm (36.47%)
// Total Accepted: 3.1K
// Total Submissions: 8.5K


class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (o1, o2) -> o1[1] - o2[1]);

        long[] dp = new long[n + 1];
        int len = rides.length;
        int idx = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1];

            while (idx < len && rides[idx][1] <= i) {
                dp[i] = Math.max(dp[i], dp[rides[idx][0]] + rides[idx][1] - rides[idx][0] + rides[idx][2]);
                idx++;
            }
        }

        return dp[n];
    }
}
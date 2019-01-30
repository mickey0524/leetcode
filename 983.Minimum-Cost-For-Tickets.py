# https://leetcode.com/problems/minimum-cost-for-tickets/
# Medium (56.46%)
# Total Accepted:    2,490
# Total Submissions: 4,410
# beats 100.0% of python submissions


class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        day_idx = 0
        dp = [0] * (days[-1] + 1)

        for i in xrange(days[-1] + 1):
            if i == days[day_idx]:
                dp[i] = min(dp[i - 1] + costs[0], dp[max(i - 7, 0)] + costs[1], dp[max(i - 30, 0)] + costs[2])
                day_idx += 1
            else:
                dp[i] = dp[i - 1]

        return dp[-1]
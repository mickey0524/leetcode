# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
#
# algorithms
# Medium (43.48%)
# Total Accepted:    83,141
# Total Submissions: 191,230
# beats 100.0% of python submissions


class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        notown = 0
        own, cool = float('-inf'), float('-inf')

        for p in prices:
            notown, own, cool = max(notown, cool), max(
                own, notown - p), own + p

        return max(notown, cool)


# 股票类题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
class Solution1(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        length = len(prices)
        if length < 2:
            return 0

        cur_0, cur_1, pre_0 = 0, float('-inf'), 0

        for n in prices:
            tmp = cur_0
            cur_0 = max(tmp, cur_1 + n)
            cur_1 = max(cur_1, pre_0 - n)
            pre_0 = tmp

        return cur_0

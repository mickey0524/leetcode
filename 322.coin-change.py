# https://leetcode-cn.com/problems/coin-change/
#
# algorithms
# Medium (29.48%)
# Total Accepted:    6,546
# Total Submissions: 22,206

from collections import deque


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 0

        coins.sort(reverse=True)
        queue = deque()
        s = set()

        for c in coins:
            if c == amount:
                return 1
            queue.append((c, 1))
            s.add(c)

        while len(queue) > 0:
            cur_s, cur_n = queue.popleft()
            for c in coins:
                tmp = cur_s + c
                if tmp == amount:
                    return cur_n + 1
                elif tmp < amount and tmp not in s:
                    queue.append((tmp, cur_n + 1))
                    s.add(tmp)

        return -1

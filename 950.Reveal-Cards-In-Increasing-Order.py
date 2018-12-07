# algorithms
# Medium (71.58%)
# Total Accepted:    3,226
# Total Submissions: 4,507
# beats 95.95% of python submissions

# 思路是用一个队列去遍历一遍翻牌的顺序，就知道依次被翻牌的索引，然后将相应
# 大小的元素填充进去即可

from collections import deque


class Solution(object):
    def deckRevealedIncreasing(self, deck):
        """
        :type deck: List[int]
        :rtype: List[int]
        """
        length = len(deck)
        deck.sort()

        if length < 3:
            return deck
        queue = deque([i for i in xrange(length)])
        order = []
        res = [0] * length

        for i in xrange(length):
            order += queue.popleft(),
            if i != length - 1:
                queue.append(queue.popleft())

        for idx, i in enumerate(order):
            res[i] = deck[idx]

        return res

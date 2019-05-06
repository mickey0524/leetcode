# https://leetcode.com/problems/moving-stones-until-consecutive-ii/
# Medium (40.05%)
# Total Accepted:    566
# Total Submissions: 1,412


class Solution(object):
    def numMovesStonesII(self, stones):
        """
        :type stones: List[int]
        :rtype: List[int]
        """
        length = len(stones)

        stones.sort()

        min_move, max_move = 0, 0

        i, j = 0, length - 1

        while i < j:
            l = stones[i + 1] - stones[i] - 1
            r = stones[j] - stones[j - 1] - 1

            if i == 0 and j == length - 1:
                max_move += max(l, r)
            else:
                max_move += (l + r) if i + 1 != j else l

            i += 1
            j -= 1

        window = float('-inf')
        j = 0

        for i in xrange(length):
            bound = stones[i] + length - 1
            while j < length and stones[j] <= bound:
                j += 1
            if bound != stones[j - 1] + 1:
                window = max(window, j - i)

        min_move = length - window

        return [min_move, max_move]

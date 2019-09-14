# https://leetcode.com/problems/car-fleet/
#
# algorithms
# Medium (40.69%)
# Total Accepted:    18,228
# Total Submissions: 44,797


from collections import deque


class Solution(object):
    def carFleet(self, target, position, speed):
        """
        :type target: int
        :type position: List[int]
        :type speed: List[int]
        :rtype: int
        """
        length = len(position)
        if length < 2:
            return length

        tmp = [(position[i], speed[i]) for i in xrange(length)]
        tmp.sort()

        cost = [0] * length
        for i in xrange(length):
            cost[i] = (target - tmp[i][0]) / float(tmp[i][1])

        stack = deque()
        for i in xrange(length):
            while stack and cost[i] >= cost[stack[-1]]:
                stack.pop()

            stack.append(i)

        return len(stack)

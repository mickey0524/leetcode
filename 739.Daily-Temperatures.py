# https://leetcode.com/problems/daily-temperatures/
#
# algorithms
# Medium (60.41%)
# Total Accepted:    81,954
# Total Submissions: 135,664


from collections import deque


class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        s = deque()
        length = len(T)
        res = [0] * length

        for idx, n in enumerate(T):
            while s and n > T[s[-1]]:
                i = s.pop()
                res[i] = idx - i

            s.append(idx)

        return res

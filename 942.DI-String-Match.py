# https://leetcode.com/problems/di-string-match/description/
#
# algorithms
# Easy (65.22%)
# Total Accepted:    3k
# Total Submissions: 4.6k

from collections import deque

class Solution(object):
    def diStringMatch(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        length = len(S)
        head, tail = 0, length
        res = deque()

        for ch in S[::-1]:
            if ch == 'D':
                res.appendleft(head)
                head += 1
            else:
                res.appendleft(tail)
                tail -= 1
        
        res.appendleft(head)

        return list(res)
        
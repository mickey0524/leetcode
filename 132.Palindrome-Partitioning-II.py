# https://leetcode.com/problems/palindrome-partitioning-ii/description/
#
# algorithms
# Hard (25.94%)
# Total Accepted:    91k
# Total Submissions: 350.8k
# beats 27.12% of python submissions
# 我自己是用BFS，去记录每一个回文串，直到触达str尾部

from collections import deque


class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        if length < 2:
            return 0

        is_visited = {0, }
        queue = deque([(0, 0)])

        while queue:
            cut, idx = queue.popleft()
            if s[idx:] == s[idx:][::-1]:
                return cut
            for i in xrange(idx + 1, length + 1):
                if i not in is_visited and s[idx:i] == s[idx:i][::-1]:
                    is_visited.add(i)
                    queue.append((cut + 1, i))


# beats 100.0% of python submissions
# 看了一下最快的做法，用的是DP的思想，记录一下

class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == s[::-1]:
            return 0
        for i in range(1, len(s)):
            if s[:i] == s[:i][::-1] and s[i:] == s[i:][::-1]:
                return 1
        # algorithm
        # cut numbers in worst case (no palindrome)
        cut = [x for x in range(-1, len(s))]
        for i in range(len(s)):
            r1, r2 = 0, 0
            # use i as origin, and gradually enlarge radius if a palindrome exists
            # odd palindrome
            while i-r1 >= 0 and i+r1 < len(s) and s[i-r1] == s[i+r1]:
                cut[i+r1+1] = min(cut[i+r1+1], cut[i-r1]+1)
                r1 += 1
            # even palindrome
            while i-r2 >= 0 and i+r2+1 < len(s) and s[i-r2] == s[i+r2+1]:
                cut[i+r2+2] = min(cut[i+r2+2], cut[i-r2]+1)
                r2 += 1
        return cut[-1]

# https://leetcode.com/problems/all-possible-full-binary-trees/description/
#
# algorithms
# Medium (48.10%)
# Total Accepted:    3.8k
# Total Submissions: 7.9k
# beats 37.32% of python submissions

from collections import Counter, defaultdict


class FreqStack(object):

    def __init__(self):
        self.stack = defaultdict(list)
        self.hash_map = Counter()
        self.max_freq = 0

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.hash_map[x] += 1
        self.max_freq = max(self.max_freq, self.hash_map[x])
        self.stack[self.hash_map[x]].append(x)

    def pop(self):
        """
        :rtype: int
        """
        res = self.stack[self.max_freq].pop()
        if not self.stack[self.max_freq]:
            for i in xrange(self.max_freq - 1, 0, -1):
                if i in self.stack:
                    self.max_freq = i
                    break

        self.hash_map[res] -= 1

        return res


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(x)
# param_2 = obj.pop()

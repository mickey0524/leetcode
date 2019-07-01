# https://leetcode.com/problems/implement-stack-using-queues/
#
# algorithms
# Medium (39.64%)
# Total Accepted:    132,639
# Total Submissions: 334,578
# beats 94.52% of python submissions

from collections import deque


class MyStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q_1 = deque()
        self.q_2 = deque()
        self.use_1 = True

    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: void
        """
        if self.use_1:
            self.q_1.appendleft(x)
        else:
            self.q_2.appendleft(x)

    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        return self._pop_or_top(True)

    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        return self._pop_or_top(False)

    def _pop_or_top(self, is_pop):
        if self.use_1:
            from_q, to_q = self.q_1, self.q_2
        else:
            from_q, to_q = self.q_2, self.q_1

        while len(from_q) > 1:
            to_q.appendleft(from_q.pop())

        res = from_q.pop()
        
        if not is_pop:
            to_q.appendleft(res)
        self.use_1 = not self.use_1
        
        return res

    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        return len(self.q_1) + len(self.q_2) == 0
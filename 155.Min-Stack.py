# https://leetcode.com/problems/min-stack/
#
# algorithms
# Easy (34.63%)
# Total Accepted:    248,646
# Total Submissions: 718,028

from collections import deque

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data_stack = deque()
        self.min_stack = deque()

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.data_stack.append(x)
        
        if len(self.min_stack) == 0:
            self.min_stack.append(x)
        elif x < self.min_stack[-1]:
            self.min_stack.append(x)
        else:
            self.min_stack.append(self.min_stack[-1])
            

    def pop(self):
        """
        :rtype: void
        """
        self.data_stack.pop()
        self.min_stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.data_stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
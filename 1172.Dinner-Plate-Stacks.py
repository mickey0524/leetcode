# https://leetcode.com/problems/dinner-plate-stacks/
# Hard (42.68%)
# Total Accepted:    2,115
# Total Submissions: 4,955


from collections import deque
from heapq import heappush, heappop


class DinnerPlates(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cap = capacity
        self.max_idx = -1
        self.stack_arr = []
        self.h = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if self.h:
            index = heappop(self.h)
            self.stack_arr[index].append(val)
            return

        if self.max_idx == -1 or len(self.stack_arr[self.max_idx]) == self.cap:
            self.max_idx += 1
            self.stack_arr.append(deque())

        self.stack_arr[self.max_idx].append(val)

    def pop(self):
        """
        :rtype: int
        """
        while self.max_idx >= 0 and not self.stack_arr[self.max_idx]:
            self.max_idx -= 1

        if self.max_idx < 0:
            return -1

        return self.stack_arr[self.max_idx].pop()

    def popAtStack(self, index):
        """
        :type index: int
        :rtype: int
        """
        if index > self.max_idx or not self.stack_arr[index]:
            return -1

        if index != self.max_idx:
            heappush(self.h, index)

        return self.stack_arr[index].pop()


# Your DinnerPlates object will be instantiated and called as such:
# obj = DinnerPlates(capacity)
# obj.push(val)
# param_2 = obj.pop()
# param_3 = obj.popAtStack(index)

# https://leetcode.com/problems/flatten-nested-list-iterator/
#
# algorithms
# Medium (46.07%)
# Total Accepted:    92,527
# Total Submissions: 200,821

from collections import deque
class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.q = deque()
        self.flatten(nestedList)
    
    # [[1, [2, [3]]]]
    def flatten(self, nestedList):
        for nested in nestedList:
            if nested.isInteger():
                self.q.append(nested.getInteger())
            else:
                self.flatten(nested.getList())

    def next(self):
        """
        :rtype: int
        """
        return self.q.popleft()

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.q) > 0
        
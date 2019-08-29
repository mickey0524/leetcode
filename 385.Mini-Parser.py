# https://leetcode.com/problems/mini-parser/
#
# algorithms
# Medium (32.31%)
# Total Accepted:    31,885
# Total Submissions: 98,686

# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class Solution(object):
    def deserialize(self, s):
        """
        :type s: str
        :rtype: NestedInteger
        """
        root = NestedInteger()

        if s.isdigit() or s[0] == '-':
            root.setInteger(s)

        else:
            s = s[1:-1]
            if len(s) == 0:
                return root

            left_bracket_num = 0
            pre_idx = 0

            for i in xrange(len(s)):
                if s[i] == '[':
                    left_bracket_num += 1
                elif s[i] == ']':
                    left_bracket_num -= 1
                elif s[i] == ',' and left_bracket_num == 0:
                    root.add(self.deserialize(s[pre_idx:i]))
                    pre_idx = i + 1

            if left_bracket_num == 0:
                root.add(self.deserialize(s[pre_idx:]))

        return root

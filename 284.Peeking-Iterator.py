# https://leetcode.com/problems/peeking-iterator/
#
# algorithms
# Medium (40.95%)
# Total Accepted:    77,177
# Total Submissions: 188,454
# beats 100.0% of python submissions


# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator(object):
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """

class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.iter = iterator
        self.cur = None
        

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if self.cur is None:
            self.cur = self.iter.next()
        
        return self.cur
        

    def next(self):
        """
        :rtype: int
        """
        if self.cur is None:
            return self.iter.next()
        
        res = self.cur
        self.cur = None
        
        return res
        

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.cur is not None:
            return True
        
        return self.iter.hasNext()
        

# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].
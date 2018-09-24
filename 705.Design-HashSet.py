# https://leetcode.com/problems/design-hashset/description/
#
# algorithms
# Easy (37.78%)
# Total Accepted:    5.1k
# Total Submissions: 13.5k
# beats 93.32% of python submissions


class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hash_map = {}

    def add(self, key):
        """
        :type key: int
        :rtype: void
        """
        self.hash_map[key] = self.hash_map.get(key, 0) + 1

    def remove(self, key):
        """
        :type key: int
        :rtype: void
        """
        if self.contains(key):
            del self.hash_map[key]

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        return key in self.hash_map

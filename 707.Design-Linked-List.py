# https://leetcode.com/problems/design-linked-list/description/
#
# algorithms
# Easy (17.27%)
# Total Accepted:    7.2k
# Total Submissions: 41.7k
# beats 96.32% of python submissions


class MyLinkedList(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self._link_list = []

    def get(self, index):
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        :type index: int
        :rtype: int
        """
        if index < 0 or index >= len(self._link_list):
            return -1

        return self._link_list[index]

    def addAtHead(self, val):
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        :type val: int
        :rtype: void
        """
        self._link_list.insert(0, val)

    def addAtTail(self, val):
        """
        Append a node of value val to the last element of the linked list.
        :type val: int
        :rtype: void
        """
        self._link_list.append(val)

    def addAtIndex(self, index, val):
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        :type index: int
        :type val: int
        :rtype: void
        """
        if index <= len(self._link_list):
            self._link_list.insert(index, val)

    def deleteAtIndex(self, index):
        """
        Delete the index-th node in the linked list, if the index is valid.
        :type index: int
        :rtype: void
        """
        if index < 0 or index >= len(self._link_list):
            return

        self._link_list.pop(index)

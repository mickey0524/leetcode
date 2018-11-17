# https://leetcode.com/problems/copy-list-with-random-pointer/description/
#
# algorithms
# Medium (25.56%)
# Total Accepted:    195.5K
# Total Submissions: 765K
# beats 100.0% of python submissions

# Definition for singly-linked list with a random pointer.
class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None


class Solution(object):
    def copyRandomList(self, head):
        dic = {}
        m = n = head
        while m:  # copy node itself
            dic[m] = RandomListNode(m.label)
            m = m.next
        while n:  # link the node and copy the random pointer of the current node
            dic[n].next = dic.get(n.next)
            dic[n].random = dic.get(n.random)
            n = n.next
        return dic.get(head)
